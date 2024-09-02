package takeUForward.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

    public static int longestIncreasingSubsequenceTabularSpaceOptimization(int arr[]) {
        int n = arr.length;
        int []next = new int[n+1];
        int []cur = new int[n+1];
        for ( int index=n-1; index>=0; index--){
            for ( int prevIndex= index-1; prevIndex>=-1; prevIndex--){
                int len = next[prevIndex+1];
                if ( prevIndex == -1 || arr[index] > arr[prevIndex]){
                    len = Math.max( len, 1+next[index+1]);
                }
                cur[prevIndex+1] = len;
            }
            next = (int[]) cur.clone();
        }
        return cur[0];
    }

    public static int longestIncreasingSubsequenceTabularSpaceOptimization2(int arr[]) {
        int n = arr.length;
        int max = 0;
        int [] hash = new int[n];

        int []dp = new int[n];
        int lastIndex = 0;
        Arrays.fill(dp, 1);
        for ( int index=0; index<n; index++){
            hash[index] = index;
            for ( int prev=0; prev<=index-1; prev++){
                if ( arr[index] > arr[prev] && 1 + dp[prev] > dp[index]) {
                    dp[index] = 1+dp[prev];
                    hash[index] = prev;
                }
            }
           if ( dp[index] > max){
               max = dp[index];
               lastIndex = index;
           }
        }
        List<Integer> lis = new ArrayList<>();
        lis.add(arr[lastIndex]);
        while ( hash[lastIndex] != lastIndex){
            lastIndex = hash[lastIndex];
            lis.add(hash[lastIndex]);
        }
        Collections.reverse(lis); // this is the LIS
        return max;
    }


    public static int longestIncreasingSubsequenceBinarySearch(int arr[]) {
        List<Integer> temp = new ArrayList<>(); // Not a LIS, it's just to get the length
        temp.add(arr[0]);
        int n = arr.length;
        int len = 0;
        for ( int i=1; i<n; i++){
            if ( arr[i] > temp.getLast()){
                temp.add(arr[i]);
                len++;
            } else {
                int index = Collections.binarySearch(temp, arr[i]);
                if ( index < 0){
                    index = Math.abs(index)-1;
                    temp.set(index, arr[i]);
                }
            }
        }
        return len;
    }

}
