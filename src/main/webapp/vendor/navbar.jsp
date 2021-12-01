<%@include file="user.jsp"%>
<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #3f8d7c">
    <div class="container">
        <a class="navbar-brand" href="/">Student</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/adduserpage">Add User</a>
                </li>

            <%--    <li class="nav-item">
                    <a class="nav-link" href="/cookies">Cookies</a>
                </li>--%>
                <%--<li class="nav-item">
                    <a class="nav-link" href="/sessions">Sessions </a>
                </li>--%>
                <%
                    if (ONLINE){
                %>
                <li class="nav-item">
                    <a class="nav-link" href="/profile"><%=currentUser.getFullname()%></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/logout">Log out</a>
                </li>
                <%
                    }else {
                %>
                <li class="nav-item">
                    <a class="nav-link" href="/login">Login</a>
                </li>

                <%
                    }
                %>
            </ul>
        </div>
    </div>
</nav>