package takeUForward.dynamicProgramming.revision;

import java.util.Arrays;

public class P30UnboundedKnapsack {
    public int unboundedKnapsack(int[] wt, int[] val, int n, int W) {
        return f(0, wt, val, W);
    }

    private int f(int index, int[] wt, int[] val, int w) {
        if ( index == wt.length){
            return 0;
        }
        int notTake = f(index+1, wt, val, w);
        int take = 0;
        if ( w-wt[index] >=0){
            take = f(index, wt, val, w-wt[index])+val[index];
        }
        return Math.max(take, notTake);
    }

    public int unboundedKnapsackMemoized(int[] wt, int[] val, int n, int W) {
        int [][] dp = new int[n][W+1];
        for ( int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        return f(0, wt, val, W, dp);
    }

    private int f(int index, int[] wt, int[] val, int w, int[][] dp) {
        if ( index == wt.length){
            return 0;
        }
        if ( dp[index][w] != -1) return dp[index][w];
        int notTake = f(index+1, wt, val, w);
        int take = 0;
        if ( w-wt[index] >=0){
            take = f(index, wt, val, w-wt[index])+val[index];
        }
        return dp[index][w] = Math.max(take, notTake);
    }

    public int unboundedKnapsackTabular(int[] wt, int[] val, int n, int W) {
        int [][] dp = new int[n+1][W+1];
        for ( int index=n-1; index>=0; index--){
            for ( int w=0; w<=W; w++){
                int notTake = dp[index+1][w];
                int take = 0;
                if ( w-wt[index] >=0){
                    take = dp[index][w-wt[index]]+val[index];
                }
                dp[index][w] = Math.max(take, notTake);
            }
        }
        return dp[0][W];
    }
}
