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
        ProductDao productDao = (ProductDao) this.getServletContext().getAttribute("productDao");
        List<Product> products = productDao.getProducts();
        if (products == null){
            products = new ArrayList<Product>();
        }

        oldCartItems = (HashMap<Long,Product>) req.getSession().getAttribute("cart_item");
        if(oldCartItems == null){
            oldCartItems = new HashMap<Long,Product>();
        }
        Optional<Product> result = products.stream().filter(p->p.getId() == id).findFirst();
        if (result.isPresent()){
            Product product  = result.get();
            product.setQty(qty);
            oldCartItems.put(id,product);
            req.getSession().setAttribute("cart_item", oldCartItems);
            oldCartItems = (HashMap<Long,Product>) req.getSession().getAttribute("cart_item");
            resp.getWriter().println(oldCartItems.size());

        }else{
            resp.getWriter().println(oldCartItems.size());
        }
    }
}
