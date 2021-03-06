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
            <a class="navbar-brand" href="http://tictactoe-project.herokuapp.com">Tic Tac Toe</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/show">Results</a></li>
                <li><a href="https://github.com/Xryaznov/TicTacToe" target="_blank">GitHub</a></li>
                <li><a href="mailto:xryaznov@gmail.com">Contact</a></li>
            </ul>
        </div>
        <!--/.nav-collapse -->
    </div>
</nav>


<style>

    .table tbody tr td {
        border-top: solid gainsboro 1px;
    }


</style>

<div class="starter-template container">
        <table class="table" style="width: 400px;">
            <thead>
            </thead>
            <tbody>
            <tr>
                <td>Game</td>
                <td>Player 1</td>
                <td>Player 2</td>
                <td>Result</td>
            </tr>

            <c:forEach var="game" items="${history}">
                <tr>
                    <td>
                        <c:out value="${game.game_id}"></c:out>
                    </td>
                    <td>
                        <c:out value="${game.player1}"></c:out>
                    </td>
                    <td>
                        <c:out value="${game.player2}"></c:out>
                    </td>
                    <td>
                        <c:out value="${game.result}"></c:out>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        </div>

<style>


    body {
        padding-top: 50px;
    }

    .starter-template {
        padding: 40px 15px;
        text-align: center;
    }

</style>

</body>
</html>



