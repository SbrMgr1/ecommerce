package controllers.Admins;

import Dao.ProductCategoryDao;
import com.google.gson.Gson;
import models.CMS;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/administration/product-cat")
public class ProductCategory extends HttpServlet {
    private ProductCategoryDao dao;
    Gson mapper = new Gson();

    @Override
    public void init() throws ServletException {
        dao = new ProductCategoryDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductCategory> categoryList = (List<ProductCategory>)this.getServletContext().getAttribute("productCategory");
        req.setAttribute("categoryList",categoryList);

        req.getRequestDispatcher("/WEB-INF/views/admins/productCategory.jsp").forward(req,resp);





    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productCat = req.getParameter("productCategory");
        System.out.println(productCat);
        ProductCategory productCategory = mapper.fromJson(productCat, ProductCategory.class);
        PrintWriter out = resp.getWriter();
        out.print(mapper.toJson(productCategory));


    }
}