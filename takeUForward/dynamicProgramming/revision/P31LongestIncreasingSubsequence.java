package takeUForward.dynamicProgramming.revision;

import java.util.Arrays;

public class P31LongestIncreasingSubsequence {
    public int LIS(int[] nums) {
        return f(nums.length-1, nums.length, nums);
    }

    private int f(int index, int prevIndex, int[] nums) {
        if ( index == -1) return 0;
        int notTake = f( index-1, prevIndex, nums);
        int take = 0;
        if ( prevIndex == nums.length || nums[index] > nums[prevIndex]) {
            take = f(index-1, index, nums);
        }
        return Math.max(take, notTake);
    }

    public int LISMemoized(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n+1];
        for ( int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        return f(n-1, n, nums, dp);
    }

    private int f(int index, int prevIndex, int[] nums, int[][] dp) {
        if ( index == -1) {
            return 0;
        }
        if ( dp[index][prevIndex] != -1) return dp[index][prevIndex];
        int notTake = f( index-1, prevIndex, nums, dp);
        int take = 0;
        if ( prevIndex == nums.length || nums[index] < nums[prevIndex]) {
            take = f(index-1, index, nums, dp);
        }
        return dp[index][prevIndex] = Math.max(take, notTake);
    }

}
