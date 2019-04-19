package LeetCode;

import java.util.Arrays;

public class P70ClimbingStairs {
    public int climbStairs(int n) {
        int memo[] = new int[n+1];
        Arrays.fill(memo, -1);
        return countWays(n, memo);
    }

    private int countWays(int n, int[] memo) {
        if(memo[n] != -1){
            return memo[n];
        }
        if(n==1){
            memo[n] =1;
            return 1;
        }
        if(n == 2){
            memo[n]= 2;
            return 2;
        }
        memo[n]= countWays(n-1, memo) + countWays(n-2, memo);
        return memo[n];
    }

    public int climbingStairsDP(int n){
        if(n<=2){
            return n;
        }
        int dp[] = new int[n+1];
        dp[1]= 1;
        dp[2] = 2;
        for(int i=3;i<=n ;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public int climbStairsDP2(int n){
        if(n<=2){
            return n;
        }
        int first = 1;
        int second = 2;
        int result = 0;
        for(int i=3; i<=n ;i++){
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }

}
