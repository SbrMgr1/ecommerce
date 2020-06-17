package controllers.Admins;

import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/administration/delete-user")
public class UserDeleteController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HashMap<String, User> userlist = (HashMap<String, User>) this.getServletContext().getAttribute("users");
        String user_email = req.getParameter("email");

        userlist.remove(user_email);
        this.getServletContext().setAttribute("users", userlist);

    }
}
