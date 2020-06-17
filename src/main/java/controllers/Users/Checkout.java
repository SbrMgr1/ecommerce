package controllers.Users;

import models.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet("/account/checkout")
public class Checkout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HashMap<Long, Product> oldProduct = (HashMap<Long,Product>) req.getSession().getAttribute("cart_item");
        if(oldProduct == null){
            oldProduct = new HashMap<Long,Product>();
        }
        List<Product> products = oldProduct.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());

        if(products.size()<=0){
            resp.sendRedirect("/cart-details");
        }else{
            req.setAttribute("rand_total",products.stream().mapToDouble((pro)->pro.getQty()*pro.getUnitPrice()).sum());
            req.setAttribute("products",products);

            req.getSession().setAttribute("cart_item",null);
            //payment gateaway process is remaining
            req.getRequestDispatcher("/WEB-INF/views/checkout.jsp").forward(req,resp);
        }

    }
}
