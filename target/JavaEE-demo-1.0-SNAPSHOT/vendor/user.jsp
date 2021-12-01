<%@ page import="db.Account" %>
<%
    Account currentUser = (Account) request.getSession().getAttribute("CURRENT_USER");

    boolean ONLINE = false;

    if (currentUser != null) {
        ONLINE = true;
    }
%>