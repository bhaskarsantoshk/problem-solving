package takeUForward.math;

import java.util.ArrayList;
import java.util.Arrays;

public class P1PrintAllPrimesTillN {
    public ArrayList<Integer> primeTillN(int n) {
        int[] prime = new int[n+1];
        for ( int i=2; i<=n; i++) prime[i] =1;
        for ( int i=2; i*i <= n; i++){
            if ( prime[i] == 1){
                for ( int j= i*i ; j<=n; j+=i){
                    prime[j] = 0;
                }
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for ( int i=2; i<=n; i++){
            if ( prime[i] == 1) res.add(i);
        }
        return res;
    }
}
