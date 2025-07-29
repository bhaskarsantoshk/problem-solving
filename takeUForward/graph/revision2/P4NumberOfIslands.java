package takeUForward.graph.revision2;

public class P4NumberOfIslands {
    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int numIslands = 0;
        for (int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( grid[i][j]== '1' && !vis[i][j]) {
                    dfs(i,j, grid, vis);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }
    int [][] dirs = {{1,0},{0,1}, {-1,0}, {0,-1}, {1,1}, {1,-1}, {-1,1}, {-1,-1}};
    private void dfs(int row, int col, char[][] grid, boolean[][] vis) {
        vis[row][col] = true;
        for ( int[] dir : dirs){
            int nRow = row+dir[0];
            int nCol = col+ dir[1];
            if ( nRow >=0 && nRow < grid.length
                    && nCol >=0 && nCol < grid[0].length && !vis[nRow][nCol] && grid[nRow][nCol] == '1'){
                dfs(nRow, nCol, grid, vis);
            }
        }
    }
}
