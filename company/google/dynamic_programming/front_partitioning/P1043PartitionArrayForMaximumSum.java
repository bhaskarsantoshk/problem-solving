package company.google.dynamic_programming.front_partitioning;

import java.util.Arrays;

public class P1043PartitionArrayForMaximumSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        return f(arr, 0, arr.length, k);
    }

    private int f(int[] arr, int i, int n, int k) {
        if ( i == n) return 0;
        int maxSum = Integer.MIN_VALUE;
        int len = 0;
        int maxElement = 0;
        for ( int j=i; j< Math.min(j+k, n); j++){
            len++;
            maxElement = Math.max(maxElement, arr[j]);
            int sum = len * maxElement + f(arr, j+1, n, k);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public int maxSumAfterPartitioningMemo(int[] arr, int k) {
        int n = arr.length;
        int [] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return fMemo(arr, 0, arr.length, k, memo);
    }

    private int fMemo(int[] arr, int i, int n, int k, int[] memo) {
        if ( i == n) return memo[i]= 0;
        int maxSum = Integer.MIN_VALUE;
        int len = 0;
        int maxElement = Integer.MIN_VALUE;
        if ( memo[i] != -1) return memo[i];
        for ( int j=i; j< Math.min(i+k, n); j++){
            len++;
            maxElement = Math.max(maxElement, arr[j]);
            int sum = len * maxElement + fMemo(arr, j+1, n, k, memo);
            maxSum = Math.max(maxSum, sum);
        }
        return memo[i]= maxSum;
    }


    public int maxSumAfterPartitioningTabular(int[] arr, int k) {
        int n = arr.length;
        int [] dp = new int[n+1];
        for ( int i=n-1; i>=0; i--){
            int maxSum = Integer.MIN_VALUE;
            int len = 0;
            int maxElement = Integer.MIN_VALUE;
            for ( int j=i; j< Math.min(i+k, n); j++){
                len++;
                maxElement = Math.max(maxElement, arr[j]);
                int sum = len * maxElement + dp[j+1];
                maxSum = Math.max(maxSum, sum);
            }
             dp[i]= maxSum;
        }
        return dp[0];
    }

}
