package takeUForward.math;

public class P11CountOfPrimeNumbersTillN {
    public int primeUptoN(int n) {
        int[] primes = new int[n+1];
        for ( int i=2; i<=n; i++) primes[i] = 1;
        for ( int i=2; i*i<=n; i++){
            for ( int j= i*i; j<=n; j+=i){
                primes[j] = 0;
            }
        }
        int count = 0;
        for ( int i=0; i<=n; i++){
            if ( primes[i] == 1) count++;
        }
        return count;
    }
}
