package Dao;

import models.ProductCategory;

import javax.servlet.http.HttpServlet;
import java.util.HashMap;

public class ProductCategoryDao {

    private HashMap<Long, ProductCategory> categoryList = new HashMap<Long, ProductCategory>();

    public ProductCategoryDao(){

        ProductCategory productCategory1 = new ProductCategory(9283736236l,"Electronics","Laptops,Hard drives,Tvs,mobile phones..");
        ProductCategory productCategory2 = new ProductCategory(9283736237l,"Jewellery","Necklace,bracelets,ear-rings...");
        ProductCategory productCategory3 = new ProductCategory(9283736238l,"Mobile Phones","iPhone,Samsung,Nokia,redMI...");
        ProductCategory productCategory4= new ProductCategory(9283736239l,"Fashion Accessories","Watches,Wallets,handbags,belts....");
        ProductCategory productCategory5= new ProductCategory(92837362355l,"Home Decoration","Crockery sets,jars,containers,cookware....");
        ProductCategory productCategory6= new ProductCategory(9283736244l,"Sports","Cricket gear,football,tennis rackets....");
        ProductCategory productCategory7= new ProductCategory(92837344236l,"Baby care","Soaps,oil,body lotion,diapers....");
        categoryList.put(productCategory1.getId(),productCategory1);
        categoryList.put(productCategory2.getId(),productCategory2);
        categoryList.put(productCategory3.getId(),productCategory3);
        categoryList.put(productCategory4.getId(),productCategory4);
        categoryList.put(productCategory5.getId(),productCategory5);
        categoryList.put(productCategory6.getId(),productCategory6);
        categoryList.put(productCategory7.getId(),productCategory7);

//        ProductCategory productCategory1 = new ProductCategory(9283736236l,"Electronics","Laptops,Mobiles,Tvs");
//        categoryList.put(productCategory1.getId(),productCategory1);
//
//        ProductCategory productCategory2 = new ProductCategory(928378572l,"Books","Famous book");
//        categoryList.put(productCategory2.getId(),productCategory2);

    }

    public ProductCategory findCategory(HttpServlet httpServlet, long id) {
        ProductCategoryDao productCategoryDao = (ProductCategoryDao) httpServlet.getServletContext().getAttribute("productCategoryDao");
        categoryList = productCategoryDao.getAllCategory();
        if (categoryList == null) {
            return null;
        } else {

            ProductCategory productCategory = (ProductCategory) categoryList.get(id);
            if (productCategory != null) {
                return productCategory;
            } else {
                return null;
            }

        }
    }

    public void addEditProductCategory(ProductCategory productCategory) {

        categoryList.put(productCategory.getId(), productCategory);
    }

    public void deleteProductCategory(Long id){
        categoryList.remove(id);

    }
    public HashMap<Long,ProductCategory> getAllCategory(){
        return categoryList;
    }
}



