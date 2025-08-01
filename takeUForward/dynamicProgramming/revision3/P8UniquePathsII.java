package takeUForward.dynamicProgramming.revision3;

import java.util.Arrays;

public class P8UniquePathsII {
    public int uniquePathsWithObstacles(int[][] matrix) {
        if ( matrix[0][0] == 1) return 0;
        int n = matrix.length, m = matrix[0].length;
        return f(n-1, m-1, matrix);
    }

    private int f(int i, int j, int[][] matrix) {
        if ( i == 0 && j == 0) return 1;
        if ( i < 0 || j < 0) return 0;
        if ( matrix[i][j] == 1) return 0;
        int up = f(i-1, j, matrix);
        int left = f(i, j-1, matrix);
        return up+left;
    }

    public int uniquePathsWithObstaclesMemoized(int[][] matrix) {
        if ( matrix[0][0] == 1) return 0;
        int n = matrix.length, m = matrix[0].length;
        int [][] dp = new int[n][m];
        for ( int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        return f(n-1, m-1, matrix, dp);
    }

    private int f(int i, int j, int[][] matrix, int [][] dp) {
        if ( i == 0 && j == 0) return 1;
        if ( i < 0 || j < 0) return 0;
        if ( matrix[i][j] == 1) return 0;
        if ( dp[i][j] != -1) return dp[i][j];
        int up = f(i-1, j, matrix, dp);
        int left = f(i, j-1, matrix, dp);
        return dp[i][j] = up+left;
    }

    public int uniquePathsWithObstaclesDP(int[][] matrix) {
        if ( matrix[0][0] == 1) return 0;
        int n = matrix.length, m = matrix[0].length;
        int [][] dp = new int[n][m];
        dp[0][0] = 1;
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( matrix[i][j] == 1) continue;
                else {
                    if (i == 0 && j == 0) dp[i][j] = 1;
                    else {
                        int up = 0, left = 0;
                        if (i > 0) up = dp[i - 1][j];
                        if (j > 0) left = dp[i][j - 1];
                        dp[i][j] = up + left;
                    }
                }
            }
        }
        return dp[n-1][m-1];
    }
}
