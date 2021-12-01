<%@ page import="java.util.ArrayList" %>
<%@ page import="db.User" %>
<%@ page import="db.Country" %><%--
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
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>

<%@include file="vendor/navbar.jsp" %>

<%
    User user = (User) request.getAttribute("user");
%>
<div class="container">
    <div class="row mt-5">
        <div class="col-6 mx-auto">
            <%
                if (request.getParameter("success") != null) {
            %>
            <div class="alert alert-success alert-dismissible fade show">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                <strong>User updated Successfully!</strong> You can check in main page
            </div>
            <%
                }
                if (request.getParameter("error") != null) {
            %>
            <div class="alert alert-danger alert-dismissible fade show">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                <strong>Something went wrong!</strong> User hasn't been updated
            </div>
            <%
                }
            %>
            <form action="/updateUser" method="post">
                <input type="hidden" name="user_id" value="<%=user.getId()%>">
                <div class="mt-2">
                    <label>
                        NAME:
                    </label>
                    <input type="text" class="form-control" name="user_name" value="<%=user.getName()%>">
                </div>
                <div class="mt-2">
                    <label>
                        SURNAME:
                    </label>
                    <input type="text" class="form-control" name="user_surname" value="<%=user.getSurname()%>">
                </div>
                <div class="mt-2">
                    <label>
                        AGE:
                    </label>
                    <input type="number" class="form-control" name="user_age" value="<%=user.getAge()%>">
                </div>
                <div class="mt-2">
                    <label>
                        COUNTRY:
                    </label>
                    <select class="form-select" name="user_country">
                        <%
                            ArrayList<Country> countries = (ArrayList<Country>) request.getAttribute("countries");
                            if (countries != null) {
                                for (Country country : countries) {

                        %>
                        <option value="<%=country.getId()%>" <%=user.getCountry().getId().equals(country.getId()) ? "selected" : "" %>>
                            <%=country.getName() + "/" + country.getCode()%>
                        </option>
                        <%
                                }
                            }
                        %>
                    </select>
                </div>
                <div class="mt-2">
                    <label>
                        GENDER:
                    </label>
                    <div class="mt-2">
                        <input type="radio" name="user_gender" value="male"
                               <%=user.getGender().equals("male") ? "checked":""%>readonly>Male <br>
                        <input type="radio" name="user_gender" value="female"
                               <%=user.getGender().equals("female") ? "checked":""%>readonly>Female
                    </div>
                </div>

                <div>
                    <div class="mt-2">
                        <button class="btn btn-success">UPDATE USER</button>
                    </div>
                </div>


            </form>

            <form action="/deleteUser" method="post">
                <input type="hidden" name="user_id" value="<%=user.getId()%>">
                <div class="mt-2">
                    <button class="btn btn-danger">DELETE USER</button>
                </div>
            </form>

        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
</html>
