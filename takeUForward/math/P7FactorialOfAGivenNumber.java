package takeUForward.math;

public class P7FactorialOfAGivenNumber {
    public int factorial(int n) {
        if ( n == 1 || n == 0) return 1;
        return factorial(n-1)*n;
    }

    public int factorialIterative(int n) {
       int fact = 1;
       for ( int i=2; i<=n; i++){
           fact *= i;
       }
       return fact;
    }
}
