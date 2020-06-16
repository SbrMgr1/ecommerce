package Dao;

import helpers.MyHelper;
import models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDao {

    private List<Product> products = new ArrayList<Product>();

    public ProductDao(){
        products.add(new Product("Macbook Pro 16\"",2500.8,"macbook-pro.jpg",2,1,"Macbook Pro 16"));
        products.add(new Product("Macbook Pro 16\"",2500.8,"macbook-pro.jpg",2,1,"Macbook Pro 16"));
    }
    private int cnt = 0;
    public Product saveProduct(Product product){
        if (products == null){
            products = new ArrayList<Product>();
        }
        cnt = -1;
        Product localProduct = product;
        Optional<Product> optional = products.stream().filter((p)->{
            cnt++;
            if(p.getId() == Long.valueOf(localProduct.getId())){
                return true;
            }else{
                return false;
            }
        }).findFirst();
        if(product.getId()>0){
            //edit operation
            products.get(cnt).setName(localProduct.getName());
            products.get(cnt).setUnitPrice(localProduct.getUnitPrice());
            products.get(cnt).setProducImg(localProduct.getProducImg());
            products.get(cnt).setTax(localProduct.getTax());
            products.get(cnt).setCatId(localProduct.getCatId());
            products.get(cnt).setDesc(localProduct.getDesc());
            return products.get(cnt);

        }else{
            //add new item
            product.setId(MyHelper.getRandomInt());
            products.add(product);
            return product;
        }
    }
    public int removeProduct(long id){
        return products.size();
    }

    public List<Product> getProducts() {
        return products;
    }
}
