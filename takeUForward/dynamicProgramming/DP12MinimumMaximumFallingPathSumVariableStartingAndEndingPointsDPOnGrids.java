package takeUForward.dynamicProgramming;

import java.util.Arrays;

public class DP12MinimumMaximumFallingPathSumVariableStartingAndEndingPointsDPOnGrids {
    public static int getMaxPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int max= -(int)1e9;
        for ( int j=0; j<m; j++){
            max = Math.max(max, getMaxPathSum(n-1, j, matrix, n, m));
        }
        return max;
    }

    private static int getMaxPathSum(int i, int j, int[][] matrix, int n, int m) {
        if ( j <0 || j>= m) return (int)-1e9;
        if ( i == 0) return matrix[i][j];

        int straight = matrix[i][j]+getMaxPathSum(i-1, j, matrix, n, m);
        int leftDiag = matrix[i][j]+getMaxPathSum(i-1, j-1, matrix, n, m);
        int rightDiag = matrix[i][j]+getMaxPathSum(i-1, j+1, matrix, n, m);

        return Math.max( straight, Math.max(leftDiag, rightDiag));
    }


    public static int getMaxPathSumMemo(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] memo = new int[n][m];
        for ( int i=0; i<n; i++) Arrays.fill(memo[i], -1);
        int max= -(int)1e9;
        for ( int j=0; j<m; j++){
            max = Math.max(max, getMaxPathSumMemo(n-1, j, matrix, n, m, memo));
        }
        return max;
    }

    private static int getMaxPathSumMemo(int i, int j, int[][] matrix, int n, int m, int[][] memo) {
        if ( j <0 || j>= m) return (int)-1e9;
        if ( i == 0) return memo[i][j]=matrix[i][j];
        if ( memo[i][j] != -1) return memo[i][j];


        int straight = matrix[i][j]+getMaxPathSumMemo(i-1, j, matrix, n, m, memo);
        int leftDiag = matrix[i][j]+getMaxPathSumMemo(i-1, j-1, matrix, n, m, memo);
        int rightDiag = matrix[i][j]+getMaxPathSumMemo(i-1, j+1, matrix, n, m, memo);

        return memo[i][j]= Math.max( straight, Math.max(leftDiag, rightDiag));
    }

    public static int getMaxPathSumTabular(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];

        for (int j=0; j<m; j++){
            dp[0][j] = matrix[0][j];
        }

        for ( int i=1; i<n; i++){
            for ( int j=0; j<m; j++){
                int up = matrix[i][j]+ dp[i-1][j];
                int ld = matrix[i][j];
                if ( j-1 >= 0) ld += dp[i-1][j-1];
                else ld += -(int)1e8;
                int rd = matrix[i][j];
                if ( j+1 <m )
                    rd += dp[i-1][j+1];
                else rd += -(int)1e8;
                dp[i][j] = Math.max( up, Math.max( ld, rd));
            }
        }

        int max= -(int)1e8;
        for ( int j=0; j<m; j++){
            max = Math.max(max, dp[n-1][j]);
        }
        return max;
    }
}
