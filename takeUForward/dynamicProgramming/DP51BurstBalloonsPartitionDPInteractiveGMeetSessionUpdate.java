package takeUForward.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DP51BurstBalloonsPartitionDPInteractiveGMeetSessionUpdate {
    public static int maxCoins(int a[]) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for ( int i=0; i<a.length; i++) list.add(a[i]);
        list.add(1);

        return f(1, a.length, list);
    }

    private static int f(int i, int j, List<Integer> list) {
        if ( i > j) return 0;
        int min = Integer.MAX_VALUE;
        for ( int ind = i; ind<=j ; ind++){
            int cost = list.get(i-1) * list.get(ind) * list.get(j+1)
                    + f(i, ind-1, list) + f( ind+1, j, list);
            min = Math.min( min, cost);
        }
        return min;
    }

    public static int maxCoinsMemo(int a[]) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for ( int i=0; i<a.length; i++) list.add(a[i]);
        list.add(1);
        int n = a.length;
        int [][] memo = new int[n+1][n+1];
        for ( int i=0; i<n+1; i++) Arrays.fill(memo[i], -1);
        return fMemo(1, a.length, list, memo);
    }

    private static int fMemo(int i, int j, List<Integer> list, int[][] memo) {
        if ( i > j) return 0;
        if ( memo[i][j] != -1) return memo[i][j];
        int max = Integer.MIN_VALUE;
        for ( int ind = i; ind<=j ; ind++){
            int cost = list.get(i-1) * list.get(ind) * list.get(j+1)
                    + fMemo(i, ind-1, list, memo) + fMemo( ind+1, j, list, memo);
            max = Math.max( max, cost);
        }
        return memo[i][j]=max;
    }

    public static int maxCoinsTabular(int a[]) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for ( int i=0; i<a.length; i++) list.add(a[i]);
        list.add(1);
        int n = a.length;
        int [][] dp = new int[n+2][n+2];

        for ( int i=n; i>=1; i--){
            for ( int j=1; j<= n; j++){
                if ( i > j ) continue;
                int max = Integer.MIN_VALUE;
                for ( int ind = i; ind<=j ; ind++){
                    int cost = list.get(i-1) * list.get(ind) * list.get(j+1)
                            + dp[i][ind-1] + dp[ind+1][j];
                    max = Math.max( max, cost);
                }
                dp[i][j] = max;
            }
        }
        return dp[1][n];
    }
}
