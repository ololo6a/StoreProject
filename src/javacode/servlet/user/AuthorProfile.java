package javacode.servlet.user;

import javacode.DAO.Connection;
import javacode.Md5;
import javacode.substance.BeMaster;
import javacode.substance.Master;
import javacode.substance.People;
import javacode.substance.Product;
import org.apache.commons.codec.binary.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;
import java.util.LinkedList;

/**
 * Created by Администратор on 22.09.2016.
 */
@WebServlet(name = "AuthorProfile", urlPatterns = "/authorprofile")
public class AuthorProfile extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    /**
     * Some  Author profile
     * @param request request
     * @param response response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Master m = Connection.getFactory().getMasterDao().getPeopleById(id);
        byte[] imgData = Connection.getFactory().getMasterDao().getImageByEmail(m.getEmail());
        String base64Encoded = null;
        if (imgData!=null) {
            byte[] decode = Base64.encodeBase64(imgData);
            base64Encoded = new String(decode, "UTF-8");
        }
        m.setStringImage(base64Encoded);
        request.setAttribute("master",m);
        request.getRequestDispatcher("/WEB-INF/jsp/def/authorprofile.jsp").forward(request, response);
    }
}