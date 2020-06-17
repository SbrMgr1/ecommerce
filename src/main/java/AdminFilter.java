import models.User;
import models.UserRoles;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "admin-authentication")
public class AdminFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        HttpServletRequest httpReqest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResp = (HttpServletResponse) servletResponse;
        User admin = (User) httpReqest.getSession().getAttribute("adminInfo");
        //filterChain.doFilter(servletRequest, servletResponse);
        if(admin == null){
            httpResp.sendRedirect("/login");//redirecting to login page
        }else if(admin.getRole() == UserRoles.ADMIN){
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            System.out.println("session expired");
            httpResp.sendRedirect("/login");//redirecting to login page
        }
    }

    @Override
    public void destroy() {

    }
}
