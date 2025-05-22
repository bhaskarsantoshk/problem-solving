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

    public int stockBuySellTabular(int[] arr, int n, int fee) {
        int[][] dp = new int[n+1][2];
        dp[n][0] = dp[n][1] = 0;
        for ( int index=n-1; index>=0; index--){
            for ( int buy=0; buy<=1; buy++){
                int profit = 0;
                if ( buy == 1){
                    profit = Math.max(-arr[index] + dp[index+1][0]-fee, dp[index+1][1]);
                } else {
                    profit = Math.max( arr[index] + dp[index+1][1], dp[index+1][0]);
                }
                dp[index][buy] = profit;
            }
        }
        return dp[0][1];
    }

    public int stockBuySellSpaceOptimized(int[] arr, int n, int fee) {
        int[] ahead = new int[2];
        int[] cur = new int[2];
        ahead[0] = ahead[1] = 0;
        for ( int index=n-1; index>=0; index--){
            for ( int buy=0; buy<=1; buy++){
                int profit = 0;
                if ( buy == 1){
                    profit = Math.max(-arr[index] + ahead[0]-fee, ahead[1]);
                } else {
                    profit = Math.max( arr[index] + ahead[1], ahead[0]);
                }
                cur[buy] = profit;
            }
            ahead = cur;
        }
        return cur[1];
    }
}
