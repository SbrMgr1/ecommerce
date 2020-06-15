package controllers.Guests;

import models.User;
import Dao.UserDao;
import models.UserRoles;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {
    UserDao userDao;
    @Override
    public void init() throws ServletException {
        super.init();
        userDao = new UserDao();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title","Signin");
        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userDao.findTheUser(this,(String) req.getParameter("email"),(String) req.getParameter("password"));

        if(user != null){
            HttpSession session = req.getSession();

            if(req.getParameter("remember") != null){
                Cookie cookie = new Cookie("name",req.getParameter("email"));
                cookie.setMaxAge(60*60*24*30);
                resp.addCookie(cookie);
                if (user.getRole() == UserRoles.ADMIN){
                    session.setAttribute("adminInfo",user);
                    resp.sendRedirect("/administration");
                }else{
                    session.setAttribute("userInfo",user);
                    resp.sendRedirect("/account");
                }

            }else{
                Cookie cookie = new Cookie("name",null);
                cookie.setMaxAge(0);
                resp.addCookie(cookie);

                if (user.getRole() == UserRoles.ADMIN){
                    session.setAttribute("adminInfo",user);
                    resp.sendRedirect("/administration");
                }else{
                    session.setAttribute("userInfo",user);
                    resp.sendRedirect("/account");
                }
            }

        }else {
            req.setAttribute("errors","Invalid Credentials.");
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req,resp);
        }
    }
}
