package takeUForward.dynamicProgramming.revision;

import java.util.Arrays;

public class P29CoinChangeII {
    public int count(int[] coins, int N, int amount) {
        Arrays.sort(coins);
        return f(coins, 0, amount);
    }

    private int f(int[] coins, int index, int amount) {
        if ( index == coins.length) {
            if ( amount == 0) return 1;
            return 0;
        }
        if ( amount < 0) return 0;
        if ( amount == 0) return 1;

        int notTake = f(coins, index+1, amount);
        int take = 0;
        if ( amount >= coins[index]) take = f(coins, index, amount-coins[index]);
        return take+notTake;
    }

    public int countMemoized(int[] coins, int N, int amount) {
        Arrays.sort(coins);
        int[][] memo = new int[N+1][amount+1];
        for ( int i=0; i<N; i++) Arrays.fill(memo[i], -1);
        return f(coins, 0, amount, memo);
    }

    int mod = (int)1e9+7;

    private int f(int[] coins, int index, int amount, int[][] memo) {
        if ( index == coins.length) {
            if ( amount == 0) return 1;
            return 0;
        }
        if ( amount < 0) return 0;
        if ( amount == 0) return 1;
        if ( memo[index][amount] != -1) return memo[index][amount];

        int notTake = f(coins, index+1, amount);
        int take = 0;
        if ( amount >= coins[index]) take = f(coins, index, amount-coins[index]);
        return memo[index][amount]=(take+notTake)%mod;
    }
}
