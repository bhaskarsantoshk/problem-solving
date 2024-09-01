package takeUForward.dynamicProgramming;

import java.util.Arrays;

public class DP41LongestIncreasingSubsequenceMemoization {
    public static int longestIncreasingSubsequence(int arr[]) {
        return f(0, -1, arr);
    }

    private static int f(int index, int prevIndex, int[] arr) {
        if ( index == arr.length) return 0;
        int notTake = f(index+1, prevIndex, arr);
        int take = 0;
        if ( prevIndex == -1 || arr[index] > arr[prevIndex]){
            take = 1 + f(index+1, index, arr);
        }
        return Math.max( take, notTake);
    }

    public static int longestIncreasingSubsequenceMemo(int arr[]) {
        int n = arr.length;
        // gives Runtime error because we are creating 10^5 * 10^5 + 1 array
        int [][] memo = new int[n][n+1];
        for ( int [] row: memo) Arrays.fill(row, -1);
        return lisMemo(0, -1, arr, memo);
    }

    private static int lisMemo(int index, int prevIndex, int[] arr, int[][] memo) {
        if ( index == arr.length) return 0;
        if ( memo[index][prevIndex+1] != -1) return memo[index][prevIndex+1];
        int notTake = lisMemo(index+1, prevIndex, arr, memo);
        int take = 0;
        if ( prevIndex == -1 || arr[index] > arr[prevIndex]){
            take = 1 + lisMemo(index+1, index, arr, memo);
        }
        return memo[index][prevIndex+1] = Math.max( take, notTake);
    }

    public static int longestIncreasingSubsequenceTabular(int arr[]) {
        int n = arr.length;
        // gives Runtime error because we are creating 10^5 * 10^5 + 1 array
        int [][] dp = new int[n+1][n+1];
        for ( int index=n-1; index>=0; index--){
            for ( int prevIndex= index-1; prevIndex>=-1; prevIndex--){
                int len = dp[index+1][prevIndex+1];
                if ( prevIndex == -1 || arr[index] > arr[prevIndex]){
                    len = Math.max( len, 1+dp[index+1][index+1]);
                }
                dp[index][prevIndex+1] = len;
            }
        }
        return dp[0][0];
    }
}
