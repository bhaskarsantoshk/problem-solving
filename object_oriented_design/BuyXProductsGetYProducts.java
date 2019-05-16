package object_oriented_design;

public class BuyXProductsGetYProducts extends Rule {
    private int x ; //buy x
    private int y; //get y
    private int numberOfProductsPurchased;
    private double totalCostUponRuleApplied;
    private String productCode;

    public BuyXProductsGetYProducts(int x, int y, String productCode) {
        this.x = x;
        this.y = y;
        this.numberOfProductsPurchased = numberOfProductsPurchased;
        this.productCode = productCode;
    }

    public double apply(String product_code, int numberOfProductsPurchased, double price ) {
        if(!productCode.equals(product_code)) {
            return 0;
        }
        if(productCode.equals(product_code) &&
                numberOfProductsPurchased >= x){
            int productsForWhichPriceIsApplicable = (numberOfProductsPurchased / (x+y)) * x +
                    numberOfProductsPurchased % (x+y);
            totalCostUponRuleApplied = productsForWhichPriceIsApplicable * price ;
        }
        else{
            totalCostUponRuleApplied = -1;
        }
        return totalCostUponRuleApplied;
    }
}
