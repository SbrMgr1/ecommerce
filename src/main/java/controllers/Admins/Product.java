package controllers.Admins;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/administration/product")
public class Product extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> productList = (List<Product>)this.getServletContext().getAttribute("products");
        req.setAttribute("productList",productList);
        req.getRequestDispatcher("/WEB-INF/views/admins/products.jsp").forward(req,resp);
    }
}
