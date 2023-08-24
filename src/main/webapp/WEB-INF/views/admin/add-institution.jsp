<%--
  Created by IntelliJ IDEA.
  User: pannorris
  Date: 28.07.2023
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="admin-header.jsp" %>


<div class="col-xl-10 col-lg-12 col-md-9">

    <div class="card o-hidden border-0 shadow-lg my-5">
        <div class="card-body p-0">
            <div class="p-5">
                <div class="text-center">
                    <h1 class="h4 text-gray-900 mb-4">Dodaj nową instytucję</h1>
                </div>
                <form:form modelAttribute="institution" method="post" class="user">
                    <div class="form-group">
                        <form:input path="name" class="form-control form-control-user"
                                    id="exampleInputEmail" aria-describedby="emailHelp"
                                    placeholder="Wpisz nazwę instytucji"/><form:errors path="name" cssClass="error"/>
                    </div>
                    <div class="form-group">
                        <form:input path="description" class="form-control form-control-user"
                                    id="exampleInputPassword" placeholder="Podaj opis instytucji"/><form:errors
                            path="description" cssClass="error"/>
                    </div>
                    <input class="btn btn-primary btn-user btn-block" type="submit" value="Dodaj instytucję"/>
                </form:form>
            </div>
        </div>
    </div>
</div>

<%@ include file="admin-footer.jsp" %>


