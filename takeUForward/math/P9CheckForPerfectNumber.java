package takeUForward.math;

public class P9CheckForPerfectNumber {
    public boolean isPerfect(int n) {
        int sumOfDivisors = 1;
        for ( int i=2; i*i <= n; i++){
            if ( n % i == 0){
                sumOfDivisors+=i;
                if ( i != n/i) sumOfDivisors+= n/i;
            }

        }
        return sumOfDivisors == n;
    }
}
