package controllers.Guests;

import models.User;
import models.UserRoles;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@WebServlet("/signup")
public class SignUp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<String, User> userlist = (HashMap<String, models.User>) this.getServletContext().getAttribute("users");
        User user = userlist.get(req.getParameter("email"));
        if(user == null){
            String errors = "";
            User user1 = new User();
            user1.setRole(UserRoles.USER);
            if(req.getParameter("name").isEmpty()){
                errors += "Name field is required.<br>";
            }else{
                user1.setName(req.getParameter("name"));
            }
            if (req.getParameter("email").isEmpty()){

                errors += "Email field is required.<br>";
            }else{
                if(req.getParameter("email").matches("^([a-zA-Z_0-9]{1,})@([a-zA-Z]{1,}).([a-zA-Z]{1,})$")){
                    user1.setEmail(req.getParameter("email"));
                }else{
                    errors += "Invalid email found.<br>";
                }
            }
            if (req.getParameter("password").isEmpty()){
                errors += "Password field is required.<br>";
            }else{
                user1.setPassword(req.getParameter("password"));
            }
            if(errors.isEmpty()){
                userlist.put(user1.getEmail(),user1);
                resp.sendRedirect("/login?success_msg=Your account has been registered successfully.");
            }else{
                req.setAttribute("errors",errors);
                req.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(req,resp);
            }

        }else{
            req.setAttribute("errors","This email has been already taken. Please try with another email address.");
            req.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(req,resp);
        }
    }
}
