package takeUForward.dynamicProgramming;

public class DP38BuyAndStockSellIVRecursionToSpaceOptimisation {
    public static int maximumProfit(int[] prices, int n, int k)
    {
        int [][]after = new int[2][k+1];
        int [][]curr = new int[2][k+1];
        for ( int index=n-1; index>=0; index--){
            for ( int buy=0; buy<=1; buy++){
                for ( int cap=1; cap<=k; cap++){
                    int profit = 0;
                    if ( buy == 1){
                        int take = -prices[index] + after[0][cap];
                        int notTake = after[1][cap];
                        curr[buy][cap] = Math.max(take, notTake);
                    } else {
                        int sell = prices[index] + after[1][cap-1];
                        int wait = after[0][cap];
                        curr[buy][cap] = Math.max(sell, wait);
                    }
                }
            }
            after = (int[][]) curr.clone();
        }
        return curr[1][k];
    }
}
