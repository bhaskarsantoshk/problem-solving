package takeUForward.dynamicProgramming.revision3;

import java.util.Arrays;

public class P16BestTimeToBuyAndSellStockWithTransactionFees {
    public int stockBuySell(int[] arr, int n, int fee) {
        return f(arr, 0, 1, n, fee);
    }

    private int f(int[] arr, int day, int buy, int n, int fee) {
        if ( day == n) return 0;
        int profit = 0;
        if ( buy == 1){
            profit = Math.max( -arr[day] + f(arr, day+1, 0, n, fee),
                    f(arr, day+1, 1, n, fee));
        } else {
            profit = Math.max( arr[day]-fee + f(arr, day+1, 1, n, fee),
                    f(arr, day+1, 0, n, fee));
        }
        return profit;
    }

    public int stockBuySellMemo(int[] arr, int n, int fee) {
        int [][] dp = new int[n][2];
        for ( int i=0; i<n; i++) Arrays.fill(dp[i],-1);
        return f(arr, 0, 1, n, fee, dp);
    }

    private int f(int[] arr, int day, int buy, int n, int fee, int[][] dp) {
        if ( day == n) return 0;
        if ( dp[day][buy] != -1) return dp[day][buy];
        int profit = 0;
        if ( buy == 1){
            profit = Math.max( -arr[day] + f(arr, day+1, 0, n, fee, dp),
                    f(arr, day+1, 1, n, fee, dp));
        } else {
            profit = Math.max( arr[day]-fee + f(arr, day+1, 1, n, fee, dp),
                    f(arr, day+1, 0, n, fee, dp));
        }
        return dp[day][buy] = profit;
    }

    public int stockBuySellDP(int[] arr, int n, int fee) {
        int [][] dp = new int[n+1][2];
        for ( int day=n-1; day>=0; day--){
            for ( int buy=0; buy<=1; buy++){
                int profit = 0;
                if ( buy == 1){
                    profit = Math.max( -arr[day] + dp[day+1][0], dp[day+1][1] );
                } else {
                    profit =Math.max( arr[day]-fee + dp[day+1][1], dp[day+1][0] );
                }
                dp[day][buy] = profit;
            }
        }
        return dp[0][1];
    }
}
