package takeUForward.dynamicProgramming.revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P33PrintLongestIncreasingSubsequence {
    public List<Integer> longestIncreasingSubsequence(int[] arr) {
        int n = arr.length;
        int []dp = new int[n];
        Arrays.fill(dp, 1);
        int lastIndex = 0;
        int[] hash = new int[n];
        int max = 1;
        for ( int i=0; i<n; i++){
            hash[i] = i;
            for ( int prev = 0; prev<=i-1; prev++){
                if ( arr[i] > arr[prev] && 1+dp[prev] > dp[i] ){
                    dp[i] = 1 +dp[prev];
                    hash[i] = prev;
                }
            }
            if ( max < dp[i]){
                max = dp[i];
                lastIndex = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        while ( hash[lastIndex] != lastIndex){
         res.add(arr[lastIndex]);
         lastIndex = hash[lastIndex];
        }
        res.add(arr[lastIndex]);

        Collections.reverse(res);
        return res;
    }

    public int LIS(int[] arr) {
        return f(0, -1, arr);
    }

    private int f(int index, int prevIndex, int[] arr) {
        if ( index == arr.length) return 0;
        int notTake = f(index+1, prevIndex, arr);
        int take = 0;
        if ( prevIndex == -1 || arr[index] > arr[prevIndex]) take = 1+ f(index+1, index, arr);
        return Math.max(take, notTake);
    }

    public int LISMemo(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n+1];
        for ( int i=0; i<n; i++) Arrays.fill(dp, -1);
        return f(0, -1, arr);
    }

    private int f(int index, int prevIndex, int[] arr, int[][] dp) {
        if ( index == arr.length) return 0;
        if ( dp[index][prevIndex+1] != -1) return dp[index][prevIndex+1];
        int notTake = f(index+1, prevIndex, arr, dp);
        int take = 0;
        if ( prevIndex == -1 || arr[index] > arr[prevIndex]) take = 1+ f(index+1, index, arr, dp);
        return dp[index][prevIndex+1] = Math.max(take, notTake);
    }

    public int LISTabular(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n+1][n+1];
        for ( int index=n-1; index>=0; index--){
            for ( int prevIndex = index-1; prevIndex>=-1; prevIndex--){
                int notTake =dp[index+1][prevIndex+1];
                int take = 0;
                if ( prevIndex == -1 || arr[index] > arr[prevIndex]) take = 1+ dp[index+1][index+1];
                dp[index][prevIndex+1] = Math.max(take, notTake);
            }
        }
        return dp[0][0];
    }

    public int LISSpaceOptimized(int[] arr) {
        int n = arr.length;
        int[] ahead = new int[n+1];
        int[] cur = new int[n+1];
        for ( int index=n-1; index>=0; index--){
            for ( int prevIndex = index-1; prevIndex>=-1; prevIndex--){
                int notTake =ahead[prevIndex+1];
                int take = 0;
                if ( prevIndex == -1 || arr[index] > arr[prevIndex]) take = 1+ ahead[index+1];
                cur[prevIndex+1] = Math.max(take, notTake);
            }
            ahead = cur;
        }
        return ahead[0];
    }

    public int LISTabular2(int[] arr) {
        int n = arr.length;
        int []dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        for ( int i=0; i<n; i++){
            for ( int prev = 0; prev<=i-1; prev++){
               if ( arr[i] > arr[prev]) dp[i] = Math.max(dp[i], 1+ dp[prev]);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
