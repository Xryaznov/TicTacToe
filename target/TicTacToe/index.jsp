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
    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>


    <title>Tic Tac Toe</title>
</head>

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

<div class="container">

    <div class="starter-template">
        <h1>Bootstrap starter template</h1>

        <p class="lead">Use this document as a way to quickly start any new project.<br> All you get is this text and a
            mostly barebones HTML document.</p>
    </div>

</div>

<style>

    <style>
    table, th, td {
        border-collapse: collapse;
    }

    .borderedRight {
        border-right: 1px solid black;
    }

    .borderAtTop {
        border-top: 1px solid black;
    }

    body {
        padding-top: 50px;
    }

    .starter-template {
        padding: 40px 15px;
        text-align: center;
    }

</style>

<h2>Tic Tac Toe</h2>
<table>
    <tr>
        <td id="one" class="borderedRight">X</td>
        <td class="borderedRight">O</td>
        <td>O</td>
    </tr>
    <tr>
        <td class="borderedRight borderAtTop" onclick="">O</td>
        <td class="borderedRight borderAtTop">X</td>
        <td class="borderAtTop">O</td>
    </tr>
    <tr>
        <td class="borderedRight borderAtTop">O</td>
        <td class="borderedRight borderAtTop">O</td>
        <td id="nine" class="borderAtTop">X</td>
    </tr>
</table>

<form>
    <input type=submit formaction="/index" formmethod="get">
</form>

<script>
    document.getElementById('one').onclick = function () {
        alert("one");
    };
    document.getElementById('nine').onclick = function () {
        document.getElementById('nine').innerHTML = '!!!';

    };
</script>

<script>
    //noinspection JSUnresolvedFunction
    $(document).ready(function () {
        console.log("ready!");
    });
</script>


</body>
</html>
