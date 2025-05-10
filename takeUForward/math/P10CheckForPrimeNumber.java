package takeUForward.math;

public class P10CheckForPrimeNumber {
    public boolean isPrime(int n) {
        if ( n < 2) return false;
        for ( int i=2; i*i<=n ; i++ ){
            if ( n % i == 0) return false;
        }
        return true;
    }
}
