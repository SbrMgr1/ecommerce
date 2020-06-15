package models;

import helpers.MyHelper;

import java.util.ArrayList;
import java.util.List;

public class Product {

    private long id;
    private String name;
    private String producImg;
    private Double unitPrice;
    private float tax;
    private Integer qty;
    private List<Order> orders = new ArrayList<Order>();

    public Product(String name, Double unitPrice,String img,float tax) {
        this.id = MyHelper.getRandomInt();
        this.name = name;
        this.unitPrice = unitPrice;
        this.producImg = img;
        this.tax = tax;
    }
    public void setOrders(int qty){
        orders.add(new Order(2,qty));
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getProducImg() {
        return producImg;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public float getTax() {
        return tax;
    }

    public Integer getQty() {
        return qty;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
