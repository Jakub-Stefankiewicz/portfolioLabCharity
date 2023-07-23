<%--
  Created by IntelliJ IDEA.
  User: pannorris
  Date: 23.07.2023
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Document</title>
    <link rel="stylesheet" href="../../resources/css/style.css"/>
</head>
<body>
<header class="header--form-page">
    <nav class="container container--70">
        <ul class="nav--actions">
            <li class="logged-user">
                Witaj Agata
                <ul class="dropdown">
                    <li><a href="#">Profil</a></li>
                    <li><a href="#">Moje zbiórki</a></li>
                    <li><a href="#">Wyloguj</a></li>
                </ul>
            </li>
        </ul>

        <body>

        <%@ include file="header.jsp" %>

        <section class="login-page">

            <h2>Zaloguj się</h2>
            <form action="login" method="post">
                <div class="form-group"><label> Email: <input type="text" name="username"/> </label></div>
                <div class="form-group"><label> Hasło: <input type="password" name="password"/> </label></div>
                <sec:csrfInput/>
                <div class="form-group form-group--buttons"><input type="submit" value="Zaloguj się" class="btn"/></div>
            </form>

        </section>

<%@ include file="footer.jsp" %>








