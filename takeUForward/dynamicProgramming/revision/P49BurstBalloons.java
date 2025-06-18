package takeUForward.dynamicProgramming.revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P49BurstBalloons {
    public int maxCoins(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for(int num: nums) list.add(num);
        list.add(1);
        int n = nums.length;
        return f(1, n, list);
    }

    private int f(int i, int j, List<Integer> list) {
        if ( i > j) return 0;
        int max = -(int)1e9;
        for ( int index=i; index<=j; index++){
            int cost = list.get(i-1) * list.get(index)* list.get(j+1)
                    + f(i, index-1, list) + f(index+1, j, list);
            max = Math.max(max, cost);
        }
        return max;
    }

    public int maxCoinsMemo(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for(int num: nums) list.add(num);
        list.add(1);
        int n = nums.length;
        int [][] dp = new int[n+1][n+1];
        for ( int i=0; i<dp.length; i++) Arrays.fill(dp[i], -1);
        return f(1, n, list, dp);
    }

    private int f(int i, int j, List<Integer> list, int[][] dp) {
        if ( i > j) return 0;
        int max = -(int)1e9;
        if ( dp[i][j] != -1) return dp[i][j];
        for ( int index=i; index<=j; index++){
            int cost = list.get(i-1) * list.get(index)* list.get(j+1)
                    + f(i, index-1, list, dp) + f(index+1, j, list, dp);
            max = Math.max(max, cost);
        }
        return dp[i][j] = max;
    }

    public int maxCoinsTabular(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for(int num: nums) list.add(num);
        list.add(1);
        int n = nums.length;
        int [][] dp = new int[n+2][n+2];
        for ( int i=n; i>=1; i--){
            for ( int j=1; j<=n; j++){
                if ( i > j) continue;
                int max = -(int)1e9;
                for ( int index=i; index<=j; index++){
                    int cost = list.get(i-1) * list.get(index)* list.get(j+1)
                            + dp[i][index-1] + dp[index+1][j];
                    max = Math.max(max, cost);
                }
                 dp[i][j] = max;
            }
        }
        return dp[1][n];
    }
}
