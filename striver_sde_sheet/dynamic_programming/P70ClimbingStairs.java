package striver_sde_sheet.dynamic_programming;

import java.util.Arrays;

public class P70ClimbingStairs {
    public int climbStairs(int n) {
        if ( n == 0) return 1;
        if ( n == 1 ) return 1;
        return climbStairs(n-1) + climbStairs(n-2);
    }

    public int climbStairsMemoized(int n) {
        int memo[] = new int[n+1];
        Arrays.fill(memo, -1);
        return climbStairsMemoized(n, memo);
    }

    private int climbStairsMemoized(int n, int[] memo) {
        if ( n == 0 || n == 1) return 1;
        if ( memo[n] != -1) return memo[n];
        return memo[n] = climbStairsMemoized(n-1, memo) + climbStairsMemoized(n-2, memo);
    }

    private int climbStairsTabular(int n) {
        int dp[] = new int[n+1];
        dp[0] =  dp[1] = 1;
        for ( int i=2; i<=n ;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    private int climbStairsConstantSpace(int n) {
        if ( n == 0 || n == 1) return 1;
        int ans, prev, prev2;
        ans = 0;
        prev = prev2= 1;
        for ( int i=2; i<=n ;i++){
            ans = prev + prev2 ;
            prev2 = prev;
            prev = ans;
        }
        return ans;
    }
}

