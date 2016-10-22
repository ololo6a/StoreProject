package javacode.servlet.admin;

/**
 * Created by Администратор on 16.09.2016.
 */
import javacode.DAO.Connection;
import javacode.substance.Master;
import javacode.substance.People;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * GO TO HOME PAGE
 */
@WebServlet( urlPatterns = "/allmasters")
public class AllMasters extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String email = request.getParameter("id") ;
        People people = Connection.getFactory().getPeopleDao().getPeopleByEmail(email);
        if (people.getType().equals("master")) people.setType("user");
        Connection.getFactory().getPeopleDao().updatePeopleByEmail(email,people);
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
        request.setAttribute("all",all);
        request.getRequestDispatcher("/WEB-INF/jsp/admin/allmasters.jsp").forward(request, response);
    }
}