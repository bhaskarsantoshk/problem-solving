package takeUForward.google;

import java.util.Arrays;

public class TheNumberOfWaysToMakeTheSum {
    public int numberOfWays(int n) {
        int countWays = 0;
        int MOD = (int) 10e9+7;
        for ( int countFour = 0; countFour <=2 ; countFour++){
            int rem = n - countFour*4;
            if ( rem < 0) continue;
            for ( int countSix = 0; countSix* 6 <= rem; countSix++){
                int remAfterSix = rem-countSix*6;

                for ( int countTwo = 0; countTwo* 2 <= remAfterSix; countTwo++){
                    int remAfterTwo = remAfterSix-countTwo*2;
                    countWays = (countWays+1)%MOD; // optional check : if ( remAfterTwo >= 0 )
                }
            }
        }
        return countWays;
    }

    static int MOD = (int) 10e9+7;
    public int numberOfWaysRec(int n) {
        int []coins = {1,2,4,6};
        return rec(n, 0, 0, coins);
    }

    private int rec(int rem, int index, int fourCount, int[] coins) {
         if ( rem == 0) return 1;
         if ( rem < 0 || index == coins.length ) return 0;
         long ways = 0;
         long notTake = rec(rem, index+1, fourCount, coins);
         long take = 0;
         int coin = coins[index];
         if ( coin == 4){
             if ( fourCount < 2 ) take = rec(rem-coin, index+1, fourCount-1, coins);
         } else {
             take = rec(rem-coin, index+1, fourCount, coins);
         }
         return (int)(take+notTake)%MOD;
    }

    public int numberOfWaysMemoized(int n) {
        int []coins = {1,2,4,6};
        int[][][] dp = new int[n+1][4][3];
        for ( int i=0; i<=n; i++){
            for ( int j=0; j<4; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return numberOfWaysMemoized(n, 0, 0, coins, dp);
    }

    private int numberOfWaysMemoized(int rem, int index, int fourCount, int[] coins, int[][][] dp) {
        if ( rem == 0) return 1;
        if ( rem < 0 || index == coins.length ) return 0;
        if ( dp[rem][index][fourCount] != -1 ) return dp[rem][index][fourCount];
        long notTake = numberOfWaysMemoized(rem, index+1, fourCount, coins, dp);
        long take = 0;
        int coin = coins[index];
        if ( coin == 4){
            if ( fourCount < 2 ) take = numberOfWaysMemoized(rem-coin, index, fourCount+1, coins, dp);
        } else {
            take = numberOfWaysMemoized(rem-coin, index, fourCount, coins, dp);
        }
        return dp[rem][index][fourCount] = (int)(take+notTake)%MOD;
    }
}
