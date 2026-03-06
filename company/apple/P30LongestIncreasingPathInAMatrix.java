package company.apple;

import java.util.Arrays;

public class P30LongestIncreasingPathInAMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] vis = new int[n][m];
        int max = 0;
        for ( int i=0; i<n; i++) Arrays.fill(vis[i], -1);
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( vis[i][j] == -1){
                    max = Math.max(max, dfs(matrix, i, j, vis));
                }
            }
        }
        return max;
    }

    int[][] dirs = {{-1,0}, {0,-1}, {1,0}, {0,1}};

    private int dfs(int[][] matrix, int i, int j, int[][] vis) {
       int max = 1;
       if ( vis[i][j] != -1) return vis[i][j];

       for ( int[] dir: dirs){
           int nRow = i+dir[0];
           int nCol = j+dir[1];

           if ( nRow >= 0 && nRow < matrix.length && nCol >=0 && nCol < matrix[0].length && matrix[i][j] < matrix[nRow][nCol]){
               max = Math.max(max, 1+ dfs(matrix, nRow, nCol, vis));
           }
       }

       return vis[i][j] = max;

    }
}
