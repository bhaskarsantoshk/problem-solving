package takeUForward.dynamicProgramming;

import java.util.ArrayList;

public class DP35BestTimeToBuyAndSellStockDPOnStocks {
    public static int maximumProfit(ArrayList<Integer> prices){
        int minimum = prices.get(0);
        int maxProfit = 0;
        for ( int i=1; i<prices.size(); i++){
             int profit = prices.get(i) - minimum;
             maxProfit = Math.max(profit, maxProfit);
             minimum = Math.min(minimum, prices.get(i));
        }
        return maxProfit;
    }
}
