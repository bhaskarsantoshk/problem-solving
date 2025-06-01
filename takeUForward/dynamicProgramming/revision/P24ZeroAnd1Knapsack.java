package takeUForward.dynamicProgramming.revision;

import java.util.Arrays;

public class P24ZeroAnd1Knapsack {
    public int knapsack01(int[] wt, int[] val, int n, int W) {
        return f(n-1, wt, val, W);
    }

    private int f(int index, int[] wt, int[] val, int W) {
        if( index == -1 || W == 0) return 0;
        int notTaken = f(index-1, wt, val, W);
        int take = 0;
        if ( W - wt[index] >=0 ) take = val[index]+ f(index-1, wt, val, W-wt[index]);
        return Math.max(take, notTaken);
    }

    public int knapsack01Memoized(int[] wt, int[] val, int n, int W) {
        int [][]dp = new int[n][W+1];
        for ( int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        return f(n-1, wt, val, W, dp);
    }

    private int f(int index, int[] wt, int[] val, int W, int[][] dp) {
        if( index == -1 || W == 0) return 0;
        if ( dp[index][W] != 0) return dp[index][W];
        int notTaken = f(index-1, wt, val, W);
        int take = 0;
        if ( W - wt[index] >=0 ) take = val[index]+ f(index-1, wt, val, W-wt[index]);
        return dp[index][W] = Math.max(take, notTaken);
    }

    public int knapsack01Tabular(int[] wt, int[] val, int n, int W) {
        int [][]dp = new int[n][W+1];
        for ( int w=0; w<=W; w++){
            if ( wt[0] <= w ) dp[0][w] = val[0];
        }
        for ( int i=1; i<n; i++){
            for ( int w=1; w<=W; w++){
                int notTaken = dp[i-1][w];
                int take = 0;
                if ( w - wt[i] >=0 ) take = val[i]+ dp[i-1][w-wt[i]];
                dp[i][w] = Math.max(take, notTaken);
            }
        }
        return dp[n-1][W];
    }


}
