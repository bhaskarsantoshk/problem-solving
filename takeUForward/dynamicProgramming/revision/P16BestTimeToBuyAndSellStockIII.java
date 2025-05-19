package takeUForward.dynamicProgramming.revision;

import java.util.Arrays;

public class P16BestTimeToBuyAndSellStockIII {
    public int stockBuySell(int[] arr, int n) {
        return f(0, 1, 2, arr, n);
    }

    private int f(int index, int buy, int cap, int[] arr, int n) {
        if ( cap == 0 || index == n) return 0;

        int profit = 0;
        int max = 0;
        if ( buy == 1){
            profit = Math.max ( -arr[index] + f(index+1, 0, cap, arr, n),
                    f(index+1, 1, cap, arr , n));
        } else {
            profit = Math.max( arr[index]+ f(index+1, 1, cap-1, arr, n),
                    f(index+1, 0, cap, arr, n));
        }
        return profit;
    }

    public int stockBuySellMemoized(int[] arr, int n) {
        int[][][] dp = new int[n+1][2][3];
        for ( int i=0; i<dp.length; i++){
            for ( int j=0; j<dp[0].length; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return f(0, 1, 2, arr, n, dp);
    }

    private int f(int index, int buy, int cap, int[] arr, int n, int[][][] dp) {
        if ( cap == 0 || index == n) return 0;

        int profit = 0;
        if ( dp[index][buy][cap] != -1) return dp[index][buy][cap];
        if ( buy == 1){
            profit = Math.max ( -arr[index] + f(index+1, 0, cap, arr, n, dp),
                    f(index+1, 1, cap, arr , n, dp));
        } else {
            profit = Math.max( arr[index]+ f(index+1, 1, cap-1, arr, n, dp),
                    f(index+1, 0, cap, arr, n, dp));
        }
        return dp[index][buy][cap] =profit;
    }
}
