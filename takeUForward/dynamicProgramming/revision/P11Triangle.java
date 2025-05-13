package takeUForward.dynamicProgramming.revision;

import java.util.Arrays;

public class P11Triangle {
    public int minTriangleSum(int[][] triangle) {
        return f(0,0, triangle);
    }

    private int f(int i, int j, int[][] triangle) {
        if ( i == triangle.length-1) return triangle[i][j];

        int down = triangle[i][j]+ f(i+1, j, triangle);
        int diag = triangle[i][j]+ f(i+1, j+1, triangle);
        return Math.min(down, diag);
    }

    public int minTriangleSumMemoized(int[][] triangle) {
        int m = triangle.length;
        int [][] dp = new int[m][];
        for ( int i=0; i<m; i++) {
            dp[i] = new int[triangle[i].length];
            Arrays.fill(dp[i], -1);
        }
        return f(0,0, triangle, dp);
    }

    private int f(int i, int j, int[][] triangle, int[][] dp) {
        if ( i == triangle.length-1) return triangle[i][j];
        if ( dp[i][j] != -1) return dp[i][j];

        int down = triangle[i][j]+ f(i+1, j, triangle, dp);
        int diag = triangle[i][j]+ f(i+1, j+1, triangle, dp);
        return dp[i][j]= Math.min(down, diag);
    }

    public int minTriangleSumTabular(int[][] triangle) {
        int m = triangle.length;
        int [][] dp = new int[m][];
        for ( int i=0; i<m; i++) {
            dp[i] = new int[triangle[i].length];
        }
        for ( int i=m-1; i>=0; i--){
            for ( int j=triangle[i].length-1; j>=0; j--){
                if ( i == m-1) dp[i][j] = triangle[i][j];
                else {
                    int down = triangle[i][j]+ dp[i+1] [j];
                    int diag = triangle[i][j]+ dp[i+1] [j+1];
                    dp[i][j] = Math.min(down, diag);
                }
            }
        }
        return dp[0][0];
    }
}
