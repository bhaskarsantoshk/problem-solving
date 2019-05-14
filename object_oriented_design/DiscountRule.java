package object_oriented_design;

public class DiscountRule extends Rule {
    //Assuming If you buy X products or more , you will get discount on each product
    private int numberOfProductsToBeBought ;
    private int numberOfProductsPurchased;
    private int price;
    private double totalCostUponRuleApplied;
    private String productCode;
    private double discount;

    public DiscountRule(int numberOfProductsPurchased, int price, String productCode) {
        this.numberOfProductsPurchased = numberOfProductsPurchased;
        this.price = price;
        this.productCode = productCode;
    }

    @Override
    public double apply(String product_code, int numberOfProductsPurchased, double price) {
        if(productCode.equals(product_code) &&
                numberOfProductsPurchased >= numberOfProductsToBeBought){
            totalCostUponRuleApplied = ((numberOfProductsPurchased * (100D-discount))/100) * price;
        }
        else{
            totalCostUponRuleApplied = numberOfProductsPurchased * price;
        }
        return totalCostUponRuleApplied;
    }
}
