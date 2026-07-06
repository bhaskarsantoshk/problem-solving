package company.microsoft;

import java.util.ArrayList;
import java.util.List;

public class MaxScoreWithPrimeJumps {
    public int maxGameScore(List<Integer> cells){
        List<Integer> primes = getPrimesEndingIn3(cells.size());
        return f(0, cells, primes, cells.size());
    }

    private int f(int i, List<Integer> cells, List<Integer> primes, int n) {
        if ( i >= cells.size()) return Integer.MIN_VALUE;
        if ( i == cells.size()-1) return cells.get(i);
        int next = f(i+1, cells, primes, n);
        int ans = Integer.MIN_VALUE;
        if ( next != Integer.MIN_VALUE) ans = Math.max(ans, next+ cells.get(i));
        for (int prime: primes){
            if ( i+prime > n ) break;
            next = f( i+prime, cells, primes, cells.size());
            if (next!= Integer.MIN_VALUE)  ans = Math.max(ans, next+ cells.get(i));
        }
        return ans;
    }

    private List<Integer> getPrimesEndingIn3(int n) {
        List<Integer> list = new ArrayList<>();
        for ( int i=2; i<=n; i++){
            if ( i%10 == 3 && isPrime(i) ) list.add(i);
        }
        return list;
    }

    private boolean isPrime(int num) {
        if ( num < 2 ) return false;
        if ( num == 2) return true;
        if ( num % 2 == 0) return false;
        for ( int i=3; i<= num/i; i++){
            if ( num % i == 0) return false;
        }
        return true;
    }
}
