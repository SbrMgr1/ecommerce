package controllers.Admins;

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

@WebServlet("/administration/deleteCat")
public class ProdCatDeleteController extends HttpServlet {
    private ProductCategoryDao dao;
    Gson mapper=new Gson();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String catId= req.getParameter("id");
        Long id=Long.parseLong(catId);
        dao.deleteProductCategory(Long.valueOf(catId));
        String success="Deleted Successfully!!";
        HashMap<Long, ProductCategory> productCategoryList=dao.getAllCategory();
        PrintWriter out=resp.getWriter();
        out.print(mapper.toJson(success));


    }
}
