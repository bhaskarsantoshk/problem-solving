package takeUForward.dynamicProgramming.revision;

import java.util.Arrays;

public class P12MinimumFallingSum {
    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        int n = matrix.length;
        int m = matrix[0].length;
        for ( int j=0; j<m; j++){
            min = Math.min( min, f(matrix, n-1, j));
        }
        return min;
    }

    private int f(int[][] matrix, int i, int j) {
        if ( j < 0 || j >= matrix.length) return -(int)1e9;
        if ( i == 0) return matrix[i][j];

        int up = matrix[i][j] + f(matrix, i-1, j);
        int ld = matrix[i][j] + f( matrix, i-1, j-1);
        int rd = matrix[i][j] + f(matrix, i-1, j+1);

        return Math.min( Math.min(ld, rd), up);
    }

    public int minFallingPathSumMemoized(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        int n = matrix.length;
        int m = matrix[0].length;
        int [][] dp = new int[n][m];
        for ( int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        for ( int j=0; j<m; j++){
            min = Math.min( min, f(matrix, n-1, j, dp));
        }
        return min;
    }

    private int f(int[][] matrix, int i, int j, int[][] dp) {
        if ( j < 0 || j >= matrix[0].length) return (int)1e9;
        if ( i == 0) return matrix[i][j];
        if ( dp[i][j] != -1) return dp[i][j];

        int up = matrix[i][j] + f(matrix, i-1, j, dp);
        int ld = matrix[i][j] + f( matrix, i-1, j-1, dp);
        int rd = matrix[i][j] + f(matrix, i-1, j+1, dp);

        return dp[i][j]= Math.min( Math.min(ld, rd), up);
    }
}
