package models;

import helpers.MyHelper;

public class ProductCategory {
    private long id;
    private String name;
    private String desc;

    public ProductCategory(){

        this.id = MyHelper.getRandomInt();
    }

    public ProductCategory(Long id,String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }
    public ProductCategory(String name, String desc) {
        this.id = MyHelper.getRandomInt();
        this.name = name;
        this.desc = desc;
    }

    public long getId() {
        return id;
    }

    public void setId() {
        this.id = MyHelper.getRandomInt();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
