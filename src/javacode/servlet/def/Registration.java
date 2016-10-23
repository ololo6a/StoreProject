package javacode.servlet.def;

/**
 * Created by Администратор on 16.09.2016.
 */
import javacode.DAO.Connection;
import javacode.Md5;
import javacode.substance.People;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Registration button
 */
@WebServlet(urlPatterns = "/registration")
public class Registration extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        final String email = request.getParameter("email");
        final String password = request.getParameter("password");
        final String firstName = request.getParameter("firstName");
        final String secondName = request.getParameter("secondName");
        final String addres = request.getParameter("addres");



        final People people = Connection.getFactory().getPeopleDao().getPeopleByEmail(email);

        if(people != null) {
            request.setAttribute("emailSUP","emailnotunic");
            doGet(request, response);
            return;
        }

        boolean is = Connection.getFactory().getPeopleDao().insertPeople
                (new People(0,"user", Md5.md5Custom(password),email,addres,firstName,secondName,0,0,0));

        if (!is) {
            request.setAttribute("emailSUP","SomthingBAD");
            doGet(request, response);
            return;
        }
        response.sendRedirect("/signin");
    }

    /**
    To Registration page
     * @param request request
     * @param response response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/def/registration.jsp").forward(request, response);
    }
}