package takeUForward.dynamicProgramming;

import java.util.Arrays;

public class SubsetSumEqualToK {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        return f(n-1, k, arr);
    }

    private static boolean f(int index, int target, int[] arr){
        if ( target == 0) return true;
        if ( index == 0) return arr[0] == target;
        boolean notPick = f(index-1, target, arr);
        if (notPick) return true;
        boolean pick = false;
        if ( target >= arr[index]  )  pick = f(index-1, target-arr[index], arr);
        if (pick) return true;
        return false;
    }

    public static boolean subsetSumToKMemoized(int n, int k, int arr[]){
        Boolean memo[][] = new Boolean[n][k+1];
        return subsetSumToKMemoized(n-1, k, arr, memo);
    }

    private static boolean subsetSumToKMemoized(int index, int target, int[] arr, Boolean[][] memo){
        if (target == 0) return true;
        if (index == 0) return arr[0] == target;
        if (memo[index][target] != null) return memo[index][target];

        boolean notPick = subsetSumToKMemoized(index-1, target, arr, memo);
        if (notPick) return memo[index][target] = true;

        boolean pick = false;
        if (target >= arr[index]) {
            pick = subsetSumToKMemoized(index-1, target-arr[index], arr, memo);
        }

        return memo[index][target] = pick;
    }

    public static boolean subsetSumToKTabular(int n, int k, int arr[]){
        boolean [][] dp = new boolean[n][k+1];
        for ( int i=0; i<n; i++){
            dp[i][0] = true;
        }
        if (arr[0] <= k) dp[0][arr[0]] = true;
        for ( int i=1; i<n; i++){
            for ( int target=1; target<=k; target++){
                boolean notPick = dp[i-1][target];
                boolean pick = false;
                if (target >= arr[i]) {
                    pick = dp[i-1][target-arr[i]];
                }
                dp[i][target] = pick | notPick;
            }
        }
        return dp[n-1][k];
    }
}
