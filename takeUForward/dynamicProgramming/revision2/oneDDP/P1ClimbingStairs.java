package takeUForward.dynamicProgramming.revision2.oneDDP;

import java.util.Arrays;

public class P1ClimbingStairs {
    public int climbStairs(int n) {
        return f(n);
    }

    private int f(int index) {
        if (index == 0) return 1;
        if ( index < 0) return 0;
        return f(index-1) + f(index-2);
    }

    public int climbStairsMemoized(int n) {
        int [] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return f(n, dp);
    }

    private int f(int index, int[] dp) {
        if ( index < 0) return 0;
        if (index == 0) return 1;
        if ( dp[index] != -1) return dp[index];
        return dp[index]= f(index-1, dp) + f(index-2, dp);
    }

    public int climbStairsTabular(int n) {
        int [] dp = new int[n+1];
        dp[0] =1 ;
        dp[1] =1;
        for ( int index=2; index<=n; index++){
            dp[index]= dp[index-1] + dp[index-2];
        }
        return dp[n];
    }

    public int climbStairsSpaceOptimized(int n) {
        int prev = 1;
        int prev2 = 1;
        for ( int index=1; index<=n; index++){
            int cur = prev + prev2;
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }
}
