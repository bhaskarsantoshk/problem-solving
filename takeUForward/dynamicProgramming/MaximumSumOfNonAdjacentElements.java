package takeUForward.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumSumOfNonAdjacentElements {
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        return f(nums, nums.size()-1);

        // f(index) -> max sum from 0->index non adjacent nums
    }

    private static int f(ArrayList<Integer> nums, int index) {
        if ( index == 0) return nums.get(index);
        if ( index < 0) return 0;
        int pick = nums.get(index) + f(nums, index-2);
        int nonPick = f(nums, index-1);
        return Math.max( pick, nonPick);
    }

    public static int maximumNonAdjacentSumMemoized(ArrayList<Integer> nums) {
        int [] memo = new int[nums.size()];
        Arrays.fill(memo, -1);
        return maximumNonAdjacentSumMemoized(nums, nums.size()-1, memo);
    }

    private static int maximumNonAdjacentSumMemoized(ArrayList<Integer> nums, int index, int[] memo) {
        if ( index == 0) return nums.get(index);
        if ( index < 0) return 0;
        if ( memo[index] != -1) return memo[index];
        int pick = nums.get(index) + maximumNonAdjacentSumMemoized(nums, index-2, memo);
        int nonPick = maximumNonAdjacentSumMemoized(nums, index-1, memo);
        return memo[index] = Math.max( pick, nonPick);
    }


    public static int maximumNonAdjacentSumTabular(ArrayList<Integer> nums) {
        if (nums == null || nums.size() == 0) return 0;
        if (nums.size() == 1) return nums.get(0);
        int [] dp = new int[nums.size()];
        dp[0] = nums.get(0);
        for ( int i=1; i<nums.size(); i++){
            int pick = nums.get(i);
            if ( i>1) pick += dp[i-2];
            int nonPick = dp[i-1];
            dp[i] = Math.max(pick, nonPick);
        }
        return dp[nums.size()-1];
    }

    public static int maximumNonAdjacentSumTabularSpaceOptimized(ArrayList<Integer> nums) {
        if (nums == null || nums.size() == 0) return 0;
        if (nums.size() == 1) return nums.get(0);

        int prev = nums.get(0);
        int prev2=0;
        int ans=0;
        for ( int i=1; i<nums.size(); i++){
            int pick = nums.get(i);
            if ( i>1) pick += prev2;
            int nonPick = prev;
            ans = Math.max(pick, nonPick);
            prev2 = prev;
            prev = ans;
        }
        return ans;
    }
}
