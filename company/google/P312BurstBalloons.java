package company.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P312BurstBalloons {
    public int maxCoins(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for ( int num: nums) list.add(num);
        list.add(1);
        return maxCoins(list, 1, nums.length-1);
    }

    private int maxCoins(List<Integer> list, int i, int j) {
        if ( i > j) return 0;
        int max = Integer.MIN_VALUE;
        for (int index=i; index<=j; index++){
            int cost = list.get(i-1)* list.get(index)* list.get(j+1) + maxCoins(list, i, index-1)+ maxCoins(list,index+1, j);
            max = Math.max(max, cost);
        }
        return max;
    }


    public int maxCoinsMemo(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for ( int num: nums) list.add(num);
        list.add(1);
        int n = nums.length;
        int[][] memo = new int[n+1][n+1];
        for ( int i=0; i<memo.length; i++){
            Arrays.fill(memo[i], -1);
        }
        return maxCoins(list, 1, n, memo);
    }

    private int maxCoins(List<Integer> list, int i, int j, int[][] memo) {
        if ( i > j) return 0;
        if ( memo[i][j] != -1) return memo[i][j];
        int max = Integer.MIN_VALUE;
        for (int index=i; index<=j; index++){
            int cost = list.get(i-1)* list.get(index)* list.get(j+1) + maxCoins(list, i, index-1, memo)+ maxCoins(list,index+1, j, memo);
            max = Math.max(max, cost);
        }
        return memo[i][j] = max;
    }

    public int maxCoinsDP(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for ( int num: nums) list.add(num);
        list.add(1);
        int n = nums.length;
        int[][] dp = new int[n+2][n+2];

        for ( int i=n; i>=1; i--){
            for ( int j=1; j<=n; j++){
                if ( i > j) continue;
                int max = Integer.MIN_VALUE;
                for (int index=i; index<=j; index++){
                    int cost = list.get(i-1)* list.get(index)* list.get(j+1) + dp[i][index-1]+ dp[index+1][j];
                    max = Math.max(max, cost);
                }
                 dp[i][j] = max;
            }
        }

        return dp[1][n];
    }
}
