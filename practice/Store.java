package practice;

import java.util.HashMap;
import java.util.Map;

public class Store {

    static int totalProducts ;
    static ProductData[] productData;
    static Rules[] rules;
    static Double total = 0D;

    public static int getTotalProducts() {
        return totalProducts;
    }

    public static void setTotalProducts(int totalProducts) {
        Store.totalProducts = totalProducts;
    }

    static class ProductData{
        String code;
        double price;
        ProductData(String code, double price){
            this.code = code;
            this.price = price;
        }
    }

    public static void main(String[] args){
        setTotalProducts(3);
        //Setting the Product Data
        productData = setProductData(productData);
        Rules[] rules= pricingRules(productData);
        String[] checkoutProducts=
                {"VOUCHER", "TSHIRT", "VOUCHER", "VOUCHER", "MUG", "TSHIRT", "TSHIRT"};
        Map<String, Integer> frequencies = calculateFrequencies(checkoutProducts);
        System.out.println(frequencies);
        applyRules(productData, frequencies);
        System.out.println(total);
    }

    private static Map<String, Integer> calculateFrequencies(String[] checkoutProducts) {
        Map<String, Integer> freq = new HashMap<>();
        for(String product: checkoutProducts){
            freq.put(product, freq.getOrDefault(product, 0)+1);
        }
        return freq;
    }

    private static void applyRules(ProductData[] productData, Map<String, Integer> frequencies) {
        HashMap<String, Double> productDataMap= productDataMap(productData);
        for(String product: frequencies.keySet()){
            for(int i=0; i<rules.length; i++){
                if(!rules[i].rule.equals("None") && product.equals(rules[i].product)){
                   if(rules[i].rule.equals("BUYTWOGETONE")){
                       int numberOfProducts = frequencies.get(product);
                       total+= (numberOfProducts % 3) * productDataMap.get(product) + ((numberOfProducts/3 )* productDataMap.get(product))*2;
                   }
                   else if(rules[i].rule.equals("BUY3ORMORE")){
                       if(frequencies.get(product)>=3){
                           int numberOfProducts = frequencies.get(product);
                           total+= numberOfProducts * 19;
                       }
                       else{
                           int numberOfProducts = frequencies.get(product);
                           total+=  numberOfProducts * productDataMap.get(product);
                       }
                   }
                }
                else if(rules[i].rule.equals("None") && product.equals(rules[i].product) ){
                    int numberOfProducts = frequencies.get(product);
                    total+= (numberOfProducts)* (productDataMap.get(product));
                }
            }
        }
    }


    static HashMap<String, Double> productDataMap(ProductData[] productData){
        HashMap<String, Double> map = new HashMap<>();
       for(int i=0; i<productData.length; i++){
           map.put(productData[i].code, productData[i].price);
       }
       return map;
    }
    private static Rules[] pricingRules(ProductData[] productData) {
         rules = new Rules[totalProducts];
        rules[0] = new Rules("VOUCHER", "BUYTWOGETONE");
        rules[1]= new Rules("TSHIRT", "BUY3ORMORE");
        rules[2]= new Rules("MUG", "None");
        return rules;
    }

    private static ProductData[] setProductData(ProductData[] productData) {
        productData = new ProductData[getTotalProducts()];
        productData[0]= new ProductData("VOUCHER", 7);
        productData[1]= new ProductData("TSHIRT", 21);
        productData[2]= new ProductData("MUG", 9.50);

        return productData;
    }

}
