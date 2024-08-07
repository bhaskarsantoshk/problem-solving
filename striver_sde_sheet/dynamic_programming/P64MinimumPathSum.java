package striver_sde_sheet.dynamic_programming;

import java.util.Arrays;

public class P64MinimumPathSum {
    public int minPathSum(int[][] grid) {
        return minPathSum(grid.length-1, grid[0].length-1, grid);
    }

    private int minPathSum(int i, int j, int[][] grid) {
        if ( i == 0 && j == 0) return grid[i][j];
        if ( i < 0 || j<0) return Integer.MAX_VALUE;
        int up = Integer.MAX_VALUE, left = Integer.MAX_VALUE;
        if ( i>0) up = grid[i][j] + minPathSum(i-1, j, grid);
        if ( j>0) left = grid[i][j] + minPathSum(i, j-1, grid);
        return Math.min(up, left);
    }

    public int minPathSumMemoized(int[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        for ( int[] row: memo) Arrays.fill(row, -1);
        return minPathSumMemoized(grid.length-1, grid[0].length-1, grid, memo);
    }

    private int minPathSumMemoized(int i, int j, int[][] grid, int[][] memo) {
        if ( i == 0 && j == 0) return grid[i][j];
        if ( i < 0 || j<0) return Integer.MAX_VALUE;
        if ( memo[i][j] != -1) return memo[i][j];
        int up = Integer.MAX_VALUE, left = Integer.MAX_VALUE;
        if ( i>0) up = grid[i][j] + minPathSumMemoized(i-1, j, grid, memo);
        if ( j>0) left = grid[i][j] + minPathSumMemoized(i, j-1, grid, memo);
        return memo[i][j] = Math.min(up, left);
    }

    public int minPathSumTabular(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for ( int i=0; i<grid.length; i++){
            for ( int j=0; j<grid[0].length; j++){
                if ( i==0 && j == 0) continue;
                else {
                    int up = Integer.MAX_VALUE, left = Integer.MAX_VALUE;
                    if ( i > 0) up = grid[i][j]+dp[i-1][j];
                    if ( j > 0) left = grid[i][j] + dp[i][j-1];
                    dp[i][j] = Math.min(up, left);
                }
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}
