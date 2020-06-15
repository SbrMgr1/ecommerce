package WebListners;

import DataProviders.Product;
import DataProviders.User;
import DataProviders.UserRoles;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebListener
public class MyContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("application has been initialized.");

        initUsers(servletContextEvent);
        initProducts(servletContextEvent);

    }
    private void initUsers(ServletContextEvent servletContextEvent){

        HashMap<String, User> userlist = new HashMap<String,User>();
        userlist.put("admin@gmail.com",new User("Admin","admin@gmail.com","admin", UserRoles.ADMIN));
        userlist.put("user1@gmail.com",new User("User1","user1@gmail.com","user1"));
        userlist.put("user2@gmail.com",new User("User2","user2@gmail.com","user2"));
        servletContextEvent.getServletContext().setAttribute("users",userlist);
    }
    private void initProducts(ServletContextEvent servletContextEvent){

        List<Product> products = new ArrayList<Product>();
        products.add(new Product("Macbook Pro 16\"",2500.8,"macbook-pro.jpg",2));
        products.add(new Product("Iphone 11 pro",800.5,"iphone11.jpg",2));
        servletContextEvent.getServletContext().setAttribute("products",products);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
