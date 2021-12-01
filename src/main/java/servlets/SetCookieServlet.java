package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/setcookie")
public class SetCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("user_name");
        String surname = request.getParameter("user_surname");
        String age = request.getParameter("user_age");

        Cookie nameCookie = new Cookie("name_cookie", name);
        Cookie surnameCookie = new Cookie("surname_cookie", surname);
        Cookie ageCookie = new Cookie("age_cookie", age);

        nameCookie.setMaxAge(3600*24*30);
        surnameCookie.setMaxAge(3600*24*30);
        ageCookie.setMaxAge(3600*24*30);

        response.addCookie(nameCookie);
        response.addCookie(surnameCookie);
        response.addCookie(ageCookie);

        response.sendRedirect("/cookies");
    }
}
