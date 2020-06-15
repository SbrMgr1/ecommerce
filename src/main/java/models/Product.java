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

    public Product(){

    }

    public Product(String name, Double unitPrice,String img,float tax,long catId) {
        this.id = MyHelper.getRandomInt();
        this.name = name;
        this.unitPrice = unitPrice;
        this.producImg = img;
        this.tax = tax;
        this.catId = catId;
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

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public float getTax() {
        return tax;
    }

    public void setTax(float tax) {
        this.tax = tax;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
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
}