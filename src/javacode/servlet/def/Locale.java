package javacode.servlet.def;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Servlet for working with locale
 */
@WebServlet(name = "Locale", urlPatterns = "/change_locale")
public class Locale extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    /**
     * Set choosen locale
     * @param request request
     * @param response response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String locale = request.getParameter("locale");
        request.getSession().setAttribute("javax.servlet.jsp.jstl.fmt.locale.session", locale);
        request.getRequestDispatcher("/WEB-INF/jsp/def/home.jsp").forward(request, response);
    }
}