<%@ page import="db.Country" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: askar
  Date: 11/22/21
  Time: 8:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="vendor/head.jsp" %>
</head>
<body>
<%@include file="vendor/navbar.jsp" %>
<div class="container">
    <div class="row mt-5">
        <div class="col-6 offset-3 ">
            <%
                if (request.getParameter("passworderror") != null) {
            %>
            <div class="alert alert-danger alert-dismissible">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                <strong>Incorect password!</strong>
            </div>
            <%
                }
                if (request.getParameter("emailerror") != null) {
            %>
            <div class="alert alert-danger alert-dismissible">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                <strong>Incorect email!</strong>
            </div>
            <%
                }
            %>
            <form action="/auth" method="post">
                <div class="mt-2">
                    <label>
                        EMAIL:
                    </label>
                    <input type="email" class="form-control" name="email" required>
                </div>
                <div class="mt-2">
                    <label>
                        PASSWORD:
                    </label>
                    <input type="password" class="form-control" name="password" required>
                </div>
                <div class="mt-2">
                    <button class="btn btn-success">LOGIN</button>
                </div>
                </form>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
</html>
