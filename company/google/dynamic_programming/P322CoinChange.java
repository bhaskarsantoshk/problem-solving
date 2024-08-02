package company.google.dynamic_programming;

import java.util.Arrays;

public class P322CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[][] memo = new int[coins.length][amount+1];
        for ( int i=0; i<memo.length; i++){
            Arrays.fill(memo[i],-1 );
        }
        int ans = helper(coins, coins.length-1, amount, memo);
        if ( ans >= 1e9) return -1;
        return ans;
    }

    private int helper(int[] nums, int i, int target, int [][] memo) {
        if ( i == 0) {
            if ( target % nums[i] == 0) return target/nums[i];
            return (int) 1e9;
        }
        if ( memo[i][target] != -1) return memo[i][target];

        int notTake = 0 + helper(nums, i-1, target, memo);
        int take = (int) 1e9;
        if ( target >= nums[i]){
            take = 1+ helper(nums, i, target-nums[i], memo);
        }
        return memo[i][target] = Math.min( take, notTake);
    }
}
