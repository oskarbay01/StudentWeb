<%@ page import="java.util.ArrayList" %>
<%@ page import="db.User" %><%--
  Created by IntelliJ IDEA.
  User: askar
  Date: 11/15/21
  Time: 3:35 PM
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
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">NAME</th>
                <th scope="col">SURNAME</th>
                <th scope="col">AGE</th>
                <th scope="col">GENDER</th>
                <th scope="col">COUNTRY</th>
                <th scope="col">DETAILS</th>
            </tr>
            </thead>
            <tbody>
            <%
                ArrayList<User> users = (ArrayList<User>) request.getAttribute("usersList");
                if (users != null) {
                    for (User user : users) {
            %>
            <tr>
                <td><%=user.getId() %></td>
                <td><%=user.getName()%></td>
                <td><%=user.getSurname()%></td>
                <td><%=user.getAge()%></td>
                <td><%=user.getGender()%></td>
                <td><%=user.getCountry().getName()%> / <%=user.getCountry().getCode()%></td>
                <td>
                    <a href="/details?id=<%=user.getId()%>">Details</a>
                </td>
            </tr>
            <%
                    }
                }
            %>
            </tbody>
        </table>
    </div>
</div>
</body>

</html>
