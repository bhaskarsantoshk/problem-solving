package company.google.dynamic_programming;

public class P121BestTimeToBuyAndSellStock {

    // if you are selling on ith day - you buy on the min price from 1st to i-1
    // track minSoFar
    // also track profit
    // Optimized
    public int maxProfit(int[] prices) {
        if ( prices == null || prices.length == 0) return 0;
        int minSoFar = Integer.MAX_VALUE, maxProfit = 0;
        for ( int i=0; i<prices.length; i++){
            minSoFar = Math.min(prices[i], minSoFar);
            maxProfit = Math.max(maxProfit, prices[i]-minSoFar); // why DP -> because we are remembering the past
        }
        return maxProfit;
    }
}
