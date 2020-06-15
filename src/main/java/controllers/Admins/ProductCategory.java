package controllers.Admins;

import com.google.gson.Gson;
import models.CMS;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/administration/product-cat")
public class ProductCategory extends HttpServlet {
    Gson mapper=new Gson();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/admins/productCategory.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productCat=req.getParameter("pc");
        System.out.println(productCat);
        ProductCategory pc=mapper.fromJson(productCat, ProductCategory.class);
        PrintWriter out = resp.getWriter();
        out.print(mapper.toJson(pc));
    }
}
