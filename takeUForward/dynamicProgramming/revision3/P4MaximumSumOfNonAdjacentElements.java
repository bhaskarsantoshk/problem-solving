package takeUForward.dynamicProgramming.revision3;

import java.util.Arrays;

public class P4MaximumSumOfNonAdjacentElements {
    public int nonAdjacent(int[] nums) {
        int n = nums.length;
        return nonAdjacent(nums, n-1);
    }

    private int nonAdjacent(int[] nums, int index) {
        if ( index < 0) return 0;
        int pick = nums[index] + nonAdjacent(nums, index-2);
        int notPick = nonAdjacent(nums, index-1);
        return Math.max(pick, notPick);
    }

    public int nonAdjacentMemoized(int[] nums) {
        int n = nums.length;
        int []memo = new int[n];
        Arrays.fill(memo, -1);
        return nonAdjacent(nums, n-1, memo);
    }

    private int nonAdjacent(int[] nums, int index, int[] memo) {
        if ( index < 0) return 0;
        if ( memo[index] != -1) return memo[index];
        int pick = nums[index] + nonAdjacent(nums, index-2, memo);
        int notPick = nonAdjacent(nums, index-1, memo);
        return memo[index] = Math.max(pick, notPick);

    }

    public int nonAdjacentDP(int[] nums) {
        int n = nums.length;
        int []dp = new int[n];
        dp[0] = nums[0];
        for ( int i=1; i<n; i++){
            int pick = nums[i];
            if ( i >=2 ) pick += dp[i-2];
            int notPick = dp[i-1];
            dp[i] = Math.max(pick, notPick);
        }
        return dp[n-1];
    }
}
