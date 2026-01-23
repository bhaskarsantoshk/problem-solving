package takeUForward.recursion.revision4;

public class P17FibonacciNumber {
    public int fib(int n) {
       if ( n == 0 || n == 1) return 1;
       return fib(n-1)+fib(n-2);
    }
}
