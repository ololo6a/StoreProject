package javacode.servlet.def;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
/**
 * Created by Администратор on 22.09.2016.
 */
@WebServlet(name = "SignOut", urlPatterns = "/signout")
public class SignOut extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * Logout, invalidate session
     * @param request request
     * @param response response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.logout();
        final HttpSession session = request.getSession(false);
        if (session!= null){
            session.invalidate();
        }
        request.getRequestDispatcher("/homeServlet").forward(request, response);
    }
}