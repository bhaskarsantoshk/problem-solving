package company.karat;

import java.util.Arrays;

public class P221MaximalSquare {
    int max = 0;
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( matrix[i][j] == '1') findMaximalSquare(matrix, i, j, n, m);
            }
        }
        return max*max;
    }

    private int findMaximalSquare(char[][] matrix, int row, int col,int n, int m) {
        if ( row >= n || col >= m) return 0;
        if (matrix[row][col] == '0') return 0;
        int right = findMaximalSquare(matrix, row, col+1, n, m);
        int down = findMaximalSquare(matrix, row+1, col, n, m);
        int diag = findMaximalSquare(matrix, row+1, col+1, n, m);
        int curSquare = 1 + Math.min ( Math.min(right, down), diag);
        max = Math.max(curSquare, max);
        return curSquare;
    }


    public int maximalSquareMemoized(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int [][] memo = new int[n][m];
        for ( int i=0; i<n; i++) Arrays.fill(memo[i], -1);
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( matrix[i][j] == '1') findMaximalSquare(matrix, i, j, n, m, memo);
            }
        }
        return max*max;
    }

    private int findMaximalSquare(char[][] matrix, int row, int col,int n, int m, int [][] memo) {
        if ( row >= n || col >= m) return 0;
        if (matrix[row][col] == '0') return 0;
        if ( memo[row][col] != -1) return memo[row][col];
        int right = findMaximalSquare(matrix, row, col+1, n, m, memo);
        int down = findMaximalSquare(matrix, row+1, col, n, m, memo);
        int diag = findMaximalSquare(matrix, row+1, col+1, n, m, memo);
        int curSquare = 1 + Math.min ( Math.min(right, down), diag);
        max = Math.max(curSquare, max);
        return memo[row][col]= curSquare;
    }

    public int maximalSquareDP(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int [][] dp = new int[n+1][m+1];
        for ( int row=n-1; row>=0; row--){
            for ( int col=m-1; col>=0; col--){
                if ( matrix[row][col] == '1') {
                    int right = dp[row][col+1];
                    int down = dp[row+1][col];
                    int diag = dp[row+1][col+1];
                    int curSquare = 1 + Math.min ( Math.min(right, down), diag);
                    max = Math.max(curSquare, max);
                    dp[row][col] = curSquare;
                }
            }
        }
        return max*max;
    }

}
