package company.amazon.leetcode;

public class P121BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if ( prices == null || prices.length == 0) return 0;
        int maxProfit = 0, minPrice = prices[0];
        for ( int i=1; i<prices.length; i++){
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(prices[i]-minPrice, maxProfit);
        }
        return maxProfit;
    }
}
