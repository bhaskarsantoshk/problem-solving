package takeUForward.dynamicProgramming.revision3;

import java.util.Arrays;

public class P10Triangle {
    public int minTriangleSum(int[][] triangle) {
        int n = triangle.length;
        return f(triangle, 0, 0, n);
    }

    private int f(int[][] triangle, int i, int j, int n) {
        if ( i == n-1 ) return triangle[i][j];
        int down = triangle[i][j] + f(triangle, i+1, j, n);
        int diag = triangle[i][j] + f(triangle, i+1, j+1, n);
        return Math.min(down, diag);
    }

    public int minTriangleSumMemo(int[][] triangle) {
        int n = triangle.length;
        int [][] memo = new int[n][n];
        for ( int i=0; i<n; i++) Arrays.fill(memo[i], -1);
        return f(triangle, 0, 0, n, memo);
    }

    private int f(int[][] triangle, int i, int j, int n, int[][] memo) {
        if ( i == n-1 ) return triangle[i][j];
        if ( memo[i][j] != -1) return memo[i][j];
        int down = triangle[i][j] + f(triangle, i+1, j, n, memo);
        int diag = triangle[i][j] + f(triangle, i+1, j+1, n, memo);
        return memo[i][j]= Math.min(down, diag);
    }

    public int minTriangleSumDP(int[][] triangle) {
        int n = triangle.length;
        int [][] dp = new int[n][n];
        for ( int j=0; j<n; j++) dp[n-1][j] = triangle[n-1][j];
        for ( int i=n-2; i>=0; i--){
            for ( int j=0; j<=i; j++){
                int down = triangle[i][j] + dp[i+1][j];
                int diag = triangle[i][j] + dp[i+1][j+1];
                dp[i][j]= Math.min(down, diag);
            }
        }
        return dp[0][0];
    }
}
