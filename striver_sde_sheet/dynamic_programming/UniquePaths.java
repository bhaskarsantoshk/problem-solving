package striver_sde_sheet.dynamic_programming;

import java.util.Arrays;

public class UniquePaths {
    public static int uniquePaths(int m, int n) {
        return f(m-1, n-1);
    }

    private static int f(int i, int j) {
        if ( i == 0 && j == 0) return 1;
        if ( i < 0 || j <0) return 0;
        int up = f(i-1, j);
        int left = f(i, j-1);
        return up+left;
    }

    public static int uniquePathsMemoized(int m, int n) {
        int [][] memo = new int[m][n];
        for ( int [] row: memo){
            Arrays.fill(row, -1);
        }
        return uniquePathsMemoized(m-1, n-1, memo);
    }

    private static int uniquePathsMemoized(int i, int j, int[][] memo) {
        if ( i == 0 && j == 0) return 1;
        if ( i < 0 || j <0) return 0;
        if ( memo[i][j] != -1) return memo[i][j];
        int up = uniquePathsMemoized(i-1, j, memo);
        int left = uniquePathsMemoized(i, j-1, memo);
        return memo[i][j] = up+left;
    }

    public static int uniquePathsTabular(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for ( int i=0; i<m; i++){
            for ( int j=0; j<n; j++){
                if ( i==0 && j == 0) continue;
                int up = 0, left = 0;
                if (i >0) up = dp[i-1][j];
                if ( j>0) left = dp[i][j-1];
                dp[i][j] = up + left;
            }
        }
        return dp[m-1][n-1];
    }

    public static int uniquePathsTabularSpaceOptimized(int m, int n) {
        int[] prev = new int[n];
        prev[0] = 1;
        for ( int i=0; i<m; i++){
            int [] current = new int[n];
            for ( int j=0; j<n; j++){
                if ( i==0 && j == 0) current[j] = 1;
                else {
                    int up = 0, left = 0;
                    if (i > 0) up = prev[j];
                    if (j > 0) left = current[j - 1];
                    current[j] = up + left;
                }
            }
            prev = current;
        }
        return prev[n-1];
    }


}
