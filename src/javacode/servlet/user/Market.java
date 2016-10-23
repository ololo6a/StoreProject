package javacode.servlet.user;

import com.sun.org.apache.xpath.internal.SourceTree;
import com.sun.org.glassfish.external.statistics.CountStatistic;
import javacode.DAO.Connection;
import javacode.Md5;
import javacode.substance.BeMaster;
import javacode.substance.Master;
import javacode.substance.People;
import javacode.substance.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.Enumeration;
import java.util.LinkedList;

/**
 * Created by Администратор on 22.09.2016.
 */

/**
 *  Buy button
 */
@WebServlet(name = "Market", urlPatterns = "/market")
public class Market extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        int prod = Integer.parseInt(request.getParameter("prod"));
        int count = Integer.parseInt(request.getParameter("count"+Integer.toString(prod)));
        String type = request.getParameter("id");
        request.setAttribute("id",type);
        HttpSession session = request.getSession();
        People people = (People) session.getAttribute("user_session");
        if (people!=null) {

            Date d = new Date(System.currentTimeMillis());
            Master m = Connection.getFactory().getProductDao().getAuthor(prod);
            Product p = Connection.getFactory().getProductDao().getById(prod);
            People mp = new People();
            mp.setEmail(m.getEmail());


            if (m != null && p != null && people.getBalance() >= count * p.getPrice()) {
                boolean correct = false;
                boolean neworder = false;
                if (p.getCount()>=count) correct=true;
                Connection.getFactory().getProductDao().changeCount(prod, count * -1);
                if (correct) {neworder = Connection.getFactory().getOrderDao().NewOrder(people.getId_people(), m.getId_people(), prod, count, p.getPrice(), d.toString(),people.getAddres(),people.getFirstName(), people.getSecondName());}
                if (neworder) {
                    Connection.getFactory().getPeopleDao().addSellOrder(m.getId_people());
                    Connection.getFactory().getPeopleDao().addBuyOrder(people.getId_people());
                    Connection.getFactory().getPeopleDao().addBalance(people, -1 * count * p.getPrice());
                    Connection.getFactory().getPeopleDao().addBalance(mp, count * p.getPrice());
                }
            }


            People people1 = Connection.getFactory().getPeopleDao().getPeopleByEmail(people.getEmail());
            session.setAttribute("user_session", people1);
        }
        doGet(request,response);
    }

    /**
     * To Market page
     * @param request request
     * @param response response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String type = request.getParameter("id");
        LinkedList<Product> allmy =  Connection.getFactory().getProductDao().getAllWithType(1,type);
        request.setAttribute("allmy",allmy);

        request.getRequestDispatcher("/WEB-INF/jsp/def/market.jsp").forward(request, response);
    }
}