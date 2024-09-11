package company.google.dynamic_programming;

public class P1277CountSquareSubmatricesWithAllOnes {
    public int countSquares(int[][] matrix) {
        // DP table is more intuitive than recursion

        int n = matrix.length, m = matrix[0].length;
        int [][] dp = new int[n][m];

        // 1st column
        for ( int i=0; i<n; i++){
            dp[i][0] = matrix[i][0];
        }

        // 1st row
        for ( int j=0; j<m; j++){
            dp[0][j] = matrix[0][j];
        }

        // dp[i][j] is number of squares ending at i, j ( right bottom of squares )
        for ( int i=1; i<n; i++){
            for ( int j=1; j<m; j++){
                if ( matrix[i][j] == 0) dp[i][j] = 0;
                else {
                    dp[i][j] = 1 + Math.min( dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                }
            }
        }

        int sum = 0;
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                sum += dp[i][j];
            }
        }

        return sum;
    }
}
