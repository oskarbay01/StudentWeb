package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/cookies")
public class CookiesHomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userData = "No data";

        Cookie cookies[] = request.getCookies();
  /*      if (cookies!=null){
            for (Cookie c:
                 cookies) {
                System.out.println(c.getName()+" - "+c.getValue());
            }
        }*/

        String name = "";
        String surname = "";
        String age = "";

        if (cookies != null) {
            for (Cookie c :
                    cookies) {
                if (c.getName().equals("name_cookies")) {
                    name = c.getValue();
                }
                if (c.getName().equals("surname_cookies")) {
                    name = c.getValue();
                }
                if (c.getName().equals("age_cookies")) {
                    name = c.getValue();
                }

            }
        }

        userData = name + " " + surname + " " + age + " years old!";
        request.setAttribute("userData", userData);
        request.getRequestDispatcher("/cookie.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
