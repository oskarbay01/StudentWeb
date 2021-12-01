package servlets;

import db.Country;
import db.DBManager;
import db.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/updateUser")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("user_id"));
        String name = request.getParameter("user_name");
        String surname = request.getParameter("user_surname");
        int age = Integer.parseInt(request.getParameter("user_age"));
        Long countryId = Long.parseLong(request.getParameter("user_country"));

        Country country = new Country();
        country.setId(countryId);

        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setAge(age);
        user.setId(id);
        user.setCountry(country);

        boolean isSuccess = DBManager.updateUser(id, user);
        if (isSuccess) {
            response.sendRedirect("/details?id=" + id + "&success");
        } else {
            response.sendRedirect("/details?id=" + id + "&error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
