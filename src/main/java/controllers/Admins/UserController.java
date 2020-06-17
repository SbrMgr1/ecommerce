package controllers.Admins;

import com.google.gson.Gson;
import helpers.GlobalResp;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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

        GlobalResp response = new GlobalResp();

        String jsonString = req.getParameter("userdata");
        User user = mapper.fromJson(jsonString, User.class);

        HashMap<String, User> usermap = (HashMap<String, User>) this.getServletContext().getAttribute("users");
        List<User> userList = usermap.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());

        Long clientUserId = user.getId();
        String clientUserEmail = user.getEmail();

        Optional utmp = userList.stream().filter(u->u.getId() == clientUserId).findFirst();

        int flag;
        if(utmp.isPresent()){
            flag = (int) userList.stream()
                    .filter(u -> u.getEmail().equals(clientUserEmail))
                    .filter(u -> u.getId() != user.getId())
                    .count();
        }else{
            flag = (int) userList.stream()
                    .filter(u -> u.getEmail().equals(clientUserEmail))
                    .count();
        }

        if(flag == 0) {

            usermap.put(user.getEmail(), user);
            response.setStatus(true);
            response.setMessage("User Saved Successfully!!");
            response.setData(user);

        } else {
            response.setMessage("This email has already been taken");
        }

        PrintWriter out = resp.getWriter();
        out.print(mapper.toJson(response));

        System.out.println(mapper.toJson(response));
    }
}
