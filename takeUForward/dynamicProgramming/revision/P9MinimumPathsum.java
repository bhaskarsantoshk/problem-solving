package takeUForward.dynamicProgramming.revision;
// https://takeuforward.org/plus/dsa/dynamic-programming/dp-on-grids/minimum-falling-path-sum?tab=editorial
// https://leetcode.com/problems/minimum-path-sum/


import java.util.Arrays;

public class P9MinimumPathsum {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        return f(matrix, m-1, n-1);
    }

    private int f(int[][] matrix, int i, int j) {
        if ( i == 0 && j == 0) return matrix[i][j];
        if ( i < 0 || j < 0) return (int)1e9;

        int up= matrix[i][j], left = matrix[i][j];
        if ( i > 0) up += f(matrix, i-1, j);
        if ( j > 0) left += f(matrix, i, j-1);

        return Math.min(up, left);
    }

    public int minFallingPathSumMemoized(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int [][] dp = new int[m][n];
        for ( int i=0; i<m; i++){
            Arrays.fill(dp[i], -1);
        }
        return f(matrix, m-1, n-1, dp);
    }

    private int f(int[][] matrix, int i, int j, int[][] dp) {
        if ( i == 0 && j == 0) return matrix[i][j];
        if ( i < 0 || j < 0) return (int)1e9;

        if ( dp[i][j] != -1) return dp[i][j];

        int up= Integer.MAX_VALUE, left = Integer.MAX_VALUE;
        if ( i > 0) up = matrix[i][j]+ f(matrix, i-1, j, dp);
        if ( j > 0) left = matrix[i][j]+ f(matrix, i, j-1, dp);

        return dp[i][j] = Math.min(up, left);
    }

    public int minPathSumTabulation(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for ( int i=0; i<m; i++){
            for ( int j=0; j<n; j++){
                if ( i==0 && j == 0) continue; // Never forget base ase
                int up= Integer.MAX_VALUE, left = Integer.MAX_VALUE;
                if ( i > 0) up = grid[i][j]+ dp[i-1][j];
                if ( j > 0) left = grid[i][j]+ dp[i][j-1];
                dp[i][j] = Math.min(up, left);
            }
        }
        return dp[m-1][n-1];
    }


    public int minPathSumSpaceOptimization(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] prev = new int[n];
        prev[0] = grid[0][0];
        for ( int i=0; i<m; i++){
            int[] cur = new int[n]
            for ( int j=0; j<n; j++){
                if ( i==0 && j == 0) cur[j] = grid[0][0]; // Never forget base ase
                else {
                    int up = Integer.MAX_VALUE, left = Integer.MAX_VALUE;
                    if (i > 0) up = grid[i][j] + prev[j];
                    if (j > 0) left = grid[i][j] + cur[j - 1];
                    cur[j] = Math.min(up, left);
                }
            }
            prev = cur;
        }
        return prev[n-1];
    }
}
