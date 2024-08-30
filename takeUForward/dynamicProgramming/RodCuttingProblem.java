package takeUForward.dynamicProgramming;

import java.util.Arrays;

public class RodCuttingProblem {
    public static int cutRod(int price[], int n) {
        return unboundedKnapSack(n-1,n, price);
    }

    private static int unboundedKnapSack(int index, int maxLen,  int[] price) {
        if ( index == 0){
            return maxLen * price[0];
        }

        int notTake = unboundedKnapSack(index-1, maxLen, price);
        int take = -(int)1e9;
        int rodLen = index+1;
        if ( rodLen <= maxLen){
            take = price[index]+ unboundedKnapSack(index, maxLen-rodLen, price);
        }
        return Math.max(take, notTake);
    }

    public static int cutRodMemo(int price[], int n) {
        int[][] memo = new int[n][n+1];
        for (int[] row: memo) Arrays.fill(row, -1);
        return unboundedKnapSackMemo(n-1,n, price, memo);
    }

    private static int unboundedKnapSackMemo(int index, int maxLen,  int[] price, int[][] memo) {
        if ( index == 0){
            return memo[index][maxLen] = maxLen * price[0];
        }
        if ( memo[index][maxLen] != -1) return memo[index][maxLen];
        int notTake = unboundedKnapSackMemo(index-1, maxLen, price, memo);
        int take = -(int)1e9;
        int rodLen = index+1;
        if ( rodLen <= maxLen){
            take = price[index]+ unboundedKnapSackMemo(index, maxLen-rodLen, price, memo);
        }
        return memo[index][maxLen] = Math.max(take, notTake);
    }
}
