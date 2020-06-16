package Dao;

import helpers.MyHelper;
import models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDao {

    private List<Product> products = new ArrayList<Product>();

    public ProductDao(){
        products.add(new Product("Macbook Pro 16\"",2500.8,"macbook-pro.jpg",2,9283736236l,"Macbook Pro 16"));
        products.add(new Product("Iphone Pro",2500.8,"iphone11.jpg",2,9283736236l,"Iphone Prog"));
        products.add(new Product("Wireless Earphone",2500.8,"watch.jpg",2,9283736236l,"Iphone Prog"));
        products.add(new Product("Veritas shoes",2500.8,"veritas.jpg",2,9283736236l,"Veritas"));
    }
    private int cnt = 0;
    public Product saveProduct(Product product){
        if (product == null){
            return null;
        }

        IndexMap indexMap = this.findProductWithIndexById(Long.valueOf(product.getId()));
        if(indexMap.getIndex()<0){
            //add new item
            products.add(product);
            return product;

        }else{

            //edit operation
            products.get(indexMap.getIndex()).setName(product.getName());
            products.get(indexMap.getIndex()).setUnitPrice(product.getUnitPrice());
            if(product.getProducImg()!= null){
                if(!product.getProducImg().isEmpty()){
                    products.get(indexMap.getIndex()).setProducImg(product.getProducImg());
                }
            }
            products.get(indexMap.getIndex()).setTax(product.getTax());
            products.get(indexMap.getIndex()).setCatId(product.getCatId());
            products.get(indexMap.getIndex()).setDesc(product.getDesc());
            return products.get(indexMap.getIndex());
        }
    }
    private class IndexMap{
        private int index = -1;
        Product product;

        public int getIndex() {
            return index;
        }

        public void increaseIndex() {
            this.index++;
        }

        public Product getProduct() {
            return product;
        }

        public void setProduct(Product product) {
            this.product = product;
        }
    }
    public boolean removeProduct(long id){

        Product product = new Product();
        product.setId(id);

        return products.remove(product);

    }
    public Product findProductById(Long id){
        Optional prodOpt = products.stream().filter(p->p.getId() == id).findFirst();
        if(prodOpt.isPresent()){
            return (Product)prodOpt.get();
        }else{
            return null;
        }
    }
    public IndexMap findProductWithIndexById(Long id){
        IndexMap indexMap = new IndexMap();
        Optional prodOpt = products.stream().filter(p->{
            indexMap.increaseIndex();
            if(p.getId() == id){
                return true;
            }else{
                return false;
            }
        }).findFirst();
        if(prodOpt.isPresent()){
            indexMap.setProduct((Product) prodOpt.get());
            return indexMap;
        }else{
            return indexMap;
        }
    }

    public List<Product> getProducts() {
        return products;
    }
}
