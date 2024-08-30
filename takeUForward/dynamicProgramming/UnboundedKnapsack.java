package takeUForward.dynamicProgramming;

import java.util.Arrays;

public class UnboundedKnapsack {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        return f(n-1, w, profit, weight);
    }

    private static int f(int index, int maxWeight, int[] values, int[] weights) {
        if ( index == 0){
            return ( maxWeight/ weights[0] ) * values[0] ; // weights[0] cannot be < 1
        }
        int notTake = f(index-1, maxWeight, values, weights);
        int take = -(int)1e9;
        if ( weights[index] <= maxWeight){
            take = values[index]+f(index, maxWeight-weights[index], values, weights);
        }

        return Math.max(take, notTake);
    }

    public static int unboundedKnapsackMemoized(int n, int w, int[] profit, int[] weight) {
        int [][] memo = new int[n][w+1];
        for ( int[] row: memo) Arrays.fill(row, -1);
        return unboundedKnapsackMemoized(n-1, w, profit, weight, memo);
    }

    private static int unboundedKnapsackMemoized(int index, int maxWeight, int[] values, int[] weights, int[][] memo) {
        if ( index == 0){
            return memo[index][maxWeight] = ( maxWeight/ weights[0] ) * values[0] ; // weights[0] cannot be < 1
        }
        if ( memo[index][maxWeight] != -1) return memo[index][maxWeight];
        int notTake = unboundedKnapsackMemoized(index-1, maxWeight, values, weights, memo);
        int take = -(int)1e9;
        if ( weights[index] <= maxWeight){
            take = values[index]+unboundedKnapsackMemoized (index, maxWeight-weights[index], values, weights, memo);
        }

        return memo[index][maxWeight] = Math.max(take, notTake);
    }
}
