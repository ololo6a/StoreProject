package javacode.servlet.user;

import javacode.DAO.Connection;
import javacode.Md5;
import javacode.substance.BeMaster;
import javacode.substance.People;

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
@WebServlet(name = "BeMasterServlet", urlPatterns = "/bemaster")
public class BeMasterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        People people = (People) session.getAttribute("user_session");
        String s = request.getParameter("text");
        BeMaster be = new BeMaster(0,people.getId_people(),s);
        boolean is = Connection.getFactory().getBeMasterDao().insert(be);

        if (is) {
            request.setAttribute("isit","done");
            doGet(request, response);
            return;
        }
        request.setAttribute("isit","error");
        doGet(request,response);
    }

    /**
     * Logout, invalidate session
     * @param request request
     * @param response response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/def/bemaster.jsp").forward(request, response);
    }
}