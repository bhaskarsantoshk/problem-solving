package takeUForward.dynamicProgramming.revision;

import java.util.Arrays;

public class P15BestTimeToBuyAndSellStockII {
    public int stockBuySell(int[] arr, int n) {
        return f(0, true, arr, n);
    }

    private int f(int index, boolean buy, int[] arr, int n) {
        if ( index == n) return 0;
        if ( buy ){
            return  Math.max ( -arr[index] + f(index+1, !buy, arr, n), // buy
                    f(index+1, buy, arr, n)); // not buy
        } else {
            return Math.max( arr[index]+f(index+1, buy, arr, n), // sell
                    f(index+1, !buy, arr, n));  // not sell
        }
    }

    public int stockBuySellMemoized(int[] arr, int n) {
        int [][] dp = new int[n][2];
        for ( int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        return f(0, 1, arr, n, dp);
    }

    private int f(int index, int buy, int[] arr, int n, int[][] dp) {
        if ( index == n) return 0;
        if ( dp[index][buy] != -1) return dp[index][buy];
        int profit = 0;
        if ( buy == 1){
            profit = Math.max ( -arr[index] + f(index+1, 0, arr, n, dp), // buy
                    f(index+1, 1, arr, n, dp)); // not buy
        } else {
            profit = Math.max( arr[index]+f(index+1, 1, arr, n, dp), // sell
                    f(index+1, 0, arr, n, dp));  // not sell
        }

        return dp[index][buy] = profit;
    }

    public int stockBuySellTabular(int[] arr, int n) {
        int [][] dp = new int[n+1][2];
        dp[n][0] = dp[n][1] = 0;
        int profit = 0;
        for ( int index=n-1; index>=0; index--){
            for ( int buy = 0; buy <=1; buy++) {
                if (buy == 1) {
                    profit = Math.max(-arr[index] + dp[index + 1][0], dp[index + 1][1]);
                } else {
                    profit = Math.max(arr[index] + dp[index + 1][1], dp[index + 1][0]);
                }
                dp[index][buy] = profit;
            }
        }
        return dp[0][1];
    }

    public int stockBuySellSpaceOptimized(int[] arr, int n) {
        int [] ahead = new int[2];
        ahead[0] = ahead[1] = 0;
        int profit = 0;
        for ( int index=n-1; index>=0; index--){
            int []cur = new int[2];
            for ( int buy = 0; buy <=1; buy++) {
                if (buy == 1) {
                    profit = Math.max(-arr[index] + ahead[0], ahead[1]);
                } else {
                    profit = Math.max(arr[index] + ahead[1], ahead[0]);
                }
                cur[buy] = profit;
            }
            ahead = cur;
        }
        return ahead[1];
    }


}
