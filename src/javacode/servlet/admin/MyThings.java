package javacode.servlet.admin;

/**
 * Created by Администратор on 16.09.2016.
 */
import javacode.DAO.Connection;
import javacode.DAO.interfaces.DaoFactory;
import javacode.substance.Master;
import javacode.substance.People;
import javacode.substance.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * GO TO HOME PAGE
 */
@WebServlet( urlPatterns = "/mythings")
@MultipartConfig(maxFileSize = 16177215)
public class MyThings extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        boolean ans =Connection.getFactory().getProductDao().setInvisibleOrDeleteById(id);
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

        HttpSession session = request.getSession();
        People people= (People) session.getAttribute("user_session");
        LinkedList<Product> allmy =  Connection.getFactory().getProductDao().getMy(people.getId_people());
        request.setAttribute("allmy",allmy);


        request.getRequestDispatcher("/WEB-INF/jsp/admin/mythings.jsp").forward(request, response);
    }
}