package controllers.Admins;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet("/administration/user")
public class User extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<String, models.User> userlist = (HashMap<String, models.User>) this.getServletContext().getAttribute("users");

        req.setAttribute("users_for_crud",userlist.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList()));
        req.getRequestDispatcher("/WEB-INF/views/admins/user_crud.jsp").forward(req,resp);

    }
}
