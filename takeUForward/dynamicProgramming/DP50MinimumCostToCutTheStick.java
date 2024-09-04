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

    private static int f(int i, int j, List<Integer> cuts) {
        if ( i > j) return 0;
        int min = Integer.MAX_VALUE;
        for ( int ind = i ; ind<= j; ind++){
            int cost = cuts.get(j+1)-cuts.get(i-1) + f ( i, ind-1, cuts) + f(ind+1,j ,cuts);
            min = Math.min( min, cost);
        }
        return min;
    }

    public static int costMemo(int n, int c, int cuts[]) {
        List<Integer> cuttings = new ArrayList<>();
        Arrays.sort(cuts);
        cuttings.add(0);
        for ( int i=0; i<cuts.length; i++) cuttings.add(cuts[i]);
        cuttings.add(n);
        int m = cuts.length;
        int [][] memo = new int[m+1][m+1];
        for ( int[] row: memo) Arrays.fill(row, -1);
        return fMemo(1, c, cuttings, memo);
    }

    private static int fMemo(int i, int j, List<Integer> cuts, int[][] memo) {
        if ( i > j) return 0;
        if ( memo[i][j] != -1) return memo[i][j];
        int min = Integer.MAX_VALUE;
        for ( int ind = i ; ind<= j; ind++){
            int cost = cuts.get(j+1)-cuts.get(i-1)
                    + fMemo ( i, ind-1, cuts, memo) + fMemo(ind+1,j ,cuts, memo);
            min = Math.min( min, cost);
        }
        return memo[i][j]= min;
    }

    public static int costTabulation(int n, int c, int cuts[]) {
        List<Integer> cuttings = new ArrayList<>();
        Arrays.sort(cuts);
        cuttings.add(0);
        for ( int i=0; i<cuts.length; i++) cuttings.add(cuts[i]);
        cuttings.add(n);
        int [][] dp = new int[c+2][c+2];
        for ( int i = c ; i>= 1; i--){
            for ( int j=i; j<=c; j++){
                int min = Integer.MAX_VALUE;
                for ( int ind = i ; ind<= j; ind++){
                    int cost = cuttings.get(j+1)-cuttings.get(i-1)
                            + dp[i][ind-1] + dp[ind+1][j];
                    min = Math.min( min, cost);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][c];
    }

}
