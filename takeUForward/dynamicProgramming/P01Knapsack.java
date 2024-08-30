package takeUForward.dynamicProgramming;

import java.util.Arrays;

public class P01Knapsack {
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        return f(n-1, maxWeight, weight, value);
    }

    private static int f(int index, int maxWeight, int[] weight, int [] value){
        if ( index == 0) {
            if ( weight[0] <= maxWeight) return value[0];
            else return 0;
        }
        int notPick = f(index-1, maxWeight, weight, value);
        int pick = (int) -1e9;
        if ( weight[index] <= maxWeight){
            pick = value[index] + f(index-1, maxWeight-weight[index], weight, value);
        }
        return Math.max(pick, notPick);
    }

    static int knapsackMemoized(int[] weight, int[] value, int n, int maxWeight) {
        int [][] memo = new int[n][maxWeight+1];
        for ( int[] row: memo) Arrays.fill(row, -1);
        return knapsackMemoized(n-1, maxWeight, weight, value, memo);
    }

    private static int knapsackMemoized(int index, int maxWeight, int[] weight, int [] value, int[][] memo){
        if ( index == 0) {
            if ( weight[0] <= maxWeight) return memo[index][maxWeight] = value[0];
            else return memo[index][maxWeight] = 0;
        }
        if ( memo[index][maxWeight] != -1) return memo[index][maxWeight];
        int notPick = knapsackMemoized(index-1, maxWeight, weight, value, memo);
        int pick = Integer.MIN_VALUE;
        if ( weight[index] <= maxWeight){
            pick = value[index] + knapsackMemoized(index-1, maxWeight-weight[index], weight, value, memo);
        }
        return memo[index][maxWeight] = Math.max(pick, notPick);
    }

    static int knapsackTabular(int[] weight, int[] value, int n, int maxWeight) {
        int [][] dp = new int[n][maxWeight+1];
        for ( int i=1; i<=maxWeight; i++){
            if ( weight[0] <= i) dp[0][i] = value[0];
            else dp[0][i] = 0;
        }
        for ( int i=1; i<n; i++){
            for ( int w=0; w<=maxWeight; w++){
                int notPick = dp[i-1][w];
                int pick = Integer.MIN_VALUE;
                if ( weight[i] <= w) pick = value[i]+ dp[i-1][w-weight[i]];
                dp[i][w] = Math.max(pick, notPick);
            }
        }
        return dp[n-1][maxWeight];
    }

    static int knapsackTabularSpaceOptimized(int[] weight, int[] value, int n, int maxWeight) {
        int [] prev = new int[maxWeight+1];
        for ( int i=1; i<=maxWeight; i++){
            if ( weight[0] <= i) prev[i] = value[0];
            else prev[i] = 0;
        }
        for ( int i=1; i<n; i++){
            int [] cur = new int[maxWeight+1];
            for ( int w=0; w<=maxWeight; w++){
                int notPick = prev[w];
                int pick = Integer.MIN_VALUE;
                if ( weight[i] <= w) pick = value[i]+ prev[w-weight[i]];
                cur[w] = Math.max(pick, notPick);
            }
            prev = cur;
        }
        return prev[maxWeight];
    }

    static int knapsackTabularSpaceOptimized2(int[] weight, int[] value, int n, int maxWeight) {
        int [] prev = new int[maxWeight+1];
        for ( int i=1; i<=maxWeight; i++){
            if ( weight[0] <= i) prev[i] = value[0];
            else prev[i] = 0;
        }
        for ( int i=1; i<n; i++){
            for ( int w=maxWeight; w>=0; w--){
                int notPick = prev[w];
                int pick = Integer.MIN_VALUE;
                if ( weight[i] <= w) pick = value[i]+ prev[w-weight[i]];
                prev[w] = Math.max(pick, notPick);
            }
        }
        return prev[maxWeight];
    }
}
