package javacode.servlet.admin;

/**
 * Created by Администратор on 16.09.2016.
 */
import javacode.DAO.Connection;
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
 * Change selected product
 */
@WebServlet( urlPatterns = "/change")
@MultipartConfig(maxFileSize = 16177215)
public class Change extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        int id = Integer.parseInt(request.getParameter("id"));
        Product p = Connection.getFactory().getProductDao().getById(id);
        String type = request.getParameter("type");
        Part part = request.getPart("photo");
        if (part.getSubmittedFileName().equals("")) part=null;

        p.setName(request.getParameter("name"));
        p.setType(request.getParameter("ptype"));
        p.setCount(Integer.parseInt(request.getParameter("count")));
        p.setPrice(Double.parseDouble(request.getParameter("price")));

        Connection.getFactory().getProductDao().change(id,p,part);
        doGet(request,response);
    }


    /**

     * @param request request
     * @param response response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String Sid = request.getParameter("id");
        int id = 0;
        if (Sid!=null) id = Integer.parseInt(Sid);

        Product p = Connection.getFactory().getProductDao().getById(id);
        request.setAttribute("product",p);

        request.getRequestDispatcher("/WEB-INF/jsp/admin/change.jsp").forward(request, response);
    }


}