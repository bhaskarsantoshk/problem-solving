package object_oriented_design;

import java.util.*;

public class Store {
    private static double totalPrice;
    private static HashMap<String, Object> rules;
    private static Set<String> ruleApplied= new HashSet<>();
    public static void main(String[] args){
            ArrayList<String> productsToBePurchased = checkOut();
            List<Rule> rules= createRules(productsToBePurchased);
            applyRules(productsToBePurchased, rules);
            System.out.println(totalPrice);
        }

    private static List<Rule> createRules(ArrayList<String> productsToBePurchased) {
        List<Rule> rules = new ArrayList<>();
        rules.add(new PriceReductionRule(3,"TSHIRT", 19D));
        rules.add(new BuyXProductsGetYProducts(2,1,"VOUCHER"));
        return rules;
    }


    private static void applyRules(ArrayList<String> productsToBePurchased, List<Rule> rules) {
        if (rules == null || productsToBePurchased == null) {
            return;
        }
        HashMap<String, Integer> productDetails = frequencies(productsToBePurchased);
        ProductData obj = new ProductData();
        HashMap<String, Double> prices = productDataList();
        if (productDetails == null) return;
        for (String product : productDetails.keySet()) {
            for (Rule rule : rules) {
                double tempPrice = rule.apply(product, productDetails.get(product), prices.get(product));
                if (tempPrice == 0) {
                    continue;
                } else if (tempPrice == -1) {
                    totalPrice += productDetails.get(product) * prices.get(product);
                } else {
                    ruleApplied.add(product);
                    totalPrice += tempPrice;

                }
            }
        }

        for(String product : productDetails.keySet()){
            if(!ruleApplied.contains(product)){
                totalPrice += productDetails.get(product) * prices.get(product);
            }
        }

    }

    private static ArrayList<String> checkOut() {
            String[] products={"VOUCHER", "TSHIRT", "TSHIRT", "TSHIRT", "TSHIRT", "MUG", "TSHIRT","VOUCHER","VOUCHER","VOUCHER", "TSHIRT", "TSHIRT", "TSHIRT", "MUG", "MUG", "MUG", "MUG","MUG","MUG"};
            ArrayList<String> productsToBePurchased = new ArrayList<>();
            for(String product: products){
                productsToBePurchased.add(product);
            }
            System.out.println(productsToBePurchased);
            return productsToBePurchased;
    }

    private static HashMap<String, Double> productDataList() {
        HashMap<String, Double> productDataList= new HashMap<>();
        productDataList.put("VOUCHER", 9D);
        productDataList.put("TSHIRT", 21D);
        productDataList.put("MUG", 7.5);
        return productDataList;
        }

        private static HashMap<String, Integer> frequencies ( ArrayList<String> productsToBePurchased){
            HashMap<String, Integer> productDetails = new HashMap<>();
            for(String product: productsToBePurchased){
                productDetails.put(product, productDetails.getOrDefault(product,0)+1);
            }
            System.out.println(productDetails);
            return productDetails;
        }
}
