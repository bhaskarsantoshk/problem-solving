package takeUForward.dynamicProgramming;

import java.util.Arrays;

public class WaysToMakeCoinChange {
    public static long countWaysToMakeChange(int denominations[], int value){
      return countWaysToMakeChange(denominations.length-1, denominations, value);
    }

    private static long countWaysToMakeChange(int index, int[] nums, int target) {
        if ( index == 0){
            if ( nums[index] == 0 && target == 0 ) return 2; // you can both take and not take 0.
            else if ( target == 0 || target % nums[index] == 0) return 1;
            else return 0;
        }
        long notTake = countWaysToMakeChange(index-1, nums, target);
        long take = 0;
        if ( nums[index] <= target) take = countWaysToMakeChange(index, nums, target-nums[index]);
        return take+notTake;
    }

    public static long countWaysToMakeChangeMemo(int denominations[], int value){
        long[][] memo = new long[denominations.length][value+1];
        for ( long [] row: memo) Arrays.fill(row, -1);
        return countWaysToMakeChangeMemo(denominations.length-1, denominations, value, memo);
    }

    private static long countWaysToMakeChangeMemo(int index, int[] nums, int target, long [][] memo) {
        if ( index == 0){
            if ( nums[index] == 0 && target == 0 ) return 2; // you can both take and not take 0.
            else if ( target == 0 || target % nums[index] == 0) return 1;
            else return 0;
        }
        if ( memo[index][target] != -1) return memo[index][target];
        long notTake = countWaysToMakeChangeMemo(index-1, nums, target, memo);
        long take = 0;
        if ( nums[index] <= target) take = countWaysToMakeChangeMemo(index, nums, target-nums[index], memo);
        return memo[index][target] = take+notTake;
    }
}
