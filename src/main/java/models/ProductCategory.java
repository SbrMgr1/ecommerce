package models;

import helpers.MyHelper;

public class ProductCategory {
    private long id;
    private String name;
    private String desc;

    public ProductCategory(){
      super();
    }

    public ProductCategory(int id,String name, String desc) {
        super();
        this.id = id;
        this.name = name;
        this.desc = desc;
    }
    public ProductCategory(String name, String desc) {
        super();
//        this.id = MyHelper.getRandomInt();
        this.name = name;
        this.desc = desc;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}
