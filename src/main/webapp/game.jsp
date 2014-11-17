<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>

    <title>Tic Tac Toe</title>
</head>
<body>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Project name</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#about">About</a></li>
                <li><a href="#contact">Contact</a></li>
            </ul>
        </div>
        <!--/.nav-collapse -->
    </div>
</nav>


<style>


    .td {
        height: 38px;
        width: 52px;
        border-left: 1px solid black;
        border-right: 1px solid black;
        border-top: 1px solid black;
        border-bottom: 1px solid black;
    }

    .td-left {
        border-left: 0px solid black;
    }

    .td-right {
        border-right: 0px solid black;
    }

    .td-bottom {
        border-bottom: 0px solid black;
    }

    .table tbody tr td {
        border-top: none;
    }


</style>
<form id="form" action="/move" method="post">
    <div class="container">
        <div class="starter-template">
            <h1>TIC TAC TOE</h1>


            Game id: <c:out value="${game.game_id}"/>
            </br>
            Player 1: <c:out value="${game.player1}"/>
            </br>
            Player 2: <c:out value="${game.player2}"/>
            </br>
            <div id="gameStatus"></div>
            </br>


            <div class="starter-template col-lg-6 col-lg-offset-5 text-center">

                <table class="table" style="width: 150px; border: none">
                    <tbody style="border: none">
                    <tr style="border: none">
                        <c:set var="gameString" value="${gameStatus}"/>
                        <td id='0' class="td td-left"><c:out value="${fn:substring(gameString, 0, 1)}"/></td>
                        <td id='1' class="td"><c:out value="${fn:substring(gameString, 1, 2)}"/></td>
                        <td id='2' class="td td-right"><c:out value="${fn:substring(gameString, 2, 3)}"/></td>
                    </tr>
                    <tr>
                        <td id='3' class="td td-left"><c:out value="${fn:substring(gameString, 3, 4)}"/></td>
                        <td id='4' class="td"><c:out value="${fn:substring(gameString, 4, 5)}"/></td>
                        <td id='5' class="td td-right"><c:out value="${fn:substring(gameString, 5, 6)}"/></td>
                    </tr>
                    <tr>
                        <td id='6' class="td-left td-bottom"><c:out value="${fn:substring(gameString, 6, 7)}"/></td>
                        <td id='7' class="td td-bottom"><c:out value="${fn:substring(gameString, 7, 8)}"/></td>
                        <td id='8' class="td td-bottom td-right"><c:out value="${fn:substring(gameString, 8, 9)}"/></td>
                    </tr>
                    </tbody>
                </table>

            </div>
        </div>
    </div>
</form>

<style>


    body {
        padding-top: 50px;
    }

    .starter-template {
        padding: 40px 15px;
        text-align: center;
    }

</style>

<script>
    $('td').click(function (event) {
        var fieldNumber = $(this).attr('id');

        $.get("/move", {cell: fieldNumber}).done(function () {
            reload();
        });
    });
</script>

<script>
    function reload() {
        $('#form').submit();
    }
</script>

<script>

    setInterval(function () {
            reload()
    }, 10000);

</script>

</body>
</html>



