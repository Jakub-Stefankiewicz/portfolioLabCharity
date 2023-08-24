<%--
  Created by IntelliJ IDEA.
  User: pannorris
  Date: 28.07.2023
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="admin-header.jsp" %>

<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">Instytucje</h1>


<!-- DataTales Example -->
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Lista wszystkich instytucji</h6>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                <tr>
                    <th>Nazwa instytucji</th>
                    <th>Opis intytucji</th>
                    <th>Dostępne akcje</th>
                </tr>
                </thead>
                <tfoot>
                <tr>
                    <th>Nazwa instytucji</th>
                    <th>Opis intytucji</th>
                    <th>Dostępne akcje</th>
                </tr>
                </tfoot>
                <tbody>
                <c:forEach items="${institutions}" var="institution">
                    <tr>
                        <td>${institution.name}</td>
                        <td>${institution.description}</td>
                        <td>
                            <a href="/admin/institutions/delete/${institution.id}"
                               class="btn btn-danger btn-icon-split"
                               onclick="return confirm(`Czy na pewno chcesz usunąć instytucję?`)">
                                        <span class="icon text-white-50">
                                            <i class="fas fa-trash"></i>
                                        </span>
                                <span class="text">Usuń instytucję</span>
                            </a>
                            <a href="/admin/institutions/edit/${institution.id}"
                               class="btn btn-info btn-icon-split">
                                        <span class="icon text-white-50">
                                            <i class="fas fa-info-circle"></i>
                                        </span>
                                <span class="text">Edytuj instytucję</span>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<a href="/admin/institutions/add"
   class="btn btn-success btn-icon-split">
                                        <span class="icon text-white-50">
                                            <i class="fas fa-info-circle"></i>
                                        </span>
    <span class="text">Dodaj nową instytucję</span>
</a>

<%@ include file="admin-footer.jsp" %>

