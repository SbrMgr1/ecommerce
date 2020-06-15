package models;

import helpers.MyHelper;

import java.util.ArrayList;
import java.util.List;

public class Product {

    private long id;
    private String name;
    private long catId;

    private String producImg;
    private Double unitPrice;
    private float tax;
    private Integer qty;
    private String desc;

    private List<Order> orders = new ArrayList<Order>();

    public Product(String name, Double unitPrice,String img,float tax,long catId) {
        this.id = MyHelper.getRandomInt();
        this.name = name;
        this.unitPrice = unitPrice;
        this.producImg = img;
        this.tax = tax;
        this.catId = catId;
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

    public long getCatId() {
        return catId;
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

    public String getDesc() {
        return desc;
    }

    public List<Order> getOrders() {
        return orders;
    }
}