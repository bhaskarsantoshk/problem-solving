package company.microsoft.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        return f(nums, 0, -1);
    }

    private int f(int[] nums, int index, int prevIndex) {
        if ( index == nums.length) {
            return 0;
        }
        int notTake = f(nums, index+1, prevIndex);
        int take =0;
        if ( prevIndex == -1 || nums[index] > nums[prevIndex]){
            take = 1 + f(nums, index+1, index);
        }
        return Math.max(take, notTake);
    }

    public int lengthOfLISMemo(int[] nums) {
        int n = nums.length;
        int[][] memo = new int[n+1][n+1];
        for ( int i=0;i<=n; i++) Arrays.fill(memo[i], -1);
        return f(nums, 0, -1, memo);
    }

    private int f(int[] nums, int index, int prevIndex, int[][] memo) {
        if ( index == nums.length) {
            return 0;
        }
        if (memo[index+1][prevIndex+1] != -1) return memo[index+1][prevIndex+1];
        int notTake = f(nums, index+1, prevIndex, memo);
        int take =0;
        if ( prevIndex == -1 || nums[index] > nums[prevIndex]){
            take = 1 + f(nums, index+1, index, memo);
        }
        return  memo[index+1][prevIndex+1] = Math.max(take, notTake);
    }
}
