package javacode.servlet.def;

/**
 * Created by Администратор on 16.09.2016.
 */
import javacode.DAO.Connection;
import javacode.Md5;
import javacode.substance.Master;
import javacode.substance.People;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.commons.codec.binary.Base64;
import java.util.LinkedList;

import static javax.swing.text.StyleConstants.ModelAttribute;

/**
 *
 */
@WebServlet(name = "Profile", urlPatterns = "/profile")
@MultipartConfig(maxFileSize = 16177215)
public class Profile extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        People people= (People) session.getAttribute("user_session");
        Part filePart = request.getPart("photo");

        String  email =  people.getEmail();
        people.setEmail(request.getParameter("email"));
        people.setFirstName(request.getParameter("firstName"));
        people.setSecondName(request.getParameter("secondName"));
        people.setAddres(request.getParameter("addres"));

        if (!request.getParameter("password").equals("")) {
            people.setPassHash(Md5.md5Custom(request.getParameter("password")));
        }

        boolean text = Connection.getFactory().getPeopleDao().updatePeopleByEmail(email,people);

        if (!people.getType().equals("user")) {
            if (!filePart.getSubmittedFileName().equals("")) {
                boolean ans = Connection.getFactory().getMasterDao().insertImageByEmail(people.getEmail(), filePart);
            }
        }

        session.setAttribute("user_session",people);
        doGet(request,response);
    }

    /**

     * @param request request
     * @param response response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        People people = (People) session.getAttribute("user_session");
        byte[] imgData = Connection.getFactory().getMasterDao().getImageByEmail(people.getEmail());
        String base64Encoded = null;
        if (imgData!=null) {
            byte[] decode = Base64.encodeBase64(imgData);
            base64Encoded = new String(decode, "UTF-8");
        }
        Master master = new Master();
        master.setStringImage(base64Encoded);
        request.setAttribute("master",master);


        request.getRequestDispatcher("/WEB-INF/jsp/def/profile.jsp").forward(request, response);
    }

}