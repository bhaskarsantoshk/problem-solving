package takeUForward.dynamicProgramming;

public class PDP36BuyAndSellStockIIRecursionToSpaceOptimisation {
    public static long getMaximumProfit (int n, long[] values) {
        return getMaximumProfit(0, n, values, true);
    }

    private static long getMaximumProfit(int index, int n, long[] values, boolean buy) {

        long profit = 0;
        if ( buy){
            long take = -values[index] + getMaximumProfit(index+1, n, values, false);
            long notTake = getMaximumProfit(index+1, n, values, true);
            profit = Math.max(take, notTake);
        } else {
            long sell = values[index] + getMaximumProfit(index+1, n, values, true);
            long notSell = getMaximumProfit(index+1, n, values, false );
        }
        return profit;
    }

    public static long getMaximumProfitMemo (int n, long[] values) {
        long[][] memo = new long[n][2];
        return getMaximumProfitMemo(0, n, values, 1, memo);
    }

    private static long getMaximumProfitMemo(int index, int n, long[] values, int buy, long[][] memo) {
        if ( index == n) return 0;
        if (memo[index][buy] != -1) return memo[index][buy];

        long profit = 0;
        if ( buy == 1){
            long take = -values[index] + getMaximumProfitMemo(index+1, n, values, 0, memo);
            long notTake = getMaximumProfitMemo(index+1, n, values, 1, memo);
            profit = Math.max(take, notTake);
        } else {
            long sell = values[index] + getMaximumProfitMemo(index+1, n, values, 1, memo);
            long notSell = getMaximumProfitMemo(index+1, n, values, 0 , memo);
            profit = Math.max(sell, notSell);
        }
        return memo[index][buy]  = profit;
    }

    public static long getMaximumProfitTabulation (int n, long[] values) {
        long[][] dp = new long[n+1][2];
        dp[n][0] = dp[n][1] = 0;
        for ( int index=n-1; index>=0; index--){
            for ( int buy=0; buy<=1; buy++){
                long profit = 0;
                if ( buy == 1){
                    long take = -values[index] + dp[index+1][0];
                    long notTake = dp[index+1][1];
                    profit = Math.max(take, notTake);
                } else {
                    long sell = values[index] + dp[index+1][1];
                    long notSell = dp[index+1][0];
                    profit = Math.max(sell, notSell);
                }
                dp[index][buy]  = profit;
            }
        }
        return dp[0][1];
    }

    public static long getMaximumProfitTabulationSpaceOptimized (int n, long[] values) {
        long[]ahead = new long[2];
        long[]cur = new long[2];
        ahead[0] = ahead[1] = 0;
        for ( int index=n-1; index>=0; index--){
            for ( int buy=0; buy<=1; buy++){
                long profit = 0;
                if ( buy == 1){
                    long take = -values[index] + ahead[0];
                    long notTake = ahead[1];
                    profit = Math.max(take, notTake);
                } else {
                    long sell = values[index] + ahead[1];
                    long notSell = ahead[0];
                    profit = Math.max(sell, notSell);
                }
                cur[buy]  = profit;
            }
            ahead = (long[])cur.clone();
        }
        return ahead[1];
    }
}
