package takeUForward.dynamicProgramming;

import java.util.Arrays;

public class MinimumPathSum {
    public static int minSumPath(int[][] grid) {
       return minSumPath(grid, grid.length-1, grid[0].length-1);
    }

    private static int minSumPath(int[][] grid, int i, int j) {
        if ( i == 0 && j == 0) return grid[0][0];
        if ( i < 0 && j <0) return Integer.MAX_VALUE;
        int up = minSumPath(grid, i-1, j) + grid[i][j];
        int left = minSumPath(grid, i, j-1) + grid[i][j];
        return Math.min( up, left);
    }

    public static int minSumPathMemoIzed(int[][] grid) {
        int [][] memo = new int[grid.length][grid[0].length];
        for ( int[] row: memo){
            Arrays.fill(row, -1);
        }
        return minSumPathMemoIzed(grid, grid.length-1, grid[0].length-1, memo);
    }

    private static int minSumPathMemoIzed(int[][] grid, int i, int j, int[][] memo) {
        if ( i == 0 && j == 0) return grid[0][0];
        if ( i < 0 || j <0) return (int) Math.pow(10, 9);;
        if ( memo[i][j] != -1) return memo[i][j];
        int up = minSumPathMemoIzed(grid, i-1, j, memo) + grid[i][j];
        int left = minSumPathMemoIzed(grid, i, j-1, memo) + grid[i][j];
        return memo[i][j]=Math.min( up, left);
    }

    public static int minSumPathTabular(int[][] grid) {
        int [][] dp = new int[grid.length][grid[0].length];
        for ( int i=0; i<grid.length; i++){
            for( int j=0; j<grid[0].length; j++){
                if ( i == 0 && j == 0) dp[0][0] = grid[0][0];
                else {
                    int up = (int) 1e9;
                    int left = (int) 1e9;
                    if ( i>0) up = dp[i-1][j] + grid[i][j];
                    if ( j>0) left = dp[i][j-1] + grid[i][j];
                    dp[i][j] = Math.min(up, left);
                }
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }


}
