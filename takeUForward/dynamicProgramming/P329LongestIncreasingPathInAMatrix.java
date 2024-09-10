package takeUForward.dynamicProgramming;

import java.util.Arrays;

public class P329LongestIncreasingPathInAMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        int n = matrix.length, m = matrix[0].length;
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                max = Math.max( max, dfs(i, j, matrix, n, m));
            }
        }
        return max;
    }

    private int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};

    private int dfs(int i, int j, int[][] matrix, int n, int m) {
        int max = 1;
        for ( int [] dir: dirs){
            int nRow = i+dir[0];
            int nCol = j+ dir[1];

            if ( nRow <0 || nRow>= n || nCol <0 || nCol >= m || matrix[nRow][nCol] <= matrix[i][j]){
                continue;
            }
            int len = 1 + dfs(nRow, nCol, matrix, n, m);
            max = Math.max( len, max);
        }
        return max;
    }

    public int longestIncreasingPathMemoized(int[][] matrix) {
        int max = 0;
        int n = matrix.length, m = matrix[0].length;
        int [][] memo = new int[n][m];
        for ( int [] row: memo) Arrays.fill(row, -1);
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                max = Math.max( max, dfsMemo(i, j, matrix, n, m, memo));
            }
        }
        return max;
    }

    private int dfsMemo(int i, int j, int[][] matrix, int n, int m, int[][] memo) {
        int max = 1;
        if ( memo[i][j] != -1 ) return memo[i][j];
        for ( int [] dir: dirs){
            int nRow = i+dir[0];
            int nCol = j+ dir[1];

            if ( nRow <0 || nRow>= n || nCol <0 || nCol >= m || matrix[nRow][nCol] <= matrix[i][j]){
                continue;
            }
            int len = 1 + dfsMemo(nRow, nCol, matrix, n, m, memo);
            max = Math.max( len, max);
        }
        return memo[i][j] = max;
    }

}
