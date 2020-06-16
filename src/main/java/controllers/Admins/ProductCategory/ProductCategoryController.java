package controllers.Admins.ProductCategory;


import Dao.ProductCategoryDao;
import com.google.gson.Gson;
import models.ProductCategory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet("/administration/product-cat")
public class ProductCategoryController extends HttpServlet {

    Gson mapper = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProductCategoryDao productCategoryDao = (ProductCategoryDao)this.getServletContext().getAttribute("categoryDao");

        System.out.println(productCategoryDao);
        List<ProductCategory> categoryList = productCategoryDao.getAllCategory().entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
        req.setAttribute("categoryList",categoryList);

        req.getRequestDispatcher("/WEB-INF/views/admins/productCategory.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String productCat = req.getParameter("cat");
        System.out.println(productCat);
        ProductCategory productCategory = mapper.fromJson(productCat, ProductCategory.class);
        ProductCategoryDao productCategoryDao = (ProductCategoryDao)this.getServletContext().getAttribute("categoryDao");
        productCategoryDao.addEditProductCategory(productCategory);

        PrintWriter out = resp.getWriter();
        out.print(mapper.toJson(productCategory));

    }
}