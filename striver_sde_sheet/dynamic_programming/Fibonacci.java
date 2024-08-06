package striver_sde_sheet.dynamic_programming;

public class Fibonacci {
    int fib( int n){
        if ( n <= 1 ) return n;
        return fib(n-1)+fib(n-2);
    }

    // T : O(N) S: O(N) Recursion stack space
    int fibMemoized( int n, int[] dp){
        if ( n <= 1 ) return n;
        if ( dp[n] != -1) return dp[n];
        return dp[n] = fib(n-1)+fib(n-2);
    }

    // T : O(N) S: O(N) No Recursion stack space
    int fibTabular( int n){
        int[] dp = new int[n+1]; // ans = dp[n]
        dp[0] = 0; dp[1] = 1; //  if ( n <= 1 ) return n;
        // return dp[n] = fib(n-1)+fib(n-2);
        for ( int i=2; i<=n; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    int fibTabularConstantSpace( int n){
        if ( n <= 1) return n;
        int ans = 0;
        int prev2 = 0, prev = 1;
        // return dp[n] = fib(n-1)+fib(n-2);
        for ( int i=2; i<=n; i++){
            ans = prev+prev2;
            prev2 = prev;
            prev = ans;
        }
        return ans;
    }


}
