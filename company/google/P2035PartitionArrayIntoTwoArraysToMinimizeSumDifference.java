package company.google;

import javax.xml.stream.events.StartDocument;

public class P2035PartitionArrayIntoTwoArraysToMinimizeSumDifference {
    public int minimumDifference(int[] nums) {
        int total = 0;
        for ( int num: nums) total+= num;
        // subsetSums(nums.length-1, nums, total);
        int n = nums.length;
//        Boolean[][] memo = new Boolean[n][total+1];
//        subsetSumsMemo( n-1, nums, total, memo);

        boolean[][] dp = new boolean[n-1][total+1];
        for ( int i=0; i<n; i++){
            dp[i][0] = true;
        }
        if ( nums[0] <= total) dp[0][nums[0]] = true;

        for ( int ind=1; ind<n; ind++){
            for ( int target=1; target<=total; target++){
                boolean pick = false;
                if ( target >= nums[ind]){
                    pick = dp[ind-1][target-nums[ind]];
                }
                boolean notPick = dp[ind-1][target];
                dp[ind][target] = pick || notPick;
            }
        }

        int minDiff = Integer.MAX_VALUE;
        for ( int i=0; i<=total; i++){
            if (dp[n - 1][i]){
                int sum1 = i;
                int sum2 = total-i;
                minDiff = Math.min(minDiff, Math.abs(sum1-sum2));
            }
        }
        return minDiff;
    }



    private boolean subsetSumsMemo(int index, int[] nums, int target, Boolean[][] memo) {
        if ( target == 0) return memo[index][target] = true;
        if ( index == 0) return memo[index][target] = (target == nums[0]);
        if ( memo[index][target] != null ) return memo[index][target];

        boolean pick = false;
        if ( target >= nums[index]){
            pick = subsetSums(index-1, nums, target-nums[index]);
        }
        boolean notPick = subsetSums(index-1, nums, target);
        return memo[index][target] = pick || notPick;
    }

    private boolean subsetSums(int index, int[] nums, int target) {
        if ( target == 0) return true;
        if ( index == 0) return target == nums[0];

        boolean pick = false;
        if ( target >= nums[index]){
            pick = subsetSums(index-1, nums, target-nums[index]);
        }
        boolean notPick = subsetSums(index-1, nums, target);
        return pick || notPick;
    }
}
