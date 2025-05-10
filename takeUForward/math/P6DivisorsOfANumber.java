package takeUForward.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P6DivisorsOfANumber {
    public int[] divisors(int n) {
        List<Integer> list = new ArrayList<>();
        for ( int i=1; i*i<=n; i++){
            if ( n % i == 0){
                list.add(i);
                if ( i != n/i) list.add(n/i);
            }
        }
        Collections.sort(list);
        int[] arr = new int[list.size()];
        for ( int i=0; i<list.size(); i++) arr[i] = list.get(i);
        return arr;
    }
}
