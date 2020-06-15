package controllers.Admins;

import com.google.gson.Gson;
import helpers.MyHelper;
import models.Product;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@WebServlet("/administration/product_delete")
public class ProductDeleteController extends HttpServlet {
    Gson mapper = new Gson();
    private int index = -1;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Product> products = (List<Product>) this.getServletContext().getAttribute("products");
        if (products == null){
            products = new ArrayList<Product>();
        }

        Product product = new Product();
        product.setId(Long.valueOf(req.getParameter("id")));

        products.remove(product);


    }
}
