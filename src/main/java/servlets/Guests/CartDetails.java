package servlets.Guests;

import DataProviders.Product;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet("/cart-details")
public class CartDetails  extends HttpServlet {
    String cookieValue;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<Long,Product> oldProduct = (HashMap<Long,Product>) req.getSession().getAttribute("cart-item");
        if(oldProduct == null){
            oldProduct = new HashMap<Long,Product>();
        }
        List<Product> products = oldProduct.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());

        req.setAttribute("rand_total",products.stream().mapToDouble((pro)->pro.getQty()*pro.getUnitPrice()).sum());
        req.setAttribute("products",products);

        req.getRequestDispatcher("/WEB-INF/views/cart_details.jsp").forward(req,resp);
    }
}
