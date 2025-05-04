package takeUForward.dynamicProgramming.revision;

import java.util.Arrays;

public class P1Fibonacci {
    int fib(int n){
        if(n<=1) return n;
        return fib(n-1)+fib(n-2);
    }

    int fibMemoIzed(int n){
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return fib(n, dp);
    }

    private int fib(int n, int[] dp) {
        if ( n <= 1) return n;
        if ( dp[n] != -1) return dp[n];
        dp[n] = fib(n-1, dp) + fib(n-2, dp);
        return dp[n];
    }

    private int fibTabulation(int n ) {
        // initialization
        int[] dp = new int[n+1];

        // base case
        dp[0] = 0;
        dp[1] = 1;

        // recurrence
        for ( int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    private int fibTabulationSpaceOptimized(int n ) {

        // base case
        int prev2 = 0;
        int prev = 1;

        // recurrence
        for ( int i=2; i<=n; i++){
            int cur = prev + prev2;
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }
}
