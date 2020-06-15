package controllers.Admins;

import com.google.gson.Gson;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet("/administration/user")
public class UserController extends HttpServlet {

    Gson mapper = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<String, models.User> userlist = (HashMap<String, models.User>) this.getServletContext().getAttribute("users");

        req.setAttribute("users_for_crud",userlist.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList()));
        req.getRequestDispatcher("/WEB-INF/views/admins/user_crud.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jsonString = req.getParameter("userdata");
        User user = mapper.fromJson(jsonString, User.class);
        HashMap<String, User> userlist = (HashMap<String, User>) this.getServletContext().getAttribute("users");
        userlist.put(user.getEmail(), user);
        this.getServletContext().setAttribute("users", userlist);

        PrintWriter out = resp.getWriter();

//        out.print(userlist.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList()));
        out.print(mapper.toJson(user));
        System.out.println(mapper.toJson(user));
    }
}
