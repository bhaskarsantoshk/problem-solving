package takeUForward.dynamicProgramming.revision3;

import java.util.Arrays;

public class P9MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int min = Integer.MAX_VALUE;
        for ( int col=0; col<m; col++){
            min = Math.min(min, f(matrix, n-1, col));
        }
        return min;
    }

    private int f(int[][] matrix, int row, int col) {
        if ( col < 0 || col >= matrix[0].length ) return (int)1e9;
        if ( row == 0) return matrix[row][col];
        int up = f( matrix, row-1, col);
        int ld = f( matrix, row-1, col-1);
        int rd = f( matrix, row-1, col+1);
        return matrix[row][col] + Math.min( Math.min(ld, rd), up);
    }

    public int minFallingPathSumMemoized(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int [][] dp = new int[n][m];
        for ( int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        int min = Integer.MAX_VALUE;
        for ( int col=0; col<m; col++){
            min = Math.min(min, f(matrix, n-1, col, dp));
        }
        return min;
    }

    private int f(int[][] matrix, int row, int col, int[][] dp) {
        if ( col < 0 || col >= matrix[0].length ) return (int)1e9;
        if ( row == 0) return matrix[row][col];
        if ( dp[row][col] != -1) return dp[row][col];
        int up = f( matrix, row-1, col, dp);
        int ld = f( matrix, row-1, col-1, dp);
        int rd = f( matrix, row-1, col+1, dp);
        return dp[row][col] = matrix[row][col] + Math.min( Math.min(ld, rd), up);
    }

    public int minFallingPathSumDP(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int [][] dp = new int[n][m];
        for ( int j=0; j<m; j++) dp[0][j] = matrix[0][j];
        for ( int i=1; i<n; i++) {
            for (int j = 0; j < m; j++) {
                int up = dp[i - 1][j];
                int ld = (int) 1e9, rd = (int) 1e9;
                if (j > 0) ld = dp[i - 1][j - 1];
                if (j < m - 1) rd = dp[i - 1][j + 1];
                dp[i][j] = matrix[i][j] + Math.min(Math.min(ld, rd), up);
            }
        }
        int min = Integer.MAX_VALUE;
        for(int j=0; j<m; j++) min = Math.min(min, dp[n-1][j]);
        return min;
    }
}
