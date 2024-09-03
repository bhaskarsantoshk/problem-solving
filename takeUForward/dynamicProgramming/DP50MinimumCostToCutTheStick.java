package takeUForward.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DP50MinimumCostToCutTheStick {
    public static int cost(int n, int c, int cuts[]) {
        List<Integer> cuttings = new ArrayList<>();
        cuttings.add(0);
        for ( int i=0; i<cuts.length; i++) cuttings.add(cuts[i]);
        cuttings.add(n);
        Arrays.sort(cuts);
        return f(1, c, cuttings);
    }

    private static int f(int index, int c, List<Integer> cuttings) {
        return 0;
    }

}
