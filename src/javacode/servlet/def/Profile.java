package javacode.servlet.def;

/**
 * Created by Администратор on 16.09.2016.
 */
import javacode.DAO.Connection;
import javacode.substance.People;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;

/**
 *
 */
@WebServlet(name = "Profile", urlPatterns = "/profile")
public class Profile extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("PROFILE DO POST");
        HttpSession session = request.getSession();
        People people= (People) session.getAttribute("user_session");
        Part filePart = request.getPart("input-file");
        boolean ans  =  Connection.getFactory().getMasterDao().insertImageByEmail(people.getEmail(),filePart);


        doGet(request,response);
    }

    /**

     * @param request request
     * @param response response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("DO GET START");
        HttpSession session = request.getSession();
        People people= (People) session.getAttribute("user_session");


             byte[] imgData  = Connection.getFactory().getMasterDao().getImageByEmail(people.getEmail());

                if (imgData==null)  {
                    request.setAttribute("imgData",imgData);
                    System.out.println("BLOB IS  NULL");
                    request.getRequestDispatcher("/WEB-INF/jsp/def/profile.jsp").forward(request, response);
                    return;
                }

                response.setContentType("image/gif");
                OutputStream o = response.getOutputStream();
                o.write(imgData);
                o.flush();
                o.close();
        request.setAttribute("image",imgData);
        System.out.println("PROFILE DO GET");
        request.getRequestDispatcher("/WEB-INF/jsp/def/profile.jsp").forward(request, response);

    }
}