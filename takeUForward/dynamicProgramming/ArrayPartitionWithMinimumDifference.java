package takeUForward.dynamicProgramming;

public class ArrayPartitionWithMinimumDifference {
    public int minimumDifference(int[] nums) {
        int total = 0;
        for ( int num: nums) total+= num;
        Boolean memo[][] = new Boolean[nums.length][total+1];
        subSetSum(nums, total, nums.length-1, memo);
        int min = Integer.MAX_VALUE;
        for ( int i=1; i<=total; i++){
            if (memo[nums.length - 1][i] != null && memo[nums.length - 1][i]){
                int sum1 = i;
                int sum2 = total-i;
                min = Math.min( Math.abs(sum1-sum2), min);
            }
        }
        return min;
    }

    private boolean subSetSum( int[] nums, int target, int index, Boolean [][] memo){
        if ( target == 0) return true;
        if ( index < 0) return false;
        if ( memo[index][target] != null) return memo[index][target];
        if ( index == 0 ) return memo[index][target] = (target == nums[index]);
        boolean pick = false;
        if ( nums[index] <= target) pick = subSetSum(nums, target-nums[index], index-1, memo);
        boolean notPick = subSetSum(nums, target, index-1, memo);
        return memo[index][target] = pick | notPick;
    }

    public static int minSubsetSumDifference(int[] nums, int n) {
        int total = 0;
        for ( int num: nums) total+= num;
        boolean [][] dp = new boolean[n][total+1];
        for ( int i=0; i<n; i++){
            dp[i][0] = true;
        }
        if ( nums[0] <= total) dp[0][nums[0]] = true;
        for ( int i=1; i<nums.length; i++){
            for ( int target=1; target<= total; target++){
                boolean nonPick = dp[i-1][target];
                boolean pick = false;
                if ( nums[i] <= target ) pick = dp[i-1][target-nums[i]];
                dp[i][target] = pick | nonPick;
            }
        }
        int min = Integer.MAX_VALUE;
        for ( int i=1; i<=total; i++){
            if (dp[nums.length - 1][i]){
                int sum1 = i;
                int sum2 = total-i;
                min = Math.min( Math.abs(sum1-sum2), min);
            }
        }
        return min;
    }


}
