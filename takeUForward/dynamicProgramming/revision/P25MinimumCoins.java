package takeUForward.dynamicProgramming.revision;

import java.util.Arrays;

public class P25MinimumCoins {
    public int MinimumCoins(int[] coins, int amount) {
        return f(coins.length-1, amount, coins );
    }

    private int f(int index, int amount, int[] coins) {
        if ( index == 0){
            if ( amount == 0) return 0;
            if ( amount % coins[index] == 0) return amount/coins[index];
            else return (int)1e9;
        }
        int notTake = f( index-1, amount, coins);
        int take = (int)1e9;
        if ( amount - coins[index] >=0) take = 1+ f(index-1, amount-coins[index], coins);
        return Math.min(take, notTake);
    }

    public int MinimumCoinsMemoized(int[] coins, int amount) {
        int n = coins.length;
        int [][] dp = new int[n][amount+1];
        for ( int i=0; i<dp.length; i++) Arrays.fill(dp[i], -1);
        return f(coins.length-1, amount, coins,  dp);
    }

    private int f(int index, int amount, int[] coins, int[][] dp) {
        if ( index == 0){
            if ( amount == 0) return 0;
            if ( amount % coins[index] == 0) return amount/coins[index];
            else return (int)1e9;
        }
        if ( dp[index][amount] != -1) return dp[index][amount];
        int notTake = f( index-1, amount, coins);
        int take = (int)1e9;
        if ( amount - coins[index] >=0) take = 1+ f(index-1, amount-coins[index], coins);
        return dp[index][amount] = Math.min(take, notTake);
    }
}
