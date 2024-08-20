package company.google;

import java.util.Arrays;

public class P416PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        long sum =0;
        for ( int i=0; i<nums.length; i++){
            sum += nums[i];
        }
        if ( sum % 2 != 0) return false;
        return isSubSetSumPossible( nums, (int)(sum/2));
    }

    private boolean isSubSetSumPossible(int[] nums, int k) {
        Boolean [][] memo = new Boolean[nums.length][k+1];
        return isSubSetSumPossible(nums, nums.length-1, k, memo);
    }

    private boolean isSubSetSumPossible(int[] nums, int index, int sum, Boolean[][] memo) {
        if ( sum == 0) return true;
        if ( index < 0 ) return false;
        if (memo[index][sum] != null) return memo[index][sum];
        if ( nums[index] <= sum ){
            boolean pick = isSubSetSumPossible(nums, index-1, sum-nums[index], memo);
            if ( pick) return memo[index][sum]= true;
        }
        boolean notPick = isSubSetSumPossible(nums, index-1, sum, memo);
        if ( notPick) return memo[index][sum]= true;
        return memo[index][sum]= false;
    }
}
