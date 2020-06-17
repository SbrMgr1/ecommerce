import models.User;
import models.UserRoles;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "authentication")
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        HttpServletRequest httpReqest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResp = (HttpServletResponse) servletResponse;
        User user = (User) httpReqest.getSession().getAttribute("userInfo");
        if(user == null){
            httpResp.sendRedirect("/login?msg=Please login first.");//redirecting to login page
        }else if(user.getRole() == UserRoles.USER){
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            System.out.println("session expired");
            httpResp.sendRedirect("/login?msg=Please login first.");//redirecting to login page
        }
    }

    @Override
    public void destroy() {

    }
}
