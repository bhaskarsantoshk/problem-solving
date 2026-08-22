package takeUForward.graph.revision4;

public class G10NumberOfEnclaves {
    public int numberOfEnclaves(int[][] grid) {
        int n = grid.length , m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( (i==0 || i==n-1 || j == 0 || j==m-1) && grid[i][j] == 1){
                   dfs(i, j, grid,vis);
                }
            }
        }
        int numEnclaves = 0;
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if (!vis[i][j] && grid[i][j] == 1) numEnclaves++;
            }
        }
        return numEnclaves;
    }

    int [][] dirs = {{-1,0}, {0,-1}, {1,0}, {0,1}};

    private void dfs(int row, int col, int[][] grid, boolean[][] vis) {
        vis[row][col] = true;
        for ( int [] dir: dirs){
            int nRow = row+dir[0];
            int nCol = col+dir[1];
            if ( nRow >=0 && nRow < grid.length && nCol >=0 && nCol < grid[0].length && !vis[nRow][nCol] && grid[nRow][nCol] == 1){
                dfs(nRow, nCol, grid, vis);
            }
        }
    }
}
