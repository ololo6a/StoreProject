package javacode.filters;


import javacode.substance.People;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter(urlPatterns = {"/change","/mythings","/newthing"})
public class NotUserFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        People people = (People) request.getSession().getAttribute("user_session");
        if ( people==null ) {
            request.getRequestDispatcher("/singin").forward(request, response);
            return;
        }
        if (people.getType().equals("user")){
            request.getRequestDispatcher("/homeServlet").forward(request, response);
            return;
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}