package takeUForward.dynamicProgramming;

import java.util.Arrays;

public class Triangle {
    public static int minimumPathSum(int[][] triangle, int n) {
       // if we start from last row - we need 4 recurrences , so we start from 0,0 and reach one of the cell in last row

        return minimumPathSum(triangle, n, 0, 0);
    }

    private static int minimumPathSum(int[][] triangle, int n, int i, int j) {
        if ( i == n-1) return triangle[i][j];
        int down = minimumPathSum(triangle, n, i+1 , j) + triangle[i][j];
        int diag = minimumPathSum(triangle, n, i+1, j+1) + triangle[i][j];

        return Math.min(down, diag);
    }

    public static int minimumPathSumMemoized(int[][] triangle, int n) {
        // if we start from last row - we need 4 recurrences , so we start from 0,0 and reach one of the cell in last row
        int [][] memo = new int[n][triangle[n-1].length];
        for ( int[] row: memo){
            Arrays.fill(row, -1);
        }
        return minimumPathSumMemoized(triangle, n, 0, 0, memo);
    }

    private static int minimumPathSumMemoized(int[][] triangle, int n, int i, int j, int[][] memo) {
        if ( i == n-1) return triangle[i][j];
        if ( memo[i][j] != -1)return memo[i][j];
        int down = minimumPathSumMemoized(triangle, n, i+1 , j, memo) + triangle[i][j];
        int diag = minimumPathSumMemoized(triangle, n, i+1, j+1, memo) + triangle[i][j];

        return  memo[i][j] = Math.min(down, diag);
    }

    public static int minimumPathSumTabular(int[][] triangle, int n) {
        // if we start from last row - we need 4 recurrences , so we start from 0,0 and reach one of the cell in last row
        int [][] dp = new int[n][triangle[n-1].length];
        for ( int j=0; j<n; j++){
            dp[n-1][j] = triangle[n-1][j];
        }
        for ( int i=n-2; i>=0; i--){
            for ( int j=i; j>=0; j--){
                int down = triangle[i][j] + dp[i+1][j];
                int diag = triangle[i][j] + dp[i+1][j+1];
                dp[i][j] = Math.min(down, diag);
            }
        }
        return dp[0][0];
    }
}
