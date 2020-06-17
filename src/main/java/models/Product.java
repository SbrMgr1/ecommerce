package models;

import helpers.MyHelper;

import java.util.ArrayList;
import java.util.List;

public class Product {

    private long id;
    private String name = "";
    private long catId = 0;

    private String producImg = "";
    private double unitPrice;
    private float tax;
    private int qty;
    private String desc ="";

    private List<Order> orders = new ArrayList<Order>();

    public Product(){
        this.id = MyHelper.getRandomInt();
    }

    public Product(String name, double unitPrice,String img,float tax,long catId,String desc) {
        this.id = MyHelper.getRandomInt();
        this.name = name;
        this.unitPrice = unitPrice;
        this.producImg = img;
        this.tax = tax;
        this.catId = catId;
        this.desc = desc;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCatId() {
        return catId;
    }

    public void setCatId(long catId) {
        this.catId = catId;
    }

    public String getProducImg() {
        return producImg;
    }

    public void setProducImg(String producImg) {
        this.producImg = producImg;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public float getTax() {
        return tax;
    }

    public void setTax(float tax) {
        this.tax = tax;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object obj) {
        Product p =  (Product)obj;
        return p.getId() == this.getId();
    }
}