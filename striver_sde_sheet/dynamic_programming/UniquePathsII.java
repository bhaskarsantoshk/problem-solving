package striver_sde_sheet.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;

public class UniquePathsII {
    static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        return f(n-1, m-1, mat);
    }

    private static int f(int i, int j, ArrayList<ArrayList<Integer>> mat) {
        if ( i>=0 && j>=0 && mat.get(i).get(j) == -1) return 0;
        if ( i == 0 && j == 0) return 1;
        if ( i < 0 || j <0) return 0;
        int up=0, left=0;
        if ( i>0 ) up = f(i-1, j, mat);
        if( j>0) left = f(i, j-1, mat);
        return up+left;
    }

    static int mazeObstaclesMemoized(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        int[][] memo = new int[mat.size()][mat.get(0).size()];
        for ( int[] row: memo) Arrays.fill(row, -1);
        return mazeObstaclesMemoized(n-1, m-1, mat, memo);
    }

    private static int mazeObstaclesMemoized(int i, int j, ArrayList<ArrayList<Integer>> mat, int[][] memo) {
        if ( i>=0 && j>=0 && mat.get(i).get(j) == -1) return 0;
        if ( memo[i][j] != -1) return memo[i][j];
        if ( i == 0 && j == 0) return 1;
        if ( i < 0 || j <0) return 0;
        int up=0, left=0;
        if ( i>0 ) up = mazeObstaclesMemoized(i-1, j, mat, memo);
        if( j>0) left = mazeObstaclesMemoized(i, j-1, mat, memo);
        return memo[i][j] = (up%1000000007+left%1000000007)%1000000007;
    }

    static int mazeObstaclesTabular(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        int [][] dp = new int[n][m];
        dp[0][0] = 1;
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( i == 0 && j == 0) dp[i][j] = 1;
                else if (mat.get(i).get(j) == -1) dp[i][j] = 0;
                else {
                    int up = 0;
                    int left = 0;
                    if (i > 0) up = dp[i - 1][j];
                    if (j > 0) left = dp[i][j - 1];
                    dp[i][j] = (up%1000000007+left%1000000007)%1000000007;
                }
            }
        }
        return dp[n-1][m-1];
    }

    static int mazeObstaclesTabularSpaceOptimized(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        int [] prev = new int[m];
        for ( int i=0; i<n; i++){
            int cur[] = new int[m];
            for ( int j=0; j<m; j++){
                if (mat.get(i).get(j) == -1) cur[j] = 0;
                else if ( i == 0 && j == 0) cur[j] = 1;
                else {
                    int up = 0;
                    int left = 0;
                    if (i > 0) up = prev[j];
                    if (j > 0) left = cur[j - 1];
                    cur[j] = (up%1000000007+left%1000000007)%1000000007;
                }
            }
            prev = cur;
        }
        return prev[m-1];
    }
}
