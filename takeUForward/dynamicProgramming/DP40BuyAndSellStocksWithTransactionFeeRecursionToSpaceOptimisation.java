package takeUForward.dynamicProgramming;

public class DP40BuyAndSellStocksWithTransactionFeeRecursionToSpaceOptimisation {
    public static int maximumProfit(int[] prices, int n, int fee) {
        int[][] dp = new int[n+1][2];
        dp[n][0] = dp[n][1] = 0;
        for ( int index=n-1; index>=0; index--){
            for ( int buy=0; buy<=1; buy++){
                int profit = 0;
                if ( buy == 1){
                    int take = -prices[index] + dp[index+1][0];
                    int notTake = dp[index+1][1];
                    profit = Math.max(take, notTake);
                } else {
                    int sell = prices[index] + dp[index+1][1]-fee;
                    int notSell = dp[index+1][0];
                    profit = Math.max(sell, notSell);
                }
                dp[index][buy]  = profit;
            }
        }
        return dp[0][1];
    }
}
