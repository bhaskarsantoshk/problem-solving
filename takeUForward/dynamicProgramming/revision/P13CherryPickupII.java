package takeUForward.dynamicProgramming.revision;

import java.util.Arrays;

public class P13CherryPickupII {
    public int cherryPickup(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
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
        int m = matrix[0].length;
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

    public int cherryPickupTabulation(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][][] dp= new int[n][m][m];


        // base case from rec
        for ( int j1=0; j1<m; j1++){
            for ( int j2=0; j2<m; j2++){
                if ( j1 == j2) dp[n-1][j1][j2] = matrix[n-1][j1];
                else dp[n-1][j1][j2] = matrix[n-1][j1] + matrix[n-1][j2];
            }
        }

        // express all
        for ( int i=n-2; i>=0; i--){
            for ( int j1=0; j1<m; j1++){
                for ( int j2=0; j2<m; j2++){
                    // copy reccurrence and adjust boundary
                    int max = 0;
                    for ( int dj1=-1;dj1<=1; dj1++){
                        for ( int dj2=-1; dj2<=1;dj2++){
                            int value =0;
                            if ( j1 == j2) value =  matrix[i][j1];
                            else value = matrix[i][j1] +  matrix[i][j2];
                            if ( j1 + dj1 >=0 && j1+dj1 < m && j2+dj2 >=0 && j2+dj2 <m){
                                value+= dp[i+1] [j1+dj1] [j2+dj2];
                                max = Math.max(max, value);
                            }

                        }
                    }
                    dp[i][j1][j2] = max;
                }
            }
        }
        return dp[0][0][m-1];
    }
}
