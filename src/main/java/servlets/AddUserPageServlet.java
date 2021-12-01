package servlets;

import db.Country;
import db.DBManager;
import sun.security.pkcs11.Secmod;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/adduserpage")
public class AddUserPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Country> countries = DBManager.getCountries();

        request.setAttribute("countries", countries);
        request.getRequestDispatcher("/addUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
