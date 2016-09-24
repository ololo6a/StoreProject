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
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * GO TO HOME PAGE
 */
@WebServlet(name = "Signin", urlPatterns = "/signin")
public class Singin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        final String email = request.getParameter("email");
        final String password = request.getParameter("password");
        if (email.trim().isEmpty() || password.trim().isEmpty()) {
         //   logger.debug("Some empty fields");
            request.setAttribute("messageSignIn","empty");
            doGet(request, response);
            return;
        }




        final People people = Connection.getFactory().getPeopleDao().getPeopleByEmail(email);

        if(people == null) {
          //  logger.debug("No user with such email");
            doGet(request, response);
            return;
        }




        if(people.getPassHash().equals(Md5.md5Custom(password))) {
            HttpSession session = request.getSession();
            session.setAttribute("user_session",people);
            request.getRequestDispatcher("/WEB-INF/jsp/def/home.jsp").forward(request, response);
            return;
        }


        doGet(request, response);
    }

    /**
     * @param request request
     * @param response response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.getRequestDispatcher("/WEB-INF/jsp/def/signin.jsp").forward(request, response);
    }
}