<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

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
    <script src="http://code.jquery.com/jquery-latest.js"></script>

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

<div class="container">
<div class="starter-template">
<h1>TIC TAC TOE</h1>
    <form>
        <input type="text" name="name" placeholder="Enter name">
        <input type="submit" formaction="/main" formmethod="get">
    </form>
<div class="starter-template img-responsive center-block">

    </div>
    <%--table class="table" style="width: 150px">
    <tbody>--%>
<%--<tr>--%>
<%--<td>1</td>--%>
<%--<td>2</td>--%>
<%--<td>3</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>1</td>--%>
<%--<td>2</td>--%>
<%--<td>3</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>1</td>--%>
<%--<td>2</td>--%>
<%--<td id='9'>3</td>--%>
<%--</tr>--%>
<%--</tbody>--%>
<%--</table>--%>
<%--</div>--%>
<%--</div>--%>

<%--</div>--%>

<%--<input type="submit" formaction="/index" formmethod="get">--%>

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
        alert(fieldNumber);
        $.get("/", {field: fieldNumber});


    });
</script>

</body>
</html>



