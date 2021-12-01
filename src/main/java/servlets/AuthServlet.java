package servlets;

import db.Account;
import db.DBManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/auth")
public class AuthServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        String redirect = "/login?emailerror";

        Account account = DBManager.getAccount(email);

        if (account != null) {
            redirect = "/login?passworderror";

            if (account.getPassword().equals(password)) {
                request.getSession().setAttribute("CURRENT_USER)", account);
                redirect = "/";
            }
        }
        response.sendRedirect(redirect);
    }
}
