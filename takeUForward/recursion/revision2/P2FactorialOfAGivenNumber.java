package takeUForward.recursion.revision2;

public class P2FactorialOfAGivenNumber {
    public long factorial(int n) {
        if ( n <= 1) return 1;
        return (long) (n * factorial( n-1));
    }
}
