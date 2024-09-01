package takeUForward.dynamicProgramming;

public class DP39BuyAndSellStocksWithCooldownRecursionToSpaceOptimisation {
    public static int stockProfit(int[] prices) {
        int n = prices.length;
        return stockProfit(0, 1, prices);
    }

    private static int stockProfit(int index, int buy, int[] prices) {
        if ( index == prices.length) return 0;
        int profit = 0;
        if ( buy == 1){
            int take =  -prices[index] + stockProfit(index+1, 0, prices);
            int notTake = stockProfit(index+1, 1, prices);
            profit = Math.max(take, notTake);
        } else {
            int sell = prices[index] + stockProfit(index+2, 1, prices);
            int notSell = stockProfit(index+1, 0, prices);
            profit = Math.max( sell, notSell);
        }
        return profit;
    }

    public static int stockProfitMemo(int[] prices) {
        int n = prices.length;
        int [][] memo = new int[n][2];
        for(int i=0; i<n; i++){
            memo[i][0] = -1;
            memo[i][1] = -1;
        }
        return stockProfitMemo(0, 1, prices, memo);
    }

    private static int stockProfitMemo(int index, int buy, int[] prices, int[][] memo) {
        if ( index >= prices.length) return 0;
        int profit = 0;
        if ( memo[index][buy] != -1) return memo[index][buy];
        if ( buy == 1){
            int take =  -prices[index] + stockProfitMemo(index+1, 0, prices, memo);
            int notTake = stockProfitMemo(index+1, 1, prices, memo);
            profit = Math.max(take, notTake);
        } else {
            int sell = prices[index] + stockProfitMemo(index+2, 1, prices, memo);
            int notSell = stockProfitMemo(index+1, 0, prices, memo);
            profit = Math.max( sell, notSell);
        }
        return memo[index][buy] = profit;
    }

    private static int stockProfitTabular(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+2][2];
        for ( int index=n-1; index>=0; index--){
            for ( int buy=0; buy<=1; buy++){
                if ( buy == 1){
                    int take =  -prices[index] + dp[index+1][0];
                    int notTake = dp[index+1][1];
                    dp[index][buy] = Math.max(take, notTake);
                } else {
                    int sell = prices[index] + dp[index+2][1];
                    int notSell = dp[index+1][0];
                    dp[index][buy] = Math.max( sell, notSell);
                }
            }
        }
        return dp[0][1];
    }
}
