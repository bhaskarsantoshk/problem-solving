package LeetCode;

import java.util.Arrays;

public class P509FibonacciNumber {

    public int fibo(int N) {
        int memo[] = new int[N+1];
        Arrays.fill(memo, -1);
        if( N == 0) return 0;
        if(N == 1 || N== 2){
            return 1;
        }
        memo[1] = 0;
        memo[2]=1;
        return fibo(N, memo);
    }

    private int fibo(int n, int[] memo) {
        if(memo[n] != -1){
            return memo[n];
        }
        return memo[n]= fibo(n-1, memo) + fibo(n-2, memo);
    }

    public int fib(int n){
        int first = 1;
        int second = 1;
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        int result = 0;
        for(int i=3; i<=n ; i++){
            result = first + second;
            first = second;
            second = first;
        }
        return result;
    }
}
