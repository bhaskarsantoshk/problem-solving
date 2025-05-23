package takeUForward.dynamicProgramming.revision;

import java.util.Arrays;

public class P19SubsetSumEqualsToTarget {
    public boolean isSubsetSum(int[] arr, int target) {
        return f(arr.length-1, target, arr);
    }

    private boolean f(int index, int target, int[] arr) {
        if ( target == 0) return true;
        if ( index == 0) return arr[index] == target;
        boolean take = f(index-1, target-arr[index], arr);
        if ( take) return true;
        return f(index+1, target, arr);
    }

    public boolean isSubsetSumMemoized(int[] arr, int target) {
        Boolean[][] dp = new Boolean[arr.length][target+1];
        return f(arr.length-1, target, arr);
    }

    private boolean f(int index, int target, int[] arr, Boolean[][] dp) {
        if ( target == 0) return true;
        if ( target < 0) return false;
        if ( index == 0) return arr[index] == target;
        if ( dp[index][target] != null) return dp[index][target];
        boolean take = f(index-1, target-arr[index], arr, dp);
        if ( take) return dp[index][target] = true;
        boolean notTake = f(index-1, target, arr, dp);
        return notTake;
    }

    public boolean isSubsetSumTabulation(int[] arr, int target) {
        int n = arr.length;
        boolean[][] dp = new boolean[arr.length][target+1];
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
        return dp[n-1][target];
    }

    public boolean isSubsetSumSpaceOptimization(int[] arr, int target) {
        int n = arr.length;
        boolean[] prev = new boolean[target+1];
        prev[0] = true;
        if ( arr[0] <= target) prev[arr[0]] = true;
        for ( int index=1; index<n; index++){
            boolean[] cur = new boolean[target+1];
            cur[0] = true;
            for ( int sum=1; sum<=target; sum++){
                boolean take = false;
                if(sum-arr[index] >=0) take = prev[sum-arr[index]];
                boolean notTake = prev[sum];
                cur[sum] = take || notTake;
            }
            prev = cur;
        }
        return prev[target];
    }
}
