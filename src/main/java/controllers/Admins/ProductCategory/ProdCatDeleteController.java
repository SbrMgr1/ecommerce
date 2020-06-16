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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet("/administration/delete-cat")
public class ProdCatDeleteController extends HttpServlet {

    Gson mapper = new Gson();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String catId = req.getParameter("id");

        ProductCategoryDao productCategoryDao = (ProductCategoryDao)this.getServletContext().getAttribute("categoryDao");
        productCategoryDao.deleteProductCategory(Long.valueOf(catId));

        String success="Deleted Successfully!!";
        resp.getWriter().print(mapper.toJson(success));
    }
}
