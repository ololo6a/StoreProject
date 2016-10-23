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
 * Display all request to master from users
 */
@WebServlet( urlPatterns = "/masterRequest")
public class MasterRequest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String email = request.getParameter("id");
        String is = request.getParameter("is");


        if (is.equals("accept")) {
            People people = Connection.getFactory().getPeopleDao().getPeopleByEmail(email);
            people.setType("master");
            Connection.getFactory().getPeopleDao().updatePeopleByEmail(people.getEmail(), people);
        }
        Connection.getFactory().getBeMasterDao().deleteByEmail(email);

        doGet(request, response);
    }

    /** TO MASTER REQUEST PAGE
     * @param request request
     * @param response response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        LinkedList<People> allreq= ( LinkedList<People>) Connection.getFactory().getBeMasterDao().getAll();
        request.setAttribute("allreq",allreq);
        request.getRequestDispatcher("/WEB-INF/jsp/admin/masterRequest.jsp").forward(request, response);

    }
}