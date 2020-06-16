package controllers.Admins;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import Dao.ProductDao;
import com.google.gson.Gson;
import helpers.MyHelper;
import models.Product;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/administration/product")
public class ProductController extends HttpServlet {
    Gson mapper = new Gson();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDao productDao = (ProductDao) this.getServletContext().getAttribute("productDao");
        List<Product> productList = productDao.getProducts();
        req.setAttribute("productList",productList);
        req.getRequestDispatcher("/WEB-INF/views/admins/products.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());

        try {
            List<FileItem> fileItems = servletFileUpload.parseRequest(req);
            Product tmp = new Product();

            fileItems.stream().filter((f)->{
                if(f.isFormField()) {

                    if(f.getFieldName().equals("name")){
                        tmp.setName(f.getString());
                    }else if(f.getFieldName().equals("catId")){
                        tmp.setCatId(Long.valueOf(f.getString()));
                    }else if(f.getFieldName().equals("unitPrice")){
                        tmp.setUnitPrice(f.getString().isEmpty()?0.0:Double.valueOf(f.getString()));
                    }else if(f.getFieldName().equals("tax")){
                        tmp.setTax(f.getString().isEmpty()?0:Float.valueOf(f.getString()));
                    }else if(f.getFieldName().equals("desc")){
                        tmp.setDesc(f.getString());
                    }else if(f.getFieldName().equals("desc")){
                        tmp.setDesc(f.getString());
                    }else if(f.getFieldName().equals("id")){
                        tmp.setId(f.getString().isEmpty()?0:Long.valueOf(f.getString()));
                    }

                }else{//for file input

                    String fileName = String.valueOf(MyHelper.getRandomInt())+"-"+f.getName();
                    String imagePath = "/assets/images";
                    String absoluteDiskPath = this.getServletContext().getRealPath(imagePath);
                    File file = new File(absoluteDiskPath+"/"+fileName);
                    try {
                        f.write(file);
                        tmp.setProducImg(fileName);

//                        BufferedImage img = ImageIO.read(file); // load image
//                        BufferedImage scaledImg = Scalr.resize(img, Method.QUALITY, 1280, 960);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return true;
            }).collect(Collectors.toList());
            ProductDao productDao = (ProductDao) this.getServletContext().getAttribute("productDao");
            resp.getWriter().print(mapper.toJson(productDao.saveProduct(tmp)));

        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
