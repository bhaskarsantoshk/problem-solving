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

    public static int maximumNonAdjacentSumTabular(ArrayList<Integer> nums) {
        if ( nums == null || nums.size() == 0) return 0;
        if ( nums.size() == 1) return nums.get(0);
        int dp[] = new int[nums.size()];
        dp[0] = nums.get(0);
        int negative = 0;
        for ( int i=1; i<nums.size(); i++){
           int pick = nums.get(i);
           if ( i > 1) pick += dp[i-2];
           int notPick = dp[i-1];
           dp[i] = Math.max(pick, notPick);
        }
        return dp[nums.size()-1];
    }

    public static int maximumNonAdjacentSumTabularSpaceOptimization(ArrayList<Integer> nums) {
        if ( nums == null || nums.size() == 0) return 0;
        if ( nums.size() == 1) return nums.get(0);
        int ans , prev , prev2;
        ans = 0;
        prev = prev2 = nums.get(0);
        for ( int i=1; i<nums.size(); i++){
            int pick = nums.get(i);
            if ( i > 1) pick += prev2;
            int notPick = prev;
            ans = Math.max(pick, notPick);
            prev2 = prev;
            prev = ans;
        }
        return ans;
    }
}
