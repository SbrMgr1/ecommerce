package WebListners;

import Dao.CMSDao;
import Dao.ProductCategoryDao;
import models.Product;
import models.ProductCategory;
import models.User;
import models.UserRoles;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@WebListener
public class MyContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("application has been initialized.");

        initUsers(servletContextEvent);
        initProducts(servletContextEvent);
        intCMS(servletContextEvent);
        initCategory(servletContextEvent);

    }
    private void initUsers(ServletContextEvent servletContextEvent){

        HashMap<String, User> userlist = new HashMap<String,User>();
        userlist.put("admin@gmail.com",new User("Admin","admin@gmail.com","admin", UserRoles.ADMIN));
        userlist.put("user1@gmail.com",new User("User1","user1@gmail.com","user1"));
        userlist.put("user2@gmail.com",new User("User2","user2@gmail.com","user2"));
        servletContextEvent.getServletContext().setAttribute("users",userlist);
//        servletContextEvent.getServletContext().setAttribute("users_for_crud",userlist.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList()));
    }
    private void initProducts(ServletContextEvent servletContextEvent){

        List<Product> products = new ArrayList<Product>();
        products.add(new Product("Macbook Pro 16\"",2500.8,"macbook-pro.jpg",2,1,"Macbook Pro 16"));
        products.add(new Product("Iphone 11 pro",800.5,"iphone11.jpg",2,1,"Iphone 11 pro"));
        servletContextEvent.getServletContext().setAttribute("products",products);
    }

    private void intCMS(ServletContextEvent servletContextEvent) {
        CMSDao cmsDao = new CMSDao();
        servletContextEvent.getServletContext().setAttribute("cmsDao",cmsDao);
    }
    private void initCategory(ServletContextEvent servletContextEvent){

        ProductCategoryDao productCategoryDao = new ProductCategoryDao();
        ProductCategory productCategory = new ProductCategory("Electronics","Laptops,Mobiles,Tvs");
        productCategoryDao.addEditProductCategory(productCategory);
        System.out.println("===============");
        System.out.println(productCategoryDao);
        System.out.println("===============");
        servletContextEvent.getServletContext().setAttribute("categoryDao",productCategoryDao);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
