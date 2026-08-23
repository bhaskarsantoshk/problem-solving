package takeUForward.graph.revision4;

public class G12NumberOfislands {
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( grid[i][j] == '1'){
                    dfs(i,j, grid, vis);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }

    private void dfs(int row, int col, char[][] grid, boolean[][] vis) {
        vis[row][col] = true;
        for ( int []dir: dirs){
            int nRow = row + dir[0];
            int nCol = col + dir[1];
            if ( nRow >= 0 && nRow < grid.length && nCol >=0 && nCol < grid[0].length && !vis[nRow][nCol] && grid[nRow][nCol] == '1'){
                dfs(nRow, nCol, grid, vis);
            }
        }
    }

    int [][] dirs = {{-1,-1}, {1,-1}, {-1, 1}, {1, 1}, {1,0}, {0,1}, {-1,0}, {0,-1}};

}
