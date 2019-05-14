package object_oriented_design;

import java.util.HashMap;

public class ProductData {
    HashMap<String, Double> productDetails = new HashMap<>();
    public HashMap<String, Double> getProductDetails() {
        return productDetails;
    }
    public void addProductData(String productCode, Double price){
        productDetails.put(productCode, price);
    }
}
