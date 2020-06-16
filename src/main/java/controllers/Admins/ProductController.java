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
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import Dao.ProductCategoryDao;
import Dao.ProductDao;
import com.google.gson.Gson;
import helpers.GlobalResp;
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
        ProductCategoryDao productCategoryDao = (ProductCategoryDao) this.getServletContext().getAttribute("categoryDao");
        req.setAttribute("catlist",productCategoryDao.getAllCategory());
        req.getRequestDispatcher("/WEB-INF/views/admins/products.jsp").forward(req,resp);
    }
    private Product tmp;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text_field = "";
        String file_name = "";
        tmp = new Product();
        GlobalResp globalResp = new GlobalResp();
        String[] results = getInputs(req,text_field,file_name);
        if(!results[0].isEmpty()){
            tmp = mapper.fromJson(results[0],Product.class);
            if(!results[1].isEmpty()){
                tmp.setProducImg(results[1]);
            }
            ProductDao productDao = (ProductDao) this.getServletContext().getAttribute("productDao");
            Product pd = productDao.saveProduct(tmp);
            if(pd != null){
                globalResp.setData(pd);
                globalResp.setStatus(true);
                globalResp.setMessage("Saved Succssfully.");
            }

        }
        resp.getWriter().print(mapper.toJson(globalResp));

    }
    private String[] getInputs(HttpServletRequest req,String text_field,String file_name){
        String[] return_arr = new String[2];
        return_arr[0] = "";
        return_arr[1] = "";
        ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());

        try {
            List<FileItem> fileItems = servletFileUpload.parseRequest(req);
            for (FileItem f:fileItems) {
                if(f.getFieldName().equals("text_inputs")){
                    return_arr[0] = f.getString();
                }else if(f.getFieldName().equals("file_input") && !f.isFormField()){
                    String fileName = String.valueOf(MyHelper.getRandomInt())+"-"+f.getName();
                    String imagePath = "/assets/images";
                    String absoluteDiskPath = this.getServletContext().getRealPath(imagePath);
                    File file = new File(absoluteDiskPath+"/"+fileName);
                    try {
                        f.write(file);
                        return_arr[1] = fileName;

//                        BufferedImage img = ImageIO.read(file); // load image
//                        BufferedImage scaledImg = Scalr.resize(img, Method.QUALITY, 1280, 960);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
            return return_arr;
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return return_arr;
    }
}
