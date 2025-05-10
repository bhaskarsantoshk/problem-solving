package takeUForward.math;

import java.util.ArrayList;

public class P3CountPrimesInRangeLToR {
    public ArrayList<Integer> primesInRange(ArrayList<int[]> queries) {
        int n = 100001;
        int[] primes = new int[n];
        for ( int i=2; i<n; i++) primes[i] = 1;
        sieveOfEratosthenes(primes); // N log log N
        int cumulative[]= new int[n];
        for ( int i=1; i<n; i++){
            cumulative[i] = cumulative[i-1]+primes[i];
        }

        ArrayList<Integer> res = new ArrayList<>();
        for ( int[] query: queries){
            int l = query[0];
            int r = query[1];
            if ( l == 0) res.add(cumulative[r]);
            else res.add(cumulative[r]-cumulative[l-1]);
        }
        return res;
    }

    private void sieveOfEratosthenes(int[] primes) {
        for ( int i=2; i*i<primes.length; i++){
            for ( int j= i*i; j<primes.length; j+=i){
                primes[j] = 0;
            }
        }
    }
}
