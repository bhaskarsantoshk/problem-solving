package takeUForward.dynamicProgramming.revision;

import java.util.Arrays;

public class P17BestTimeToBuyAndSellStockIV {
    public int stockBuySell(int[] arr, int n, int k) {
        return f(0, 1, k, arr, n);
    }

    private int f(int index, int buy, int cap, int[] arr, int n) {
        if ( cap == 0 || index == n) return 0;

        int profit = 0;
        if ( buy == 1){
            profit = Math.max ( -arr[index] + f(index+1, 0, cap, arr, n),
                    f(index+1, 1, cap, arr , n));
        } else {
            profit = Math.max( arr[index]+ f(index+1, 1, cap-1, arr, n),
                    f(index+1, 0, cap, arr, n));
        }
        return profit;
    }

    public int stockBuySellMemoized(int[] arr, int n, int k) {
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

    public int stockBuySellTabular(int[] arr, int n, int k) {
        int[][][] dp = new int[n+1][2][k+1];
        dp[n][0][0] = 0;
        dp[n][1][0] = 0;
        int profit = 0;
        for ( int index=n-1; index>=0; index--) {
            for (int buy = 0; buy <= 1; buy++) {
                for ( int cap=k; cap>0; cap--){
                    if ( buy == 1){
                        profit = Math.max ( -arr[index] + dp[index+1][0][cap],
                                dp[index+1][1][cap]);
                    } else {
                        profit = Math.max( arr[index]+ dp[index+1][1][cap-1],
                                dp[index+1][0][cap]);
                    }
                    dp[index][buy][cap] = profit;
                }
            }
        }
        return dp[0][1][k];
    }

    public int stockBuySellSpaceOptimized(int[] arr, int n, int k) {
        int[][] ahead = new int [2][k+1];
        int [][] cur = new int [2][k+1];
        for ( int buy = 0; buy <=1; buy++){
            for ( int cap=0; cap<=2; cap++){
                ahead[buy][cap] = 0;
            }
        }
        int profit = 0;
        for ( int index=n-1; index>=0; index--){
            for ( int buy=0; buy<=1; buy++){
                for ( int cap=k; cap>0; cap--){
                    if ( buy == 1){
                        profit = Math.max ( -arr[index] + ahead[0][cap],
                                ahead[1][cap]);
                    } else {
                        profit = Math.max( arr[index]+ ahead[1][cap-1],
                                ahead[0][cap]);
                    }
                    cur[buy][cap] = profit;
                }
            }
            ahead = cur;
        }

        return ahead[1][k];
    }
}
