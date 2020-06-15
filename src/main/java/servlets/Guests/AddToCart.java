package servlets.Guests;

import DataProviders.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@WebServlet("/add-to-cart")
public class AddToCart extends HttpServlet {

    HashMap<Long,Product> oldCartItems;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        Integer qty = Integer.valueOf(req.getParameter("qty"));

        //original products
        List<Product> products = (List<Product>) this.getServletContext().getAttribute("products");
        if (products == null){

            products = new ArrayList<Product>();
        }

        oldCartItems = (HashMap<Long,Product>) req.getSession().getAttribute("cart-item");
        if(oldCartItems == null){
            oldCartItems = new HashMap<Long,Product>();
        }
        Optional<Product> result = products.stream().filter(p->p.getId() == id).findFirst();
        if (result.isPresent()){
            Product product  = result.get();
            product.setQty(qty);
            oldCartItems.put(id,product);
            req.getSession().setAttribute("cart-item", oldCartItems);
            oldCartItems = (HashMap<Long,Product>) req.getSession().getAttribute("cart-item");
            resp.getWriter().println(oldCartItems.size());

        }else{
            resp.getWriter().println(oldCartItems.size());
        }
    }
}
