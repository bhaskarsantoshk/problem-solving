package takeUForward.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class MiningDiamonds {
    public static int maxCoins(int a[]) {
       List<Integer> list = new ArrayList<>();
       list.add(1);
       for ( int num: a) list.add(num);
       list.add(1);
       return f(0, a.length-1, list);
    }

    private static int f(int i, int j, List<Integer> a) {
        if ( i > j) return 0;
        int max = Integer.MIN_VALUE;
        for ( int index = i; index<=j; index++){
            int cost = a.get(i-1) * a.get(index)*a.get(j+1) + f(i, index-1, a) + f(index+1, j, a);
            max = Math.max(max, cost);
        }
        return max;
    }
}
