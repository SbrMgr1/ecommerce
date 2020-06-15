package models;

public class Order {
    private long id;
    private int quantity;
    private long orderBy;

    public Order(int id,int quantity) {
        this.id = id;
        this.quantity = quantity;
        this.orderBy = 0;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
