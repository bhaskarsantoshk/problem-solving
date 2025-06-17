package takeUForward.dynamicProgramming.revision;

import java.util.Arrays;

public class P47MatrixChainMultiplication {
    public int matrixMultiplication(int[] nums) {
        return f(1, nums.length-1, nums);
    }

    private int f(int i, int j, int[] nums) {
        if ( i == j) return 0;
        int min = (int)1e9;
        for ( int k=i; k<=j-1; k++){
            int steps = nums[i-1] * nums[k]* nums[j] + f(i, k, nums) + f(k+1, j, nums);
            min = Math.min(steps, min);
        }
        return min;
    }

    public int matrixMultiplicationMemoized(int[] nums) {
        int n = nums.length;
        int [][] dp = new int[n][n];
        for ( int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        return f(1, nums.length-1, nums, dp);
    }

    private int f(int i, int j, int[] nums, int[][] dp) {
        if ( i == j) return 0;
        if ( dp[i][j] != -1) return dp[i][j];
        int min = (int)1e9;
        for ( int k=i; k<=j-1; k++){
            int steps = nums[i-1] * nums[k]* nums[j] + f(i, k, nums) + f(k+1, j, nums);
            min = Math.min(steps, min);
        }
        return dp[i][j]=min;
    }
}
