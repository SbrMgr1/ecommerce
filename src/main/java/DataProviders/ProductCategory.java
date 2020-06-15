package DataProviders;

import helpers.MyHelper;

public class ProductCategory {
    private long id;
    private String name;
    private String desc;

    public ProductCategory(String name, String desc) {
        this.id = MyHelper.getRandomInt();
        this.name = name;
        this.desc = desc;
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
