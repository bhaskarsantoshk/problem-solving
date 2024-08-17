package takeUForward.dynamicProgramming;

import java.util.Arrays;

public class MaximumPathSumInTheMatrix {
    public static int getMaxPathSum(int[][] matrix) {
        int max = Integer.MAX_VALUE;
        for ( int j=0; j<matrix[0].length; j++){
            max = Math.min( max, f(matrix.length-1, j, matrix));
        }
        return max;
    }

    private static int f(int i, int j, int[][] matrix) {
        if ( j < 0 ) return (int) -1e9;
        if ( i == 0) return matrix[i][j];
        int up = matrix[i][j] + f(i-1, j, matrix);
        int leftDiag = matrix[i][j] + f(i-1, j-1, matrix);
        int rightDiag = matrix[i][j] + f(i-1, j+1, matrix);
        return Math.max (Math.max(up, leftDiag), rightDiag);
    }

    public static int getMaxPathSumMemoized(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        int [][] memo = new int[matrix.length][matrix[0].length];
        for ( int[] row: memo){
            Arrays.fill(row, -1);
        }
        for ( int j=0; j<matrix[0].length; j++){
            max = Math.max( max, getMaxPathSumMemoized(matrix.length-1, j, matrix, memo));
        }
        return max;
    }

    private static int getMaxPathSumMemoized(int i, int j, int[][] matrix, int[][] memo) {
        if ( j < 0 || j>= matrix[0].length ) return (int) -1e9;
        if ( i == 0) return matrix[i][j];
        if ( memo[i][j] != -1) return memo[i][j];
        int up = matrix[i][j] + getMaxPathSumMemoized(i-1, j, matrix, memo);
        int leftDiag = matrix[i][j] + getMaxPathSumMemoized(i-1, j-1, matrix, memo);
        int rightDiag = matrix[i][j] + getMaxPathSumMemoized(i-1, j+1, matrix, memo);
        return memo[i][j]= Math.max (Math.max(up, leftDiag), rightDiag);
    }

    public static int getMaxPathSumTabular(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int [][] dp = new int[n][m];
        for ( int j=0; j<m; j++){
            dp[0][j]= matrix[0][j];
        }
        for ( int i=1; i<n; i++){
            for ( int j=0; j<m; j++){
                int up , ld, rd;
                up = ld = rd = (int) -1e9;
                 up = matrix[i][j] + dp[i-1][j];
                 if ( j-1 > 0) ld = matrix[i][j] + dp[i-1][j-1];
                 if ( j+1 < m ) rd = matrix[i][j] + dp[i-1][j+1];
                dp[i][j] = Math.max(up, Math.max(ld, rd));
            }
        }
        int max = Integer.MIN_VALUE;
        for ( int j=0; j<m; j++){
            max = Math.max( dp[n-1][j], max);
        }
        return max;
    }
}
