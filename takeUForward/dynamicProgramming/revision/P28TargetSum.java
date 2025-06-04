package takeUForward.dynamicProgramming.revision;

public class P28TargetSum {
    int mod = (int)1e9+7;
    public int targetSum(int n, int diff, int[] arr) {
        int totalSum = 0;
        for ( int num: arr) totalSum+= num;
        if ( diff > totalSum) return 0;
        if ( (totalSum-diff) % 2 == 1) return 0;
        int target = (totalSum-diff) / 2;
        int [][] dp = new int[n][target+1];
        if ( arr[0] == 0) dp[0][0] = 2;
        else dp[0][0] = 1;
        if ( arr[0] != 0 && arr[0] <= target) dp[0][arr[0]] =1;
        for ( int i=1; i<n; i++){
            for ( int sum=0; sum<=target; sum++){
                int notTake = dp[i-1][sum];
                int take = 0;
                if ( sum-arr[i] >= 0) take = dp[i-1][sum-arr[i]];
                int val =  (take+notTake)%mod;
                dp[i][sum] = val;
            }
        }
        return dp[n-1][target];
    }
}
