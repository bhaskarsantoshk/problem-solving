package takeUForward.dynamicProgramming.revision;

import java.util.Arrays;

public class P18BestTimeToBuyAndSellStockWithTransactionFees {
    public int stockBuySell(int[] arr, int n, int fee) {
        return f(0,1, arr, n, fee);
    }

    private int f(int index, int buy,  int[] arr, int n, int fee) {
        if ( index == n) return 0;
        int profit = 0;
        if ( buy == 1){
            profit = Math.max(-arr[index] + f(index+1, 0, arr, n, fee)-fee, f(index+1, 1, arr, n, fee));
        } else {
            profit = Math.max( arr[index] + f(index+1, 1, arr, n, fee), f(index+1, 0, arr, n, fee ));
        }
        return profit;
    }

    public int stockBuySellMemoized(int[] arr, int n, int fee) {
        int[][] dp = new int[n][2];
        for ( int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        return f(0,1, arr, n, fee, dp);
    }

    private int f(int index, int buy,  int[] arr, int n, int fee, int[][] dp) {
        if ( index == n) return 0;
        if ( dp[index][buy] != -1) return dp[index][buy];
        int profit = 0;
        if ( buy == 1){
            profit = Math.max(-arr[index] + f(index+1, 0, arr, n, fee, dp)-fee, f(index+1, 1, arr, n, fee, dp));
        } else {
            profit = Math.max( arr[index] + f(index+1, 1, arr, n, fee, dp), f(index+1, 0, arr, n, fee, dp ));
        }
        return dp[index][buy] = profit;
    }
}
