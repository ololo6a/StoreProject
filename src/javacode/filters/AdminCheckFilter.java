package javacode.filters;


import javacode.substance.People;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter(filterName = "AdminCheckFilter",urlPatterns =  {"/addbalance","/allmasters","/masterRequest","/userbyemail"} )
public class AdminCheckFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

            People people = (People) request.getSession().getAttribute("user_session");
            if (people == null) people = new People();
            if (!people.getType().equals("admin")) {
                request.getRequestDispatcher("/homeServlet").forward(request, response);
                return;
            }

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}