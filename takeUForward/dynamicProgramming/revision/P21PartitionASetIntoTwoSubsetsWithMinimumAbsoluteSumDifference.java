package takeUForward.dynamicProgramming.revision;

public class P21PartitionASetIntoTwoSubsetsWithMinimumAbsoluteSumDifference {
    public int minDifference(int[] arr, int n) {
        int sum = 0;
        for ( int num: arr) sum+= num;
        boolean[][] dp = new boolean[n][sum+1];
        subsetSumTabulation(arr, sum, dp);
        int minDiff = Integer.MAX_VALUE;
        for ( int s1=0; s1<=sum/2; s1++){
            if ( dp[n-1][s1]) {
                int s2 = sum - s1;
                minDiff = Math.min(minDiff, Math.abs(s2 - s1));
            }
        }
        return minDiff;
    }

    public void subsetSumTabulation(int[] arr, int target, boolean[][] dp) {
        int n = arr.length;
        for ( int i=0; i <n; i++) dp[i][0] = true;
        if ( arr[0] <= target) dp[0][arr[0]] = true;
        for ( int index=1; index<n; index++){
            for ( int sum=1; sum<=target; sum++){
                boolean take = false;
                if(sum-arr[index] >=0) take = dp[index-1][sum-arr[index]];
                boolean notTake = dp[index-1][sum];
                dp[index][sum] = take || notTake;
            }
        }
    }
}
