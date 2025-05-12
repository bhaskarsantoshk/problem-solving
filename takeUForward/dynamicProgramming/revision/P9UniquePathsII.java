package takeUForward.dynamicProgramming.revision;

import java.util.Arrays;

public class P9UniquePathsII {
    public int uniquePathsWithObstacles(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        return f(matrix, m-1, n-1);
    }

    private int f(int[][] matrix, int i, int j) {
        if ( i >=0 && j >=0 && matrix[i][j] == -1) return 0;
        if ( i == 0 && j ==0 ) return 1;
        if ( i < 0 || j <0) return 0;

        int up = f(matrix, i-1, j);
        int left = f(matrix, i, j-1);
        return up+left;
    }

    public int uniquePathsWithObstaclesMemoized(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for ( int i=0; i<m; i++){
            Arrays.fill(dp[i],-1);
        }
        return f(matrix, m-1, n-1, dp);
    }

    private int f(int[][] matrix, int i, int j, int [][] dp) {
        if ( i >=0 && j >=0 && matrix[i][j] == 1) return 0;
        if ( i == 0 && j ==0 ) return 1;
        if ( i < 0 || j <0) return 0;
        if ( dp[i][j] != -1) return dp[i][j];

        int up = f(matrix, i-1, j);
        int left = f(matrix, i, j-1);
        return dp[i][j]=up+left;
    }

    public int uniquePathsWithObstaclesTabulation(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        if ( matrix[0][0] == 1) return 0;
        dp[0][0] =1;
        for ( int i=0; i<m; i++){
            for ( int j=0; j<n; j++){
                if ( matrix[i][j] == 1) dp[i][j] = 0;
                else if ( i==0 && j==0) dp[i][j] = 1;
                else {
                    int up = 0, left = 0;
                    if (i > 0) up = dp[i - 1][j];
                    if (j > 0) left = dp[i][j - 1];
                    dp[i][j] = up + left;
                }
            }
        }
        return dp[m-1][n-1];
    }

    public int uniquePathsWithObstaclesSpaceOptimized(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] prev = new int[n];
        if ( matrix[0][0] == 1) return 0;
        prev[0] =1;
        for ( int i=0; i<m; i++){
            int [] cur = new int[n];
            for ( int j=0; j<n; j++){
                if ( matrix[i][j] == 1) cur[j] = 0;
                else if ( i==0 && j==0) cur[j] = 1;
                else {
                    int up = 0, left = 0;
                    if (i > 0) up = prev[j];
                    if (j > 0) left = cur[j - 1];
                    cur[j] = up + left;
                }
            }
            prev = cur;
        }
        return prev[n-1];
    }


}
