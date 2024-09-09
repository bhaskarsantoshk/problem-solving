package company.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {
    public static int longestIncreasingSubsequence(int arr[]) {
        return lis(0, -1, arr);
    }

    private static int lis(int index, int prevIndex, int[] arr) {
        if ( index == arr.length) return 0;

        int notTake = lis(index+1, prevIndex, arr);
        int take = 0;
        if ( prevIndex == -1 || arr[index] > arr[prevIndex]){
            take = 1+ lis(index+1, index, arr);
        }
        return Math.max(take, notTake);
    }

    public static int longestIncreasingSubsequenceMemo(int arr[]) {
        int n = arr.length;
        int [][] memo = new int[n][n+1];
        for ( int row[]: memo) Arrays.fill(row, -1);
        return lisMemo(0, -1, arr, memo);
    }

    private static int lisMemo(int index, int prevIndex, int[] arr, int[][] memo) {
        if ( index == arr.length) return memo[index][prevIndex+1] = 0;
        if ( memo[index][prevIndex+1] != -1) return memo[index][prevIndex+1];

        int notTake = lisMemo(index+1, prevIndex, arr, memo);
        int take = 0;
        if ( prevIndex == -1 || arr[index] > arr[prevIndex]){
            take = 1+ lisMemo(index+1, index, arr, memo);
        }
        return memo[index][prevIndex+1] = Math.max(take, notTake);
    }

    public static int longestIncreasingSubsequenceTabular(int arr[]) {
        int n = arr.length;
        int [][] dp = new int[n+1][n+1];
        for ( int index=n-1; index>=0; index--){
            for ( int prevIndex =index-1; prevIndex >= -1 ; prevIndex--  ){
                int notTake = dp[index+1][prevIndex];
                int take = 0;
                if ( prevIndex == -1 || arr[index] > arr[prevIndex]){
                    take = 1+ dp[index+1][index];
                }
                dp[index][prevIndex+1] = Math.max(take, notTake);
            }
        }
        return dp[0][0];
    }

    public static int longestIncreasingSubsequenceTabularSpaceOptimization2(int arr[]) {
        int n = arr.length;
        int [] dp = new int[n];
        int [] hash = new int[n];

        Arrays.fill(dp, 1);
        int max = 0;
        int lastIndex = -1;
        for ( int i=0; i<n; i++){
            hash[i] = i;
            for ( int prev = 0; prev <= i-1; prev++){
                if ( arr[i] > arr[prev] && 1+dp[prev] > dp[i]){
                    dp[i] = 1+dp[prev];
                    hash[i] = prev;
                }
            }
            if ( dp[i] > max){
                max = dp[i];
                lastIndex = i;
            }
        }

        List<Integer> lis = new ArrayList<>();
        lis.add(arr[lastIndex]);
        while ( hash[lastIndex] != lastIndex){
            lastIndex = hash[lastIndex];
            lis.add(arr[lastIndex]);
        }
        Collections.reverse(lis);
        return max;
    }
}
