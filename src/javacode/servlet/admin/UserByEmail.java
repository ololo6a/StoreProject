package javacode.servlet.admin;

/**
 * Created by Администратор on 16.09.2016.
 */
import javacode.DAO.Connection;
import javacode.substance.Master;
import javacode.substance.Order;
import javacode.substance.People;
import org.apache.commons.codec.binary.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * GO TO HOME PAGE
 */
@WebServlet( urlPatterns = "/userbyemail")
public class UserByEmail extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("newemail");
        if (email.equals("")) doGet(request,response);
        People people = Connection.getFactory().getPeopleDao().getPeopleByEmail(email);
        LinkedList<Order> myOrders = (LinkedList<Order>) Connection.getFactory().getOrderDao().getById(people.getId_people());
        request.setAttribute("people",people);
        request.setAttribute("myOrders",myOrders);

        byte[] imgData = Connection.getFactory().getMasterDao().getImageByEmail(people.getEmail());
        String base64Encoded = null;
        if (imgData!=null) {
            byte[] decode = Base64.encodeBase64(imgData);
            base64Encoded = new String(decode, "UTF-8");
        }
        Master master = new Master();
        master.setStringImage(base64Encoded);
        request.setAttribute("master",master);
        doGet(request,response);
    }


    /**

     * @param request request
     * @param response response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/jsp/admin/userbyemail.jsp").forward(request, response);
    }


}