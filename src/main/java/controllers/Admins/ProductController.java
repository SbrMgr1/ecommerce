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
        List<ProductController> productList = (List<ProductController>)this.getServletContext().getAttribute("products");
        req.setAttribute("productList",productList);
        req.getRequestDispatcher("/WEB-INF/views/admins/products.jsp").forward(req,resp);
    }


    protected void doPosto(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
        try {
            List<FileItem> fileItems = servletFileUpload.parseRequest(req);
            for (FileItem fileItem:fileItems){
                try{
                    String fileName = String.valueOf(MyHelper.getRandomInt())+"-"+fileItem.getName();
                    String imagePath = "/assets/images";
                    String absoluteDiskPath = this.getServletContext().getRealPath(imagePath);
                    File file = new File(absoluteDiskPath+"/"+fileName);
                    fileItem.write(file);

                } catch (FileUploadException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }



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

            resp.getWriter().print(mapper.toJson(saveToContext(tmp)));

        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private int cnt = 0;
    private Product saveToContext( Product product){

        List<Product> products = (List<Product>) this.getServletContext().getAttribute("products");
        if (products == null){
            products = new ArrayList<Product>();
        }
        cnt = -1;
        Product localProduct = product;
        Optional<Product> optional = products.stream().filter((p)->{
            cnt++;
            if(p.getId() == Long.valueOf(localProduct.getId())){
                return true;
            }else{
                return false;
            }
        }).findFirst();
        if(product.getId()>0){
            //edit operation
            products.get(cnt).setName(localProduct.getName());
            products.get(cnt).setUnitPrice(localProduct.getUnitPrice());
            products.get(cnt).setProducImg(localProduct.getProducImg());
            products.get(cnt).setTax(localProduct.getTax());
            products.get(cnt).setCatId(localProduct.getCatId());
            products.get(cnt).setDesc(localProduct.getDesc());

            this.getServletContext().setAttribute("products",products);
            return products.get(cnt);

        }else{
            //add new item
            product.setId(MyHelper.getRandomInt());
            products.add(product);
            this.getServletContext().setAttribute("products",products);
            return product;
        }


    }
}
