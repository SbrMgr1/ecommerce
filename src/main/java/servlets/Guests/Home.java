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
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet("")
public class Home extends HttpServlet {


    List<Product> tmp;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title","Ecommerce");

        HashMap<Long,Product> products = (HashMap<Long, Product>) this.getServletContext().getAttribute("products");
        String param = req.getParameter("param");
        String priceSort = req.getParameter("priceSort");

        if(param == null){
            if(priceSort == null){
                tmp = products.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
            }else{
                if (priceSort.equals("asc")){
                    tmp = products.entrySet().stream().map(Map.Entry::getValue).sorted((p1,p2)->(int)(p1.getUnitPrice()-p2.getUnitPrice())).collect(Collectors.toList());
                }else if(priceSort.equals("desc")){
                    tmp = products.entrySet().stream().map(Map.Entry::getValue).sorted((p1,p2)->(int)(p2.getUnitPrice()-p1.getUnitPrice())).collect(Collectors.toList());
                }else{
                    tmp = products.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
                }
            }


        }else{
            if(priceSort == null){
                tmp = products.entrySet().stream().map(Map.Entry::getValue).filter(product -> product.getName().toLowerCase().contains(param.toLowerCase())).collect(Collectors.toList());
            }else{
                if (priceSort.equals("asc")){
                    tmp = products.entrySet().stream().map(Map.Entry::getValue).filter(product -> product.getName().toLowerCase().contains(param.toLowerCase())).sorted((p1,p2)->(int)(p1.getUnitPrice()-p2.getUnitPrice())).collect(Collectors.toList());
                }else if(priceSort.equals("desc")){
                    tmp = products.entrySet().stream().map(Map.Entry::getValue).filter(product -> product.getName().toLowerCase().contains(param.toLowerCase())).sorted((p1,p2)->(int)(p2.getUnitPrice()-p1.getUnitPrice())).collect(Collectors.toList());
                }else{
                    tmp = products.entrySet().stream().map(Map.Entry::getValue).filter(product -> product.getName().toLowerCase().contains(param.toLowerCase())).collect(Collectors.toList());
                }
            }


        }
        if(tmp == null){
            tmp = new ArrayList<Product>();
        }
        req.setAttribute("products",tmp);

        req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req,resp);
    }
}
