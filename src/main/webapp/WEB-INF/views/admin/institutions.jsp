<%--
  Created by IntelliJ IDEA.
  User: pannorris
  Date: 28.07.2023
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
            <li class="logged-userCharity">
                Witaj Agata
                <ul class="dropdown">
                    <li><a href="#">Profil</a></li>
                    <li><a href="#">Moje zbiórki</a></li>
                    <li>
                        <form action="<c:url value="/logout"/>" method="post">
                            <input type="submit" value="Wyloguj">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        </form>
                    </li>
                </ul>
            </li>
        </ul>

        <body>

        <%@ include file="../header.jsp" %>

        <section class="help">
            <div class="help--slides active" data-id="1">
            <ul class="help--slides-items">
            <c:forEach items="${institutions}" var="institution">
                <div class="col">
                    <div class="title">${institution.name}</div>
                    <div class="subtitle">${institution.description}</div>
                    <form action="/admin/institutions/edit/${institution.id}">
                        <input type="submit" class="btn" value="Edytuj fundację"/>
                    </form>
                    <form action="/admin/institutions/delete/${institution.id}">
                        <input type="submit" class="btn"  onclick="return confirm('Are you sure?')" value="Usuń fundację"/>
                    </form>
                </div>
            </c:forEach>
                <form action="/admin/institutions/add">
                    <input type="submit" class="btn" value="Dodaj nową fundację"/>
                </form>
            </ul>
            </div>
        </section>

        <%@ include file="../footer.jsp" %>
