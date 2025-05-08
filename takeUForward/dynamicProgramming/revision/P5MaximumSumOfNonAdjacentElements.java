package takeUForward.dynamicProgramming.revision;

import java.util.Arrays;

public class P5MaximumSumOfNonAdjacentElements {
    public int nonAdjacent(int[] nums) {
        // f(index) = max sum of non-adjacent elements from [0 -index]
        return nonAdjacent(nums, nums.length-1);
    }

    private int nonAdjacent(int[] nums, int index) {
        if ( index < 0){
            return 0;
        }
        if ( index == 0) return nums[0];
        int pick = nums[index] + nonAdjacent(nums, index-2);
        int nonPick = nonAdjacent(nums, index-1);
        return Math.max( pick, nonPick);
    }

    public int nonAdjacentMemoIzed(int[] nums) {
        // f(index) = max sum of non-adjacent elements from [0 -index]
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return nonAdjacent(nums, nums.length-1, dp);
    }

    private int nonAdjacent(int[] nums, int index, int[] dp) {
        if ( index < 0){
            return 0;
        }
        if ( index == 0) return nums[0];
        if ( dp[index] != -1) return dp[index];
        int pick = nums[index] + nonAdjacent(nums, index-2, dp);
        int nonPick = nonAdjacent(nums, index-1, dp);
        return dp[index] = Math.max( pick, nonPick);
    }

    public int nonAdjacentTabular(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for ( int i=1; i<n; i++){
            int nonPick = dp[i-1];
            int pick = nums[i];
            if ( i > 1) pick += dp[i-2];
            dp[i] = Math.max(pick, nonPick);
        }
        return dp[n-1];
    }

    public int nonAdjacentSpaceOptimization(int[] nums) {
        int n = nums.length;
        int prev = nums[0];
        int prev2 =0;
        for ( int i=1; i<n; i++){
            int nonPick = prev;
            int pick = nums[i];
            if ( i > 1) pick += prev2;
            int cur = Math.max(pick, nonPick);
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }
}
