package books.DPABottomUpApproach.memoization;

public class Fibonacci {
    public int fib(int n){
        int memo[] = new int[n+1];
        return fib(n, memo);
    }

    private int fib(int n, int[] memo) {
        if (memo[n] != 0 ) return memo[n];
        if ( n == 1 || n == 1 ){
            memo[n] = 1;
        }
        else{
            memo[n] = fib(n-1) + fib(n-2);
        }
        return memo[n];
    }
}
