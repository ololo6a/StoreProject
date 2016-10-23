package javacode.servlet.def;

/**
 * Created by Администратор on 16.09.2016.
 */
import javacode.DAO.Connection;
import javacode.substance.Master;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * GO TO HOME PAGE
 */
@WebServlet(name = "HomeServlet", urlPatterns = "/homeServlet")
public class HomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    /**
        To home page button
     * @param request request
     * @param response response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LinkedList<Master> all = ( LinkedList<Master> ) Connection.getFactory().getMasterDao().getAll();
        request.setAttribute("master1",all.get(0));
        request.setAttribute("master2",all.get(1));
        request.setAttribute("master3",all.get(2));

        request.getRequestDispatcher("/WEB-INF/jsp/def/home.jsp").forward(request, response);
    }
}