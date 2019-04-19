package LeetCode;

public class P121BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0) return 0;
        int minPrice = prices[0];
        int maxProfit = 0;
        for(int i=1; i<prices.length; i++){
            minPrice = Math.min(prices[i], minPrice);
            maxProfit = Math.max(maxProfit, prices[i]-minPrice);
        }
        return maxProfit;
    }
}
