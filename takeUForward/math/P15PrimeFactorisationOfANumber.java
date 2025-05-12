package takeUForward.math;

import java.util.ArrayList;
import java.util.List;

public class P15PrimeFactorisationOfANumber {
    public List<List<Integer>> primeFactors(int[] queries) {
        List<List<Integer>> res = new ArrayList<>();
        for ( int num: queries){
            List<Integer> list = getPrimeFactors(num);
            res.add(new ArrayList<>(list));
        }
        return res;
    }

    private List<Integer> getPrimeFactors(int num) {
        List<Integer> res = new ArrayList<>();
        for ( int i=2; i*i <= num; i++){
            if ( num % i == 0){
                while ( num % i == 0){
                    res.add(i);
                    num /= i;
                }
            }
        }
        if ( num > 1) res.add(num);
        return res;
    }

    public List<List<Integer>> primeFactorsOptimized(int[] queries) {
        int[] spf = new int[100000];
        for ( int i=1; i<100000; i++){
            spf[i] = i;
        }
        for ( int i=2; i*i < 100000; i++){
            if ( spf[i] == i){
                for ( int j= i*i ; j<100000; j+=i){
                    if ( spf[j]==j) spf[j] = i;
                }
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for ( int num: queries){
            List<Integer> list = new ArrayList<>();
            while ( num > 1){
                list.add(spf[num]);
                num /= spf[num];
            }
            res.add(list);
        }
        return res;
    }
}
