package javacode.servlet.def;

import javacode.DAO.Connection;
import javacode.substance.Master;
import javacode.substance.Order;
import javacode.substance.People;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by Администратор on 22.09.2016.
 */
@WebServlet(name = "MyOrders", urlPatterns = "/myorders")
public class MyOrders extends HttpServlet {
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


        HttpSession session = request.getSession();
        People people = (People) session.getAttribute("user_session");


        LinkedList<Order> myOrders = ( LinkedList<Order> ) Connection.getFactory().getOrderDao().getById(people.getId_people());
        request.setAttribute("myOrders",myOrders);


        request.getRequestDispatcher("/WEB-INF/jsp/def/orders.jsp").forward(request, response);


    }
}