package takeUForward.dynamicProgramming;

import java.util.Arrays;

public class DP8GridUniquePaths {
    public static int uniquePaths(int m, int n) {
        return countUniquePaths(m-1, n-1);
    }

    private static int countUniquePaths(int row, int col) {
        if ( row == 0 && col == 0) return 1;
        if ( row < 0 || col < 0) return 0;
        int up = countUniquePaths(row-1, col);
        int left = countUniquePaths(row, col-1);
        return up+left;
    }

    public static int uniquePathsMemo(int m, int n) {
        int [][] memo = new int[m][n];
        for ( int i=0; i<m; i++){
            Arrays.fill(memo[i], -1);
        }
        return countUniquePathsMemo(m-1, n-1, memo);
    }

    private static int countUniquePathsMemo(int row, int col, int[][] memo) {
        if ( row == 0 && col == 0) return memo[row][col]=  1;
        if ( row < 0 || col < 0) return 0;
        if ( memo[row][col] != -1) return memo[row][col];
        int up = countUniquePathsMemo(row-1, col, memo);
        int left = countUniquePathsMemo(row, col-1, memo);
        return memo[row][col]= up+left;
    }

    public static int uniquePathsTabular(int m, int n) {
        int [][] dp = new int[m][n];
        dp[0][0] = 1;
        for ( int i=0; i<m; i++){
            for ( int j=0; j<n; j++){
                if ( i==0 && j==0) continue;
                int up=0;
                if(i>0) up = dp[i-1][j];
                int left=0;
                if(j>0) left = dp[i][j-1];
                dp[i][j] = up+left;
            }
        }
        return dp[m-1][n-1];
    }
}
