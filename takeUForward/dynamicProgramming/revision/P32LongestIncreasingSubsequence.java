package takeUForward.dynamicProgramming.revision;

import java.util.Arrays;

public class P32LongestIncreasingSubsequence {
    public int LIS(int[] nums) {
        return f(0, -1, nums);
    }

    private int f(int index, int prevIndex, int[] nums) {
        if ( index == nums.length) return 0;
        int notTake = f( index+1, prevIndex, nums);
        int take = 0;
        if ( prevIndex == -1|| nums[index] > nums[prevIndex]) {
            take = f(index+1, index, nums);
        }
        return Math.max(take, notTake);
    }

    public int LISMemoized(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n+1];
        for ( int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        return f(0, -1, nums , dp);
    }

    private int f(int index, int prevIndex, int[] nums, int[][] dp) {
        if ( index == nums.length) {
            return 0;
        }
        if ( dp[index][prevIndex+1] != -1) return dp[index][prevIndex+1];
        int notTake = f( index+1, prevIndex, nums, dp);
        int take = 0;
        if ( prevIndex == -1 || nums[index] > nums[prevIndex]) {
            take = 1+f(index+1, index, nums, dp);
        }
        return dp[index][prevIndex+1] = Math.max(take, notTake);
    }

    public int LISTabular(int[] nums) {
        return 0;
    }


}
