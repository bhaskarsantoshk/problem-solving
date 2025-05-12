package takeUForward.dynamicProgramming.revision;

import java.util.Arrays;

public class P8GridUniquePaths {
    public int uniquePaths(int m, int n) {
        return f(m-1, n-1);
    }

    private int f(int i, int j) {
        if ( i==0 && j == 0) return 1;
        if ( i < 0 || j <0) return 0;
        int up = f(i-1, j);
        int left = f(i, j-1);
        return up+left;
    }

    public int uniquePathsMemoized(int m, int n) {
        int [][] dp = new int[m][n];
        for ( int i=0; i<m; i++){
            Arrays.fill(dp[i], -1);
        }
        return f(m-1, n-1, dp);
    }

    private int f(int i, int j, int[][] dp) {
        if ( i==0 && j == 0) return 1;
        if ( i < 0 || j <0) return 0;
        if ( dp[i][j] != -1) return dp[i][j];
        int up = f(i-1, j, dp);
        int left = f(i, j-1, dp);
        return dp[i][j] = up+left;
    }

    public int uniquePathsTabulation(int m, int n) {
        int[][] dp = new int[m][n];
        for ( int i=0; i<m; i++){
            for ( int j=0; j<n; j++){
                if ( i==0 && j==0) dp[0][0]=1;
                else {
                    int up=0, left=0;
                    if ( i > 0) up = dp[i - 1][j];
                    if( j>0) left = dp[i][j - 1];
                    dp[i][j] = up + left;
                }
            }
        }
        return dp[m-1][n-1];
    }
}
