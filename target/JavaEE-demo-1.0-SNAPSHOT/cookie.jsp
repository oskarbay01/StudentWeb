<%@ page import="db.Country" %><%--
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
    <%@include file="vendor/head.jsp"%>
</head>
<body>
<%@include file="vendor/navbar.jsp" %>
<div class="container">
    <div class="row mt-5">
        <div class="col-6 mx-auto">
            <%
                String userData = (String) request.getAttribute("userdata");
                if(userData!=null){
            %>
            <h1 class="display-1"><%=userData%></h1>
            <%
                }
            %>
            <form action="/setcookie" method="post">
                <div class="mt-2">
                    <label>
                        NAME:
                    </label>
                    <input type="text" class="form-control" name="user_name">
                </div>
                <div class="mt-2">
                    <label>
                        SURNAME:
                    </label>
                    <input type="text" class="form-control" name="user_surname">
                </div>
                <div class="mt-2">
                    <label>
                        AGE:
                    </label>
                    <input type="text" class="form-control" name="user_age">
                </div>
                <div class="mt-2">
                    <button class="btn btn-success">ADD USER</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
</html>
