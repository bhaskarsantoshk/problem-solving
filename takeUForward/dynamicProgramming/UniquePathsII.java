package takeUForward.dynamicProgramming;

import java.util.ArrayList;

public class UniquePathsII {
    static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        return f(n-1, m-1, mat);
    }

    private static int f(int row, int col, ArrayList<ArrayList<Integer>> mat) {
        if ( row >= 0 && col >=0 && mat.get(row).get(col) == -1) return 0;
        if ( row < 0 || col < 0) return 0;
        if ( row == 0 && col == 0) return 1;

        int up = f(row-1, col , mat);
        int left = f(row, col-1, mat);
        return up+left;
    }


    static int mazeObstaclesTabular(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        int [][] dp = new int[n][m];
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( mat.get(i).get(j) == -1) continue; // dp[i][j]=0
                else if ( i == 0 && j == 0) dp[i][j]=1;
                else {
                    int up = 0, left = 0;
                    if ( i > 0) up = dp[i-1][j];
                    if ( j > 0 ) left = dp[i][j-1];
                    dp[i][j] = up + left;
                }
            }
        }
        return dp[n-1][m-1];
    }
}
