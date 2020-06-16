package Dao;

import models.ProductCategory;

import javax.servlet.http.HttpServlet;
import java.util.HashMap;

public class ProductCategoryDao {

    private HashMap<Long, ProductCategory> categoryList = new HashMap<>();


    public ProductCategory findCategory(HttpServlet httpServlet, long id) {
        categoryList = (HashMap<Long, ProductCategory>) httpServlet.getServletContext().getAttribute("productCategories");
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

    public void addProductCategory(String name, String desc) {
        ProductCategory productCategory = new ProductCategory(name, desc);

        categoryList.put(productCategory.getId(), productCategory);
    }

    public void deleteProductCategory(Long id){
        categoryList.remove(id);

    }
    public HashMap<Long,ProductCategory> getAllCategory(){
        return categoryList;
    }
    public void editCategory(Long id,String name,String desc){
        if(categoryList.containsKey(id)){
            categoryList.put(id,new ProductCategory(name,desc));
        }
    }
}



