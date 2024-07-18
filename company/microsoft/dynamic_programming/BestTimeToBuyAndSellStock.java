package company.microsoft.dynamic_programming;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if ( prices == null || prices.length == 0) return 0;
        int minSoFar = Integer.MAX_VALUE;
        int maxProfit = 0;
        for ( int price : prices ){
            minSoFar = Math.min( minSoFar, price);
            maxProfit = Math.max ( maxProfit, price-minSoFar);
        }
        return maxProfit;
    }
}
