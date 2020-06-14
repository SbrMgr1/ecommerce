package servlets.Guests;

import DataProviders.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/remove-item")
public class RemoveItem extends HttpServlet {
    HashMap<Long,Product> oldProduct;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));

        //original products
        HashMap<Long, Product> products = (HashMap<Long, Product>) this.getServletContext().getAttribute("products");

        //get single item
        Product product = products.get(id);
        oldProduct = (HashMap<Long,Product>) req.getSession().getAttribute("cart-item");
        if(oldProduct == null){
            oldProduct = new HashMap<Long,Product>();
        }
        if(oldProduct.containsKey(id)){
            oldProduct.remove(id);
        }
        oldProduct = (HashMap<Long,Product>) req.getSession().getAttribute("cart-item");
        resp.getWriter().println(oldProduct.size());
    }
}
