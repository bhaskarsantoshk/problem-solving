package takeUForward.dynamicProgramming;

import java.util.Arrays;

public class CountSubsetsWithSumK {
    public static int findWays(int nums[], int target) {
        return findWays(nums, target, nums.length-1);
    }

    private static int findWays(int[] nums, int target, int index) {
        if ( target == 0) return 1;
        if ( index == 0){
            if ( target == nums[index]) return 1;
        }
        if ( index < 0 || target <0) return 0;
        int pick = 0;
        if ( nums[index] <= target) pick = findWays(nums, target-nums[index], index-1);
        int notPick = findWays(nums, target, index-1);
        return pick+notPick;
    }

    static int MOD = 1000000007;
    public static int findWaysMemoized(int nums[], int target) {
        int [][] memo = new int[nums.length][target+1];
        for ( int [] row: memo) Arrays.fill(row, -1);
        return findWaysMemoized(nums, target, nums.length-1, memo);
    }

    private static int findWaysMemoized(int[] nums, int target, int index, int[][] memo) {
        // Base case for the first element
        if (index == 0) {
            if (target == 0 && nums[index] == 0) return memo[index][target] = 2;
            if (target== 0 || target == nums[index]) return memo[index][target] = 1;
        }

        // If the index is invalid or target is negative, return 0 (no valid way)
        if (index < 0 || target < 0) return 0;

        // Check if the result is already computed
        if (memo[index][target] != -1) return memo[index][target];

        // Recursive cases: pick or not pick the current element
        int pick = 0;
        if (nums[index] <= target)
            pick = findWaysMemoized(nums, target - nums[index], index - 1, memo);
        int notPick = findWaysMemoized(nums, target, index - 1, memo);

        // Store the result in the memoization table
        return memo[index][target] = (pick%MOD + notPick%MOD)%MOD;
    }
}
