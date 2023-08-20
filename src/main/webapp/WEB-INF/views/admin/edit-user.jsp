<%--
  Created by IntelliJ IDEA.
  User: pannorris
  Date: 29.07.2023
  Time: 15:06
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
  <link rel="stylesheet" href="../../../resources/css/style.css"/>
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
          <li><a href="#">Wyloguj</a></li>
        </ul>
      </li>
    </ul>

    <body>

    <%@ include file="../header.jsp" %>

    <section class="login-page">
      <h2>Edytuj admina</h2>
      <form:form method="post" modelAttribute="userToEdit">
        <div class="form-group">
          <form:input path="username" placeholder="login"/><form:errors path="username"
                                                                        cssClass="error"/>
        </div>
        <div class="form-group">
          <form:input path="name" placeholder="imię"/><form:errors path="name"
                                                                   cssClass="error"/>
        </div>
        <div class="form-group">
          <form:input path="lastName" placeholder="nazwisko"/><form:errors path="lastName"
                                                                           cssClass="error"/>
        </div>
        <div class="form-group">
          <form:select path="enabled">
            <form:option value="1" label="Aktywny"/>
            <form:option value="-1" label="Nieaktywny"/>
          </form:select>
        </div>

        <form:hidden path="id"/>
        <form:hidden path="password"/>
        <form:hidden path="roles"/>
        <div class="form-group form-group--buttons">
          <input type="submit" class="btn" value="Zapisz admina"/>
        </div>
      </form:form>
    </section>

    <%@ include file="../footer.jsp" %>
