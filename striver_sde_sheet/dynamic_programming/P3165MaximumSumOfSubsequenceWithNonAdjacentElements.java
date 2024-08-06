package striver_sde_sheet.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;

public class P3165MaximumSumOfSubsequenceWithNonAdjacentElements {
    public int maximumSumSubsequence(int[] nums, int[][] queries) {
        // TODO
        return 0;
    }

    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        int memo[] = new int[nums.size()];
        Arrays.fill(memo, -1);
        return maximumNonAdjacentSumMemoized(nums, nums.size()-1, memo);
    }

    private static int maximumNonAdjacentSumMemoized(ArrayList<Integer> nums, int index, int[] memo) {
        if (index == 0) return nums.get(index);
        if ( index < 0) return 0;
        if ( memo[index] != -1) return memo[index];
        int pick = nums.get(index) + maximumNonAdjacentSumMemoized(nums, index-2, memo);
        int notPick = maximumNonAdjacentSumMemoized(nums, index-1, memo);
        return memo[index] = Math.max(pick, notPick);
    }
}
