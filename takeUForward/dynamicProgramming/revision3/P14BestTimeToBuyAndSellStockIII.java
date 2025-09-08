package takeUForward.dynamicProgramming.revision3;

import java.util.Arrays;

public class P14BestTimeToBuyAndSellStockIII {
    public int stockBuySellRec(int[] arr, int n) {
        return f(0, 1, 2, arr ); // day, buy, cap
    }

    private int f(int day, int buy, int cap, int[] arr) {
        if ( day == arr.length) return 0;
        if ( cap == 0) return 0;
        int profit = 0;
        if ( buy == 1){
            profit = Math.max ( -arr[day]+f(day+1, 0, cap, arr),
                    f(day+1, 1, cap, arr));
        } else {
            profit = Math.max(arr[day]+f(day+1, 1, cap-1, arr),
                    f(day+1, 0, cap, arr));
        }
        return profit;
    }

    public int stockBuySellMemo(int[] arr, int n) {
        int [][][] dp = new int[n][2][3];
        for ( int i=0; i<n; i++){
            for ( int buy=0; buy<=1; buy++){
                Arrays.fill(dp[i][buy], -1);
            }
        }
        return f(0, 1, 2, arr, dp ); // day, buy, cap
    }

    private int f(int day, int buy, int cap, int[] arr, int[][][] dp) {
        if ( day == arr.length) return 0;
        if ( cap == 0) return 0;
        if ( dp[day][buy][cap] != -1) return dp[day][buy][cap];
        int profit = 0;
        if ( buy == 1){
            profit = Math.max ( -arr[day]+f(day+1, 0, cap, arr, dp),
                    f(day+1, 1, cap, arr, dp));
        } else {
            profit = Math.max(arr[day]+f(day+1, 1, cap-1, arr, dp),
                    f(day+1, 0, cap, arr, dp));
        }
        return dp[day][buy][cap] = profit;
    }

    public int stockBuySellDP(int[] arr, int n) {
        int [][][] dp = new int[n+1][2][3];

        for ( int day=n-1; day>=0; day--){
            for ( int buy=0; buy<=1; buy++){
                for ( int cap=0; cap<=2; cap++){
                    int profit = 0;
                    if ( buy == 1){
                        profit = Math.max ( -arr[day]+dp[day+1][0][cap], dp[day+1][1][cap]);
                    } else {
                        profit = dp[day+1][0][cap];
                        if ( cap >= 1 ) profit = Math.max(arr[day]+dp[day+1][1][cap-1], profit);
                    }
                    dp[day][buy][cap] = profit;
                }
            }
        }

        return dp[0][1][2];
    }

    public int stockBuySellRecNby4(int[] arr, int n) {
        return f(0, 1, 2, arr ); // day, buy, cap
    }

    // N*4 solution
    private int f(int day, int transaction, int []prices ){
        if ( day == prices.length || transaction == 4) return 0;
        int profit = 0;
        if ( transaction % 2 == 0){
            profit = Math.max ( -prices[day]+f(day+1, transaction+1, prices),
                    f(day+1, transaction, prices));
        } else {
            profit = Math.max(prices[day]+f(day+1, transaction+1, prices),
                    f(day+1, transaction, prices));
        }
        return profit;
    }

    public int stockBuySellRecNby4Memo(int[] arr, int n) {
        int [][] dp = new int[n+1][4];
        for ( int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        return f(0, 0, arr, dp);
    }

    private int f(int day, int transaction, int []prices , int[][] dp){
        if ( day == prices.length || transaction == 4) return 0;
        if ( dp[day][transaction] != -1) return dp[day][transaction];
        int profit = 0;
        if ( transaction % 2 == 0){
            profit = Math.max ( -prices[day]+f(day+1, transaction+1, prices, dp),
                    f(day+1, transaction, prices, dp));
        } else {
            profit = Math.max(prices[day]+f(day+1, transaction+1, prices, dp),
                    f(day+1, transaction, prices, dp));
        }
        return dp[day][transaction] = profit;
    }

    public int stockBuySellNby4DP(int[] prices, int n) {
        int [][] dp = new int[n+1][5];
        for(int day=n-1; day>=0; day--){
            for ( int transaction=3; transaction>=0; transaction--){
                int profit = 0;
                if ( transaction % 2 == 0){
                    profit = Math.max ( -prices[day]+dp[day+1][transaction+1], dp[day+1][transaction]);
                } else {
                    profit = Math.max(prices[day]+dp[day+1][transaction+1], dp[day+1][transaction]);
                }
                dp[day][transaction] = profit;
            }
        }
        return dp[0][0];
    }

}
