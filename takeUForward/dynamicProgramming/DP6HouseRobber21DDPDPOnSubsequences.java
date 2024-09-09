package takeUForward.dynamicProgramming;

import java.util.Arrays;

public class DP6HouseRobber21DDPDPOnSubsequences {
    public static long houseRobber(int[] valueInHouse) {
        int n = valueInHouse.length;
        int [] list1 = new int[n-1];
        int [] list2 = new int[n-1];

        if ( n == 1 ) return valueInHouse[0];
        for ( int i=0; i<n-1; i++){
            list1[i] = valueInHouse[i];
        }
        for ( int i=0; i<n-1; i++){
            list2[i] = valueInHouse[i+1];
        }

        long ans1 = maxSumNonAdjacentElements(list1);
        long ans2 = maxSumNonAdjacentElements(list2);
        return Math.max( ans1, ans2);
    }

    private static long maxSumNonAdjacentElements(int[] nums) {
        return maxSumNonAdjacentElements(nums.length-1, nums);
    }

    private static long maxSumNonAdjacentElements(int index, int[] nums) {
        if ( index == 0) return nums[index];
        if ( index < 0) return 0;

        long pick = maxSumNonAdjacentElements(index-2, nums) + nums[index];
        long notPick = maxSumNonAdjacentElements(index-1, nums);
        return Math.max(pick, notPick);
    }


    private static long maxSumNonAdjacentElementsMemo(int[] nums) {
        long [] memo = new long[nums.length];
        Arrays.fill(memo, -1);
        return maxSumNonAdjacentElementsMemo(nums.length-1, nums, memo);
    }

    private static long maxSumNonAdjacentElementsMemo(int index, int[] nums, long[] memo) {
        if ( index == 0) return memo[index] = nums[index];
        if ( index < 0) return 0;
        if ( memo[index] != -1) return memo[index];

        long pick = maxSumNonAdjacentElementsMemo(index-2, nums, memo) + nums[index];
        long notPick = maxSumNonAdjacentElementsMemo(index-1, nums, memo);
        return memo[index] = Math.max(pick, notPick);
    }

    private static long maxSumNonAdjacentElementsTabular(int[] nums) {
        long [] dp = new long[nums.length];
        dp[0] = nums[0];
        for ( int index=1; index<nums.length; index++){
            long pick = nums[index];
            if ( index>=2) pick += dp[index-2] ;
            long notPick = dp[index-1];
            dp[index] = Math.max(pick, notPick);
        }
        return dp[nums.length-1];
    }
}
