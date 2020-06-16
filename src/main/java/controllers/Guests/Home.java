package controllers.Guests;

import Dao.ProductDao;
import models.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("")
public class Home extends HttpServlet {

    List<Product> tmp;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProductDao productDao = (ProductDao) this.getServletContext().getAttribute("productDao");
        List<Product> products = productDao.getProducts();
        req.setAttribute("title",this.getServletContext().getInitParameter("sitename"));
        String param = req.getParameter("param");
        String priceSort = req.getParameter("priceSort");

        if(param == null){
            if(priceSort == null){
                tmp = products.stream().collect(Collectors.toList());
            }else{
                if (priceSort.equals("asc")){
                    tmp = products.stream().sorted((p1,p2)->(int)(p1.getUnitPrice()-p2.getUnitPrice())).collect(Collectors.toList());
                }else if(priceSort.equals("desc")){
                    tmp = products.stream().sorted((p1,p2)->(int)(p2.getUnitPrice()-p1.getUnitPrice())).collect(Collectors.toList());
                }else{
                    tmp = products.stream().collect(Collectors.toList());
                }
            }


        }else{
            if(priceSort == null){
                tmp = products.stream().filter(product -> product.getName().toLowerCase().contains(param.toLowerCase())).collect(Collectors.toList());
            }else{
                if (priceSort.equals("asc")){
                    tmp = products.stream().filter(product -> product.getName().toLowerCase().contains(param.toLowerCase())).sorted((p1,p2)->(int)(p1.getUnitPrice()-p2.getUnitPrice())).collect(Collectors.toList());
                }else if(priceSort.equals("desc")){
                    tmp = products.stream().filter(product -> product.getName().toLowerCase().contains(param.toLowerCase())).sorted((p1,p2)->(int)(p2.getUnitPrice()-p1.getUnitPrice())).collect(Collectors.toList());
                }else{
                    tmp = products.stream().filter(product -> product.getName().toLowerCase().contains(param.toLowerCase())).collect(Collectors.toList());
                }
            }


        }
        if(tmp == null){
            tmp = new ArrayList<Product>();
        }
        req.setAttribute("products",tmp);

        req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req,resp);
    }
}
