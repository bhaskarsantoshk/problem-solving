package takeuForward.dynamicProgramming;


import java.util.Arrays;

// https://bit.ly/3t1Sjyx
public class CountWaysToReachTheNthStairs {
    public static long countDistinctWayToClimbStair(int nStairs) {
        if ( nStairs == 0 || nStairs == 1) return 1;
        return countDistinctWayToClimbStair(nStairs-1) + countDistinctWayToClimbStair(nStairs-2);
    }


    public static long countDistinctWayToClimbStairMemoized(int nStairs) {
        long [] memo = new long[nStairs+1];
        Arrays.fill(memo, -1);
        return countDistinctWayToClimbStairMemoized(nStairs, memo);
    }

    private static long countDistinctWayToClimbStairMemoized(int nStairs, long[] memo) {
        if ( nStairs == 0 || nStairs == 1) return 1;
        if ( nStairs < 0 ) return 0;
        if ( memo[nStairs] != -1) return memo[nStairs];
        return memo[nStairs] = (countDistinctWayToClimbStairMemoized(nStairs-1, memo) % 1000000007 + countDistinctWayToClimbStairMemoized(nStairs-2, memo) % 1000000007) % 1000000007;
    }

    public static long countDistinctWayToClimbStairTabular(int nStairs) {
        if ( nStairs < 2) return 1;
        int dp[] = new int[nStairs+1];
        dp[0] = 1;
        dp[1] = 1;
        for ( int i=2; i<=nStairs; i++){
            dp[i] = (dp[i-1] % 1000000007 + dp[i-2]%1000000007)%1000000007;
        }
        return dp[nStairs];
    }

    public static long countDistinctWayToClimbStairTabularSpaceOptimized(int nStairs) {
        if ( nStairs < 2) return 1;
        int prev, prev2, ans;
        prev = prev2 = ans = 1;
        for ( int i=2; i<=nStairs; i++){
            ans = (prev % 1000000007 + prev2%1000000007)%1000000007;
            prev2 = prev;
            prev = ans;
        }
        return ans;
    }
}
