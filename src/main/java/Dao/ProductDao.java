package Dao;

import helpers.MyHelper;
import models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDao {

    private List<Product> products = new ArrayList<Product>();

    public ProductDao(){
        products.add(new Product("Macbook Pro 16\"",2500.8,"macbook-pro.jpg",2,9283736236l,"<h3>Features:</h3>\nPrice. $1299. ...\n" +
                "Finish. Silver Space Gray.\n" +
                "Display. Retina display. ...\n" +
                "Processor. 1.4GHz quad‑core 8th‑generation Intel Core i5, Turbo Boost up to 3.9GHz, with 128MB of eDRAM. ...\n" +
                "Storage1 256GB. ...\n" +
                "Memory. 8GB. ...\n" +
                "Graphics. Intel Iris Plus Graphics 645. ...\n" +
                "Charging and Expansion"));

        products.add(new Product("Iphone Pro11",2500.8,"iphone11.jpg",2,9283736236l,"<h3>Features:</h3>\nReleased 2019, September 20. 188g, 8.1mm thickness. iOS 13, up to iOS 13.5. 64GB/256GB/512GB storage, no card slot.\n" +
                "17% 3,339,305 hits.\n" +
                "209 Become a fan.\n" +
                "5.8\" 1125x2436 pixels.\n" +
                "12MP. 2160p.\n" +
                "4GB RAM. Apple A13 Bionic.\n" +
                "3046mAh."));
        products.add(new Product("Wireless Earphone",2500.8,"watch.jpg",2,9283736236l,"<h3>Features:</h3>\nLEMFO M1 Smart Bracelet BT Earphone 0.96-Inch TFT Screen Smart Watch Heart Rate Blood Pressure Monitoring Calorie Fitness Alarm Sports Wristwatch for Android / iOS Valentine's Day Gifts for Her/Him"));
        products.add(new Product("Leather Jacket",190.0,"leather_jacket.jpg",2,9283736236l,"<h3>Jacket Features:</h3>\n" +
                "Color: Brown\n" +
                "Genuine Leather\n" +
                "Inner: Soft Fur Lining\n" +
                "Pockets: Two Waist Zipper\n" +
                "Waistline Belt for Adjustment\n" +
                "Collar: Shearling Lapel Design\n" +
                "Front: Branded Zipper Style Closure\n" +
                "Sleeves: Full-Length Stylish Belted Fur Cuffs"));
        products.add(new Product("Bose Frames Alto",190.0,"glasses.png",2,9283736236l,"<h3>Features:</h3>\n" +
                "Receive a free pair of Bose non-polarized OR polarized Lenses with every order of Bose Frames."));
        products.add(new Product("Mares Avanti Quattro Plus",190.0,"swimfins.jpg",2,9283736236l,"<h3>Pros:</h3>\n" +
                "Great performance in almost all conditions\n" +
                "Can produce very powerful frog kicks\n" +
                "Very comfortable to dive with\n" +
                "Available as either closed heel or open heel"));

        products.add(new Product("Beach Air Mattress",190.0,"boat.jpg",2,9283736236l,"<h3>Pros:</h3>\n" +
                "Outdoor Water Rowing Boat Sleeping Bed Swimming Floating Row Lounger Inflatable Beach Air Mattress Rowing Boat 230*115CM"));

        products.add(new Product("TANTU Men Boots",190.0,"boot.jpg",2,9283736236l,"<h3>Description:</h3>\n" +
                "TANTU Men Boots Anti-Skidding Leather Shoes Men Popular Comfy Spring Autumn Shoes Snow Boots Durable Outsole."));
    }
    private int cnt = 0;
    public Product saveProduct(Product product){
        if (product == null){
            return null;
        }

        int product_index = products.indexOf(product);
        if(product_index<0){
            //add new item
            products.add(product);
            return product;

        }else{

            //edit operation
            products.get(product_index).setName(product.getName());
            products.get(product_index).setUnitPrice(product.getUnitPrice());
            if(product.getProducImg()!= null){
                if(!product.getProducImg().isEmpty()){
                    products.get(product_index).setProducImg(product.getProducImg());
                }
            }
            products.get(product_index).setTax(product.getTax());
            products.get(product_index).setCatId(product.getCatId());
            products.get(product_index).setDesc(product.getDesc());
            return products.get(product_index);
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

    public List<Product> getProducts() {
        return products;
    }
}
