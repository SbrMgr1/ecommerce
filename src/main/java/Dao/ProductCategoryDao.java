package Dao;

import models.ProductCategory;

import javax.servlet.http.HttpServlet;
import java.util.HashMap;

public class ProductCategoryDao {

    private HashMap<Long, ProductCategory> categoryList = new HashMap<Long, ProductCategory>();


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



