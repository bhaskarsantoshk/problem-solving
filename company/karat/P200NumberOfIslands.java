package company.karat;

public class P200NumberOfIslands {
    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int [][] vis = new int[n][m];
        int numIslands = 0;
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( vis[i][j]==0 && grid[i][j] == '1'){
                    dfs(grid, vis, i, j, n, m);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }

    int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};


    private void dfs(char[][] grid, int[][] vis, int row, int col, int n, int m) {
        vis[row][col] = 1;
        for ( int[] dir: dirs){
            int nRow = row+ dir[0];
            int nCol = col+ dir[1];
            if ( nRow >=0 && nRow <n && nCol >=0 && nCol < m && vis[nRow][nCol] == 0 && grid[nRow][nCol] =='1'){
                dfs(grid, vis, nRow, nCol, n, m);
            }
        }
    }
}
