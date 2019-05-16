package object_oriented_design.online_store;

public class PriceReductionRule extends Rule{
    private int numberOfProductsToBeBought ;
    private double totalCostUponRuleApplied;
    private String productCode;
    private double newPrice;

    public PriceReductionRule(int numberOfProductsToBeBought,  String productCode, double newPrice) {
        this.numberOfProductsToBeBought = numberOfProductsToBeBought;
        this.productCode = productCode;
        this.newPrice = newPrice;
    }


    @Override
    public double apply(String product_code, int numberOfProductsPurchased, double price ) {
        if(!productCode.equals(product_code)) {
            return 0;
        }
        if(productCode.equals(product_code) &&
                numberOfProductsPurchased >= numberOfProductsToBeBought){
            totalCostUponRuleApplied = numberOfProductsPurchased * newPrice;
        }
        else{
            totalCostUponRuleApplied = -1;
        }
        return totalCostUponRuleApplied;
    }
}
