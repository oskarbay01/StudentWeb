package servlets;

import db.Country;
import db.DBManager;
import db.User;
import org.omg.CORBA.CODESET_INCOMPATIBLE;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/addUser")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("user_name");
        String surname = request.getParameter("user_surname");
        int age = Integer.parseInt(request.getParameter("user_age"));
        String gender = request.getParameter("user_gender");
        Long  countryId = Long.parseLong(request.getParameter("user_country"));

        Country country = new Country();
        country.setId(countryId);

        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setAge(age);
        user.setGender(gender);
        user.setCountry(country);

        boolean isAdded = DBManager.addUser(user);
        if (isAdded) {
            response.sendRedirect("/adduserpage?success");
        } else {
            response.sendRedirect("/adduserpage?error");
        }
        //request.getRequestDispatcher("/index.jsp").forward(request,response);
        // response.sendRedirect("/index.jsp");
    }
}
