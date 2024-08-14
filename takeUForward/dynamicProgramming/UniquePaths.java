package takeUForward.dynamicProgramming;

import java.util.Arrays;

public class UniquePaths {
    // f(i,j) - num of unique ways to reach from 0,0 -> i,j
    // 2 ^ m*n
    // S: O(Path length) = M+N
    public static int uniquePaths(int m, int n) {
        return f(m-1, n-1);
    }

    private static int f(int row, int col) {
        if ( row == 0 && col == 0) return 1;
        if ( row < 0 || col <0 ) return 0;
        int up = f( row-1, col);
        int left = f(row, col-1);
        return up + left;
    }

    public static int uniquePathsMemoization(int m, int n) {
        int [][] memo = new int[m][n];
        for ( int [] row: memo){
            Arrays.fill(row, -1);
        }
        return fMemoized(m-1, n-1, memo);
    }

    private static int fMemoized(int row, int col, int[][] memo) {
        if ( row == 0 && col == 0) return 1;
        if ( row < 0 || col <0 ) return 0;
        if ( memo[row][col] != -1) return memo[row][col];
        int up = fMemoized( row-1, col, memo);
        int left = fMemoized(row, col-1, memo);
        return memo[row][col] = up + left;
    }

    public static int uniquePathsTabular(int m, int n) {
        int [][] dp = new int[m][n];
        dp[0][0] = 1;
        for ( int i=0; i<m; i++){
            for ( int j=0; j<n; j++){
                if ( i == 0 && j == 0 ) dp[0][0] = 1;
                else {
                    int up =0, left = 0;
                    if ( i>0) up = dp[i-1][j];
                    if ( j>0) left = dp[i][j-1];
                    dp[i][j] = up +left;
                }
            }
        }
        return dp[m-1][n-1];
    }
}
