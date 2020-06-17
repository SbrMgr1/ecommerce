package controllers.Guests;

import models.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet("/cart-details")
public class CartDetails  extends HttpServlet {
    String cookieValue;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<Long,Product> cartItems = (HashMap<Long,Product>) req.getSession().getAttribute("cart_item");
        if(cartItems == null){
            cartItems = new HashMap<Long,Product>();
        }
        List<Product> products = cartItems.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
        double rand_total = products.stream().mapToDouble((pro)->pro.getQty()*pro.getUnitPrice()).sum();
        NumberFormat formatter = new DecimalFormat("#0.00");
        req.setAttribute("rand_total",formatter.format(rand_total));
        req.setAttribute("products",products);

        req.getRequestDispatcher("/WEB-INF/views/cart_details.jsp").forward(req,resp);
    }
}
