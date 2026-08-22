package takeUForward.graph.revision4;

import java.util.Arrays;

public class G9SurroundedRegions {
    public char[][] fill(char[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        char [][] res = new char[n][m];
        for ( int i=0; i<n; i++) {
            for ( int j=0; j<m; j++){
                res[i][j] = mat[i][j];
            }
        }
        boolean[][] vis = new boolean[n][m];
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( ( i==0 || j == 0 || i == n-1 || j == m-1) && res[i][j] == 'O'){
                    dfs(i, j, vis, res);
                }
            }
        }
        for ( int i=0; i<n; i++) {
            for ( int j=0; j<m; j++){
                if (!vis[i][j] && res[i][j] == 'O') res[i][j] = 'X';
            }
        }

        return res;

    }

    int [][] dirs = {{-1,0}, {0,-1}, {1,0}, {0,1}};

    private void dfs(int row, int col, boolean[][] vis, char[][] res) {
        vis[row][col] = true;
        for ( int [] dir: dirs){
            int nRow = row + dir[0];
            int nCol = col + dir[1];

            if ( nRow >=0 && nRow < res.length && nCol >=0 && nCol < res[0].length && !vis[nRow][nCol] && res[nRow][nCol]== 'O'){
                dfs(nRow, nCol, vis, res);
            }
        }
    }
}
