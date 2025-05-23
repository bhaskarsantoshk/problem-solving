package takeUForward.dynamicProgramming.revision;

import java.util.Arrays;

public class P19SubsetSumEqualsToTarget {
    public boolean isSubsetSum(int[] arr, int target) {
        return isSubsetSum( 0, 0, arr, arr.length, target);
    }

    private boolean isSubsetSum(int index, int sum, int[] arr, int length, int target) {
        if ( index == length) {
            if ( sum == target) return true;
        }
        boolean take =  isSubsetSum(index+1, sum+ arr[index], arr, length, target);
        if ( take) return true;
        boolean notTake = isSubsetSum(index+1, sum, arr, length, target);
        if ( notTake) return true;
        return false;
    }

    public boolean isSubsetSumMemoized(int[] arr, int target) {
        Boolean[][] dp = new Boolean[arr.length][target+1];
        return isSubsetSum( 0, 0, arr, arr.length, target, dp);
    }

    private boolean isSubsetSum(int index, int sum, int[] arr, int length, int target, Boolean[][] dp) {
        if ( sum > target ) return false;
        if ( index == length) {
            if ( sum == target) return true;
        }
        if ( dp[index][sum] != null) return dp[index][sum];
        boolean take =  isSubsetSum(index+1, sum+ arr[index], arr, length, target, dp);
        if ( take) return dp[index][sum] = true;
        boolean notTake = isSubsetSum(index+1, sum, arr, length, target, dp);
        if ( notTake) return dp[index][sum] = true;
        return dp[index][sum] = false;
    }
}
