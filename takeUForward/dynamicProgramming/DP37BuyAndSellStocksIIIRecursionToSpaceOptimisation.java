package takeUForward.dynamicProgramming;

public class DP37BuyAndSellStocksIIIRecursionToSpaceOptimisation {
    public static int maxProfit(int[] prices) {
       return maxProfit(0, 1, 2, prices);
    }

    private static int maxProfit(int index, int buy, int cap, int[] prices) {
        if ( index == prices.length || cap == 0 ) return 0;
        int profit = 0;
        if ( buy == 1){
            int take = -prices[index] + maxProfit(index+1, 0, cap, prices);
            int notTake = maxProfit(index+1, 1, cap, prices);
            profit = Math.max(take, notTake);
        } else {
            int sell = prices[index] + maxProfit(index+1, 1, cap-1, prices);
            int wait = maxProfit(index+1, 0, cap, prices);
            profit = Math.max(sell, wait);
        }
        return profit;
    }

    public static int maxProfitMemo(int[] prices) {
        int [][][] memo = new int[prices.length][2][3];
        for ( int i=0; i<memo.length; i++){
            for ( int j=0; j<memo[0].length; j++){
                for ( int k=0; k<memo[0][0].length; k++)
                    memo[i][j][k] = -1;
            }
        }
        return maxProfitMemo(0, 1, 2, prices, memo);
    }

    private static int maxProfitMemo(int index, int buy, int cap, int[] prices, int[][][] memo) {
        if ( cap == 0 || index == prices.length) return 0;
        int profit = 0;
        if ( memo[index][buy][cap] != -1) return memo[index][buy][cap];
        if ( buy == 1){
            int take = -prices[index] + maxProfitMemo(index+1, 0, cap, prices, memo);
            int notTake = maxProfitMemo(index+1, 1, cap, prices, memo);
            profit = Math.max(take, notTake);
        } else {
            int sell = prices[index] + maxProfitMemo(index+1, 1, cap-1, prices, memo);
            int wait = maxProfitMemo(index+1, 0, cap, prices, memo);
            profit = Math.max(sell, wait);
        }
        return memo[index][buy][cap]= profit;
    }

    public static int maxProfitTabulation(int[] prices) {
        int n = prices.length;
        int [][][] dp = new int[n+1][2][3];
        for ( int index=n-1; index>=0; index--){
            for ( int buy=0; buy<=1; buy++){
                for ( int cap=1; cap<=2; cap++){
                    int profit = 0;
                    if ( buy == 1){
                        int take = -prices[index] + dp[index+1][0][cap];
                        int notTake = dp[index+1][1][cap];
                        dp[index][buy][cap] = Math.max(take, notTake);
                    } else {
                        int sell = prices[index] + dp[index+1][1][cap-1];
                        int wait = dp[index+1][0][cap];
                        dp[index][buy][cap] = Math.max(sell, wait);
                    }
                }
            }
        }
        return dp[0][1][2];
    }
}
