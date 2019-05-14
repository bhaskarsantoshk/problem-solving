package object_oriented_design;

import java.util.ArrayList;

public class Store {
        public static void main(String[] args){
            addProductData();
            ArrayList<String> productsToBePurchased = checkOut();

        }

    private static ArrayList<String> checkOut() {
            String[] products={"VOUCHER", "TSHIRT", "TSHIRT", "VOUCHER", "TSHIRT", "MUG", "VOUCHER"};
            ArrayList<String> productsToBePurchased = new ArrayList<>();
            for(String product: products){
                productsToBePurchased.add(product);
            }
            return productsToBePurchased;
    }

    private static void addProductData() {
          ProductData obj = new ProductData();
          obj.addProductData("VOUCHER", 9D);
          obj.addProductData("TSHIRT", 21D);
          obj.addProductData("MUG", 7.5);
        }
}
