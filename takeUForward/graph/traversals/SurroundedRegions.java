package takeUForward.graph.traversals;

public class SurroundedRegions {
    public char[][] fill(char[][] mat) {
        int n = mat.length, m = mat[0].length;
        boolean[][] vis = new boolean[n][m];
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( (i == 0 || i == n-1 || j==0 || j==m-1) && !vis[i][j] && mat[i][j] == 'O' ){
                    dfs(mat, i, j, n, m, vis);
                }
            }
        }

        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( mat[i][j] == 'O' && !vis[i][j]){
                    mat[i][j] = 'X';
                }
            }
        }

        return mat;
    }

    int[][] dirs = {{-1,0}, {0,-1}, {1,0}, {0,1}};

    private void dfs(char[][] mat, int i, int j, int n, int m, boolean[][] vis) {
        vis[i][j] = true;
        for ( int [] dir: dirs){
            int nRow = i+dir[0];
            int nCol = j+dir[1];

            if ( nRow >=0 && nRow <n && nCol >=0 && nCol < m && !vis[nRow][nCol] && mat[nRow][nCol] == 'O'){
                dfs(mat, nRow, nCol, n, m, vis);
            }
        }
    }
}
