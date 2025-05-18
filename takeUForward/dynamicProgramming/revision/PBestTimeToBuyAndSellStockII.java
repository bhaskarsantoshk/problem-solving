package takeUForward.dynamicProgramming.revision;

import java.util.Arrays;

public class PBestTimeToBuyAndSellStockII {
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
        if ( buy == 1){
            return dp[index][buy] = Math.max ( -arr[index] + f(index+1, 0, arr, n, dp), // buy
                    f(index+1, 1, arr, n, dp)); // not buy
        } else {
            return dp[index][buy] = Math.max( arr[index]+f(index+1, 1, arr, n, dp), // sell
                    f(index+1, 0, arr, n, dp));  // not sell
        }
    }
}
