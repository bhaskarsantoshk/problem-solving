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

    public int minFallingPathTabular(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;
        int [][] dp = new int[n][m];
        for ( int j=0; j<m; j++) dp[0][j] = matrix[0][j];
        for ( int i=1; i<n; i++){
            for ( int j=0; j<m; j++){
                int up = matrix[i][j] + dp[i-1][j];
                int ld = (int) 1e9;
                int rd = (int) 1e9;
                if ( j > 0) ld = matrix[i][j] + dp[i-1][j-1];
                if ( j < m-1) rd = matrix[i][j] + dp[i-1][j+1];

                dp[i][j] = Math.min( up , Math.min(ld, rd) );
            }
        }
        int min = dp[n-1][0];
        for ( int i=1; i<m; i++){
            min = Math.min(min, dp[n-1][i]);
        }
        return min;
    }

    public int minFallingPathSpaceOptimized(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;
        int [] prev = new int[m];
        for ( int j=0; j<m; j++) prev[j] = matrix[0][j];
        for ( int i=1; i<n; i++){
            int []cur = new int[m];
            for ( int j=0; j<m; j++){
                int up = matrix[i][j] + prev[j];
                int ld = (int) 1e9;
                int rd = (int) 1e9;
                if ( j > 0) ld = matrix[i][j] + prev[j-1];
                if ( j < m-1) rd = matrix[i][j] + prev[j+1];

                cur[j] = Math.min( up , Math.min(ld, rd) );
            }
            prev = cur;
        }
        int min = prev[0];
        for ( int i=1; i<m; i++){
            min = Math.min(min, prev[i]);
        }
        return min;
    }
}
