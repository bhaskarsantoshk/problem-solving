package takeUForward.dynamicProgramming.revision3;

import java.util.Arrays;

public class P1ClimbingStairs {
    public int climbStairs(int n) {
        if ( n < 0) return 0;
        if ( n == 0) return 1;
        return climbStairs(n-1) + climbStairs(n-2);
    }

    public int climbStairsMemo(int n) {
       int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
       memo[0] = 1;
       return climbStairsMemo(n, memo);
    }

    private int climbStairsMemo(int n, int[] memo) {
        if ( n < 0) return 0;
        if (memo[n] != -1) return memo[n];
        return memo[n] = climbStairsMemo(n-1, memo) + climbStairsMemo(n-2, memo);
    }

    public int climbStairsDP(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for ( int i=2; i<=n; i++) {
            dp[i] = dp[i-1];
            if ( i > 1 ) dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public int climbStairsDPSpaceOptimized(int n) {
        int prev2 = 1;
        int prev = 1;
        for ( int i=2; i<=n; i++) {
            int cur = prev;
            if ( i > 1 )cur = prev+prev2;
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }
}
