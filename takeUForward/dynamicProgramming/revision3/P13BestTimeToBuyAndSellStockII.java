package takeUForward.dynamicProgramming.revision3;

import java.lang.reflect.Array;
import java.util.Arrays;

public class P13BestTimeToBuyAndSellStockII {
    public int stockBuySell(int[] arr, int n) {
        return f(0, true, arr);
    }

    private int f(int ind, boolean buy, int[] arr) {
        if ( ind == arr.length) return 0;
        int profit = 0;
        if ( buy ){
            profit = Math.max ( -arr[ind] + f(ind+1, false, arr), f(ind+1, true, arr));
        } else {
            profit = Math.max(arr[ind] + f(ind+1, true, arr), f(ind+1, false, arr));
        }
        return profit;
    }

    public int stockBuySellMemo(int[] arr, int n) {
        int [][] memo = new int[n][2];
        for ( int i=0; i<n; i++) Arrays.fill(memo[i], -1);
        return f(0, 1, arr, memo);
    }

    private int f(int ind, int buy, int[] arr, int[][] memo) {
        if ( ind == arr.length) return 0;
        if ( memo[ind][buy] != -1) return memo[ind][buy];
        int profit = 0;
        if ( buy==1 ){
            profit = Math.max ( -arr[ind] + f(ind+1, 0, arr, memo), f(ind+1, 1, arr, memo));
        } else {
            profit = Math.max(arr[ind] + f(ind+1, 1, arr, memo), f(ind+1, 0, arr, memo));
        }
        return memo[ind][buy] = profit;
    }

    public int stockBuySellDP(int[] arr, int n) {
        int [][] dp = new int[n+1][2];
        dp[n][0] = dp[n][1] = 0;
        for ( int i=n-1; i>=0; i--){
            for ( int buy=0; buy<=1; buy++){
                int profit = 0;
                if ( buy==1 ){
                    profit = Math.max ( -arr[i] + dp[i+1][0], dp[i+1][1]);
                } else {
                    profit = Math.max(arr[i] + dp[i+1][1], dp[i+1][0]);
                }
                dp[i][buy] = profit;
            }
        }
        return dp[0][1];
    }
}
