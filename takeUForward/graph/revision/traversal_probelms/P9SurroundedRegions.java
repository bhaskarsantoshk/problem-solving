package takeUForward.graph.revision.traversal_probelms;

public class P9SurroundedRegions {
    public char[][] fill(char[][] mat) {
        int n = mat.length, m = mat[0].length;
        char[][] res = new char[n][m];
        for ( int i=0; i<n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = mat[i][j];
            }
        }

        int [][] vis = new int[n][m];

        for ( int i=0; i<n; i++) {
            for (int j = 0; j < m; j++) {
                if ( (i==0 || j ==0 || i == n-1 || j==m-1 ) && res[i][j] == 'O' ) {
                    dfs(i,j, res, vis, n, m);
                }
            }
        }
        for ( int i=0; i<n; i++) {
            for (int j = 0; j < m; j++) {
               if ( vis[i][j] == 0 && res[i][j] == 'O') res[i][j] = 'X';
            }
        }
        return res;
    }

    int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};

    private void dfs(int row, int col, char[][] res, int[][] vis, int n, int m) {
        vis[row][col] = 1;
        for ( int[] dir: dirs){
            int nRow = row+dir[0];
            int nCol = col+dir[1];

            if ( nRow >=0 && nRow <n && nCol >=0 && nCol < m && vis[nRow][nCol] == 0 && res[nRow][nCol] == 'O'){
                res[nRow][nCol] = 'X';
                dfs(nRow, nCol, res, vis, n, m);
            }
        }
    }
}

/*
[ ['X', 'X', 'X', 'X'],
  ['X', 'O', 'O', 'X'],
  ['X', 'X', 'O', 'X'],
  ['X', 'O', 'X', 'X'] ]
 */
