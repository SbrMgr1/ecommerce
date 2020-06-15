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

@WebServlet("/remove-item")
public class RemoveItem extends HttpServlet {
    HashMap<Long,Product> oldCartItems;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));

        //original products
        List<Product> products = (List<Product>) this.getServletContext().getAttribute("products");
        if (products == null){
            products = new ArrayList<>();
        }
        //get single item
        Product product = products.stream().filter(p->p.getId() == id).findFirst().get();

        oldCartItems = (HashMap<Long,Product>) req.getSession().getAttribute("cart-item");
        if(oldCartItems == null){
            oldCartItems = new HashMap<Long,Product>();
        }
        if(oldCartItems.containsKey(id)){
            oldCartItems.remove(id);
        }
        oldCartItems = (HashMap<Long,Product>) req.getSession().getAttribute("cart-item");
        resp.getWriter().println(oldCartItems.size());
    }
}
