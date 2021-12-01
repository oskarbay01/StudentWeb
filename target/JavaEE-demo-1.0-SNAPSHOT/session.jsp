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
        <div class="col-6 mx-auto">

            <%
                String sessionValue = (String) request.getAttribute("text");
                if (sessionValue != null) {

            %>
            <h1><%=sessionValue%>
            </h1>
            <%
                }
            %>
            <form action="/setsession" method="post">
                <div class="mt-2">
                    <label>
                        NAME:
                    </label>
                    <input type="text" class="form-control" name="user_name">
                </div>
                <div class="mt-2">
                    <button class="btn btn-success">ADD SESSION</button>
                </div>
            </form>
            <a class="btn btn-danger" href="/deletesession">DELETE SESSION</a>
            <br>
            <%
                ArrayList<String> basket = (ArrayList<String>) request.getSession().getAttribute("basket");
                if (basket != null) {
                    for (String b :
                            basket) {
            %>
            <h3 class="text-center">
                <%=b%>
            </h3>
            <%
                    }
                }
            %>
            <form action="/addtobasket" method="post">
                <div class="mt-2">
                    <label>
                        ITEM NAME:
                    </label>
                    <input type="text" class="form-control" name="basket_value">
                </div>
                <div class="mt-2">
                    <button class="btn btn-success">ADD SESSION</button>
                </div>
            </form>
            <form action="/clearbasket" method="post">
                <button class="btn btn-danger">CLEAR BASKET</button>
            </form>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
</html>
