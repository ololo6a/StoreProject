package javacode.servlet.admin;

/**
 * Created by Администратор on 16.09.2016.
 */
import javacode.DAO.Connection;
import javacode.DAO.interfaces.DaoFactory;
import javacode.substance.Master;
import javacode.substance.People;
import javacode.substance.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Submit new thing button
 */
@WebServlet( urlPatterns = "/newthing")
@MultipartConfig(maxFileSize = 16177215)
public class NewThing extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        People people= (People) session.getAttribute("user_session");
        Part filePart = request.getPart("photo");
        Product p = new Product();
        p.setType(request.getParameter("type"));
        p.setCount(Integer.parseInt(request.getParameter("count")));
        p.setPrice(Double.parseDouble(request.getParameter("price")));
        p.setId_master(people.getId_people());
        p.setName(request.getParameter("name"));

        boolean ans = Connection.getFactory().getProductDao().addThing(p,filePart);

        if (ans) {
            request.setAttribute("isit", "done");
        } else {
            request.setAttribute("isit", "error");
        }

        doGet(request, response);
    }


    /**
     To new thing page
     * @param request request
     * @param response response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/admin/newthing.jsp").forward(request, response);
    }
}