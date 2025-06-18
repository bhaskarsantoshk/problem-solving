package takeUForward.dynamicProgramming.revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P48MinimumCostToCutTheStick {
    public int minCost(int n, List<Integer> cuttings) {
        List<Integer> cuts = new ArrayList<>();
        cuts.add(0);
        for ( Integer num: cuttings) cuts.add(num);
        cuts.add(n);
        Collections.sort(cuts);
        return f(1, cuttings.size(), cuts);
    }

    private int f(int i, int j, List<Integer> cuts) {
        if ( i > j) return 0;
        int min = (int) 1e9;
        for ( int k=i; k<=j; k++){
            int cost = cuts.get(j+1)-cuts.get(i-1)+ f(i, k-1, cuts) + f(k+1, j, cuts);
            min = Math.min(cost, min);
        }
        return min;
    }

    public int minCostMemoized(int n, List<Integer> cuttings) {
        List<Integer> cuts = new ArrayList<>();
        cuts.add(0);
        for ( Integer num: cuttings) cuts.add(num);
        cuts.add(n);
        Collections.sort(cuts);
        int x = cuttings.size();
        int [][] dp = new int[x+1][x+1];
        for ( int i=0; i<=x; i++) Arrays.fill(dp[i], -1);
        return f(1, cuttings.size(), cuts, dp);
    }

    private int f(int i, int j, List<Integer> cuts, int[][] dp) {
        if ( i > j) return 0;
        if ( dp[i][j] != -1) return dp[i][j];
        int min = (int) 1e9;
        for ( int k=i; k<=j; k++){
            int cost = cuts.get(j+1)-cuts.get(i-1)+ f(i, k-1, cuts, dp) + f(k+1, j, cuts, dp);
            min = Math.min(cost, min);
        }
        return dp[i][j]=min;
    }

    public int minCostTabular(int n, List<Integer> cuts) {
        List<Integer> cuttings = new ArrayList<>();
        cuttings.add(0);
        for ( Integer num: cuts) cuttings.add(num);
        cuttings.add(n);
        Collections.sort(cuttings);
        int c = cuttings.size()-2;

        int [][] dp = new int[c+2][c+2];
        for ( int i=c; i>=1; i--){
            for ( int j=1; j<=c; j++){
                if ( i > j) continue;
                int min = (int) 1e9;
                for ( int k=i; k<=j; k++){
                    int cost = cuttings.get(j+1)-cuttings.get(i-1)+ dp[i][k-1] + dp[k+1][j];
                    min = Math.min(cost, min);
                }
                dp[i][j]=min;
            }
        }
        return dp[1][c];
    }
}
