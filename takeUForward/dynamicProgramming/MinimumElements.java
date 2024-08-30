package takeUForward.dynamicProgramming;

import java.util.Arrays;

public class MinimumElements {
    public static int minimumElements(int num[], int x) {
       return f(num.length-1, num, x);
    }

    private static int f(int index, int[] nums, int target) {
        if ( index == 0){
            return ( target % nums[0] == 0) ? target/nums[0] : (int)1e9;
        }
        int notPick = f(index-1, nums, target);
        int pick = (int) 1e9;
        if ( nums[index] <= target){
            pick = 1+ f(index, nums, target-nums[index]);
        }
        return Math.min(pick, notPick);
    }

    public static int minimumElementsMemo(int num[], int x) {
        int [][] memo = new int[num.length][x+1];
        for ( int [] row: memo) Arrays.fill(row, -1);
        int res= minimumElementsMemo(num.length-1, num, x, memo);
        if ( res == (int) 1e9) return -1;
        return res;
    }

    private static int minimumElementsMemo(int index, int[] nums, int target, int[][] memo) {
        if ( index == 0){
            return memo[index][target] = ( target % nums[0] == 0) ? target/nums[0] : (int)1e9;
        }
        if ( memo[index][target] != -1) return memo[index][target];
        int notPick = minimumElementsMemo(index-1, nums, target, memo);
        int pick = (int) 1e9;
        if ( nums[index] <= target){
            pick = 1+ minimumElementsMemo(index, nums, target-nums[index], memo);
        }
        return memo[index][target] = Math.min(pick, notPick);
    }

    public static int minimumElementsTabular(int nums[], int x) {
        int [][] dp = new int[nums.length][x+1];
        for ( int i=0; i<=x; i++){
            if ( i % nums[0] == 0) dp[0][i] = i/nums[0];
            else dp[0][i] = (int)1e9;
        }
        for ( int i=1; i<nums.length; i++){
            for ( int j=0; j<=x; j++){
                int notPick = dp[i-1][j];
                int pick = (int) 1e9;
                if ( nums[i] <= j){
                    pick = 1+ dp[i][j-nums[i]];
                }
                dp[i][j] = Math.min(pick, notPick);
            }
        }
        if ( dp[nums.length-1][x] == (int)1e9) return -1;
        return dp[nums.length-1][x];
    }
}
