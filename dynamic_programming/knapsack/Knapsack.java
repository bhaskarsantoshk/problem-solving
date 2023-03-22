package dynamic_programming.knapsack;

import java.util.Arrays;
import java.util.List;

public class Knapsack {
    public int getMaximumKnapsackValue (int c, List<Integer> weights, List<Integer> values, int n) {
        if ( c == 0 || n == 0){
            return 0;
        }
        if ( weights.get(n-1) <= c){
            return Math.max(values.get(n-1) + getMaximumKnapsackValue(c-weights.get(n-1), weights, values, n-1) ,
                    getMaximumKnapsackValue(c, weights, values, n-1));
        }
        return getMaximumKnapsackValue(c, weights, values, n-1);
    }

    public int getMaximumKnapsackValueMemoized ( int c, List<Integer> weights, List<Integer> values, int n ) {
        int [][] memo = new int[n+1][c+1];
        for ( int[] row: memo) {
            Arrays.fill(row, -1);
        }
        return getMaximumKnapsackValue(c,weights, values, n, memo);
    }

    private int getMaximumKnapsackValue(int c, List<Integer> weights, List<Integer> values, int n, int[][] memo) {
        return 0;
    }
}