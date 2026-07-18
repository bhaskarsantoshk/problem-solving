package takeUForward.graph.revision;

public class SurroundedRegions {
    public char[][] fill(char[][] mat) {
        int n = mat.length, m= mat[0].length;
        char[][] res = new char[n][m];
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                res[i][j] = mat[i][j];
            }
        }

        boolean[][] vis = new boolean[n][m];

        for ( int i = 0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( (i == 0 || i == n-1 || j== 0 || j== m-1) && res[i][j] == 'O'){
                    dfs(i, j, res, vis, n , m);
                }
            }
        }

        for ( int i = 0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( res[i][j] == 'O' && !vis[i][j]){
                    res[i][j] = 'X';
                }
            }
        }

        return res;

    }

    int [][] dirs = {{-1,0}, {0,-1}, {1,0}, {0,1}};

    private void dfs(int row, int col, char[][] res, boolean[][] vis, int n, int m) {
        vis[row][col] = true;
        for ( int []dir: dirs){
            int nRow = row+dir[0];
            int nCol = col + dir[1];
            if ( nRow >=0 && nRow < n && nCol >=0 && nCol < m && res[nRow][nCol] == 'O' && !vis[nRow][nCol]){
                dfs(nRow, nCol, res, vis, n, m);
            }
        }
    }
}
