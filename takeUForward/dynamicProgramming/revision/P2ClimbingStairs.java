package takeUForward.dynamicProgramming.revision;

import java.util.Arrays;

public class P2ClimbingStairs {
    public int climbStairs(int n) {
        if ( n <= 1) return n;
        return climbStairs(n-1) + climbStairs(n-2);
    }

    public int climbStairsMemoized(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return climbStairs(n, dp);
    }

    private int climbStairs(int n, int[] dp) {
        if ( n <= 1) return 1;
        if ( dp[n] != -1) return dp[n];
        dp[n] = climbStairs(n-1) +climbStairs(n-2);
        return dp[n];
    }

    public int climbStairsTabular(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for ( int i=2; i<=n; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public int climbStairsSpaceOptimized(int n) {

        int prev2 = 1;
        int prev = 1;
        for ( int i=2; i<=n; i++){
            int cur = prev+prev2;
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }
}
