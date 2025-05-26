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

    public int MinimumCoinsTabular(int[] coins, int amount) {
        int n = coins.length;
        int [][] dp = new int[n][amount+1];
        dp[0][0] = 0;
        for ( int a=0; a<=amount; a++){
            if ( a % coins[0] == 0) dp[0][a] = a/coins[0];
            else dp[0][a] = (int)1e9;
        }
        for ( int i=1; i<n; i++){
            for ( int a=1; a<=amount; a++){
                int notTaken = dp[i-1][a];
                int take = (int)1e9;
                if ( a- coins[i] >=0) take = 1+dp[i][a-coins[i]];
                dp[i][a] = Math.min(take, notTaken);
            }
        }
        return dp[n-1][amount] < (int)1e9 ? dp[n-1][amount]:-1;
    }

    public int MinimumCoinsSpaceOptimization(int[] coins, int amount) {
        int n = coins.length;
        int [] prev = new int[amount+1];
        int[] cur = new int[amount+1];
        prev[0] = 0;
        for ( int a=0; a<=amount; a++){
            if ( a % coins[0] == 0) {
                prev[a] = a/coins[0];
                cur[a] = a/coins[0];
            }
            else {
                prev[a] =cur[a]= (int)1e9;
            }
        }
        for ( int i=1; i<n; i++){
            for ( int a=1; a<=amount; a++){
                int notTaken = prev[a];
                int take = (int)1e9;
                if ( a- coins[i] >=0) take = 1+cur[a-coins[i]];
                cur[a] = Math.min(take, notTaken);
            }
            prev = cur;
        }
        return prev[amount] < (int)1e9 ? prev[amount]:-1;
    }
}
