package takeUForward.dynamicProgramming.revision;

import java.util.Arrays;

public class P13CherryPickupII {
    public int cherryPickup(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length-1;
        return f(0, 0,0, matrix);
    }

    private int f(int i, int j1, int j2, int[][] matrix) {
        if( j1 < 0 || j1>=matrix[0].length || j2 < 0 || j2>= matrix[0].length){
            return (int) -1e9;
        }
        if ( i == matrix.length-1){
            if ( j1 == j2 ) return matrix[i][j1];
            else return matrix[i][j1]+matrix[i][j2];
        }
        int max = 0;
        for ( int dj1=-1;dj1<=1; dj1++){
            for ( int dj2=-1; dj2<=1;dj2++){
                if ( j1 == j2) max = Math.max( max, matrix[i][j1] + f(i+1, j1+dj1, j2+dj2, matrix));
                else max = Math.max(max, matrix[i][j1]+ matrix[i][j2] + f(i+1, j1+dj1, j2+dj2, matrix));
            }
        }
        return max;
    }

    public int cherryPickupMemoized(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length-1;
        int[][][] dp= new int[n][m][m];
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return f(0, 0,m-1, matrix, dp);
    }

    private int f(int i, int j1, int j2, int[][] matrix, int[][][] dp) {
        if( j1 < 0 || j1>=matrix[0].length || j2 < 0 || j2>= matrix[0].length){
            return (int) -1e9;
        }
        if ( i == matrix.length-1){
            if ( j1 == j2 ) return matrix[i][j1];
            else return matrix[i][j1]+matrix[i][j2];
        }
        if ( dp[i][j1][j2] != -1) return dp[i][j1][j2];
        int max = 0;
        for ( int dj1=-1;dj1<=1; dj1++){
            for ( int dj2=-1; dj2<=1;dj2++){
                if ( j1 == j2) max = Math.max( max, matrix[i][j1] + f(i+1, j1+dj1, j2+dj2, matrix));
                else max = Math.max(max, matrix[i][j1]+ matrix[i][j2] + f(i+1, j1+dj1, j2+dj2, matrix));
            }
        }
        return dp[i][j1][j2] = max;
    }
}
