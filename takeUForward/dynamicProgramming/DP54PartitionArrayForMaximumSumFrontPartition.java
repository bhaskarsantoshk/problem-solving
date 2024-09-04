package takeUForward.dynamicProgramming;

import java.util.Arrays;

public class DP54PartitionArrayForMaximumSumFrontPartition {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        return f(0, arr.length, arr, k);
    }

    private int f(int i, int n, int[] arr, int k) {
        if ( i == n) return 0;
        int maxi = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        int len = 0;
        for ( int j=i; j<Math.min(n, i+k); j++){
            len++;
            max = Math.max( max, arr[j]);
            int sum = max * len + f(j+1, n, arr, k);
            maxi = Math.max( maxi, sum);
        }
        return maxi;

    }

    public int maxSumAfterPartitioningMemo(int[] arr, int k) {
        int []memo = new int[arr.length];
        Arrays.fill(memo, -1);
        return fMemo(0, arr.length, arr, k, memo);
    }

    private int fMemo(int i, int n, int[] arr, int k, int[] memo) {
        if ( i == n) return 0;
        int maxi = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        if ( memo[i] != -1) return memo[i];
        int len = 0;
        for ( int j=i; j<Math.min(n, i+k); j++){
            len++;
            max = Math.max( max, arr[j]);
            int sum = max * len + fMemo(j+1, n, arr, k, memo);
            maxi = Math.max( maxi, sum);
        }
        return memo[i]= maxi;

    }

    public int maxSumAfterPartitioningTabular(int[] arr, int k) {
        int n = arr.length;
        int []dp = new int[n+1];
        for ( int i=n-1; i>=0; i--){
            int maxi = Integer.MIN_VALUE;
            int max = Integer.MIN_VALUE;
            int len = 0;
            for ( int j=i; j<Math.min(n, i+k); j++){
                len++;
                max = Math.max( max, arr[j]);
                int sum = max * len + dp[j+1];
                maxi = Math.max( maxi, sum);
            }
            dp[i] = maxi;
        }
        return dp[0];
    }
}

/*
https://leetcode.com/problems/partition-array-for-maximum-sum/
 */
