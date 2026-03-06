package company.apple;

public class P50BestTimeToBuyAndSellStock {

    // if you sell on ith day, you must have bought on ( 0-i-1 ) days

    public int maxProfit(int[] prices) {
        int minSoFar = prices[0];
        int maxProfit = 0;
        for ( int i=0; i<prices.length; i++){
            maxProfit = Math.max(maxProfit, prices[i] - minSoFar);
            minSoFar = Math.min(minSoFar, prices[i]);
        }
        return maxProfit;
    }
}
