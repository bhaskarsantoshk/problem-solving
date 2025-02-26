package takeUForward.blind75.arrays;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if ( prices == null || prices.length == 0) return 0;
        int minSoFar = prices[0];
        int maxProfit = 0;
        for ( int i=1; i<prices.length; i++){
            maxProfit = Math.max(maxProfit, prices[i]-minSoFar);
            minSoFar = Math.min(minSoFar, prices[i]);
        }
        return maxProfit;
    }
}
