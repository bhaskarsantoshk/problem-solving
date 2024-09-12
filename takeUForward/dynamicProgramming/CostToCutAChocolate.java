package takeUForward.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CostToCutAChocolate {
    public static int cost(int n, int c, int cuts[]) {
        Arrays.sort(cuts);
        List<Integer> cuttings = new ArrayList<>();
        cuttings.add(0);
        for ( int cut: cuts) cuttings.add(cut);
        cuttings.add(n);
        return f(1, c, cuttings);
    }

    private static int f(int i, int j, List<Integer> cuttings) {
        if ( i > j) return 0;
        int min = Integer.MAX_VALUE;
        for ( int ind = i; ind<=j; ind++){
            int cost = cuttings.get(j+1)-cuttings.get(i-1) +
                    f( i, ind-1, cuttings)+ f(ind+1, j, cuttings);
            min = Math.min( min, cost);
        }
        return min;
    }
}
