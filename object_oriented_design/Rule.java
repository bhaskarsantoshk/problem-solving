package object_oriented_design;

public abstract class Rule {
    private double productCode;
    private double price;
    private int numberOfProductsPurchased;
    private double totalCostUponRuleApplied;
    public abstract double apply(String product_code, int numberOfProductsPurchased, double price);
}
