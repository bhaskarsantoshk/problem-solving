package takeUForward.dynamicProgramming.revision;

import java.util.Arrays;

public class P22CountSubsetsWithSumK {
    int mod = (int)1e9+7;
    public int perfectSum(int[] arr, int K) {
        return f(arr.length-1, K, arr);
    }

    private int f(int index, int target, int[] arr) {
        if ( index == 0){
            if ( target == 0) return 1;
            return 0;
        }
        if ( target < 0) return 0;
        int take = f(index-1, target-arr[index], arr);
        int notTake = f(index-1, target, arr);
        return take+ notTake;
    }

    public int perfectSumMemoized(int[] arr, int K) {
        int n = arr.length;
        Integer [][] dp = new Integer[n][K+1];
        return countSubsetSum(arr.length-1, K, arr, dp);
    }

    private int countSubsetSum(int index, int target, int[] arr, Integer[][] dp) {
        if ( index == 0){
            if ( target == 0 && arr[index] == 0) return 2;
            if ( target == 0 || arr[index] == target) return 1;
            return 0;
        }

        if ( dp[index][target] != null) return dp[index][target];
        int notTake = countSubsetSum(index-1, target, arr, dp);
        int take = 0;
        if ( target - arr[index] >=0 ) take = countSubsetSum(index-1, target-arr[index], arr, dp);

        return dp[index][target] = (take+ notTake)%mod;
    }


    public int perfectSumTabular(int[] arr, int K) {
        int n = arr.length;
        int [][] dp = new int[n][K+1];
        for ( int i=0; i<n; i++) dp[i][0] = 1;
        if ( arr[0] <= K) dp[0][arr[0]] = 1;
        for ( int index = 1; index<n; index++){
            for ( int target =1; target<=K; target++){
                int notTake = dp[index-1][target];
                int take = 0;
                if ( target - arr[index] >=0 ) take = dp[index-1][target-arr[index]];
                dp[index][target] = (take+notTake)%mod;
            }
        }
        return dp[n-1][K];
    }

    public int perfectSumSpaceOptimization(int[] arr, int K) {
        int n = arr.length;
        int [] prev = new int[K+1];
        for ( int i=0; i<n; i++) prev[0] = 1;
        if ( arr[0] <= K) prev[arr[0]] = 1;
        for ( int index = 1; index<n; index++){
            int [] cur = new int[K+1];
            cur[0]=1;
            for ( int target =1; target<=K; target++){
                int notTake = prev[target];
                int take = 0;
                if ( target - arr[index] >=0 ) take = prev[target-arr[index]];
                cur[target] = (take+notTake)%mod;
            }
            prev = cur;
        }
        return prev[K];
    }
}
