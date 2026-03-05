package company.apple;

public class P28NumberOfIslands {
    public int numIslands(char[][] grid) {
        int n= grid.length;
        int m = grid[0].length;
        int numIslands = 0;
        boolean[][] vis = new boolean[n][m];
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( !vis[i][j] && grid[i][j] == '1'){
                    dfs(grid, i, j, vis, n, m);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }

    int[][] dirs = {{-1,0}, {0,-1}, {1,0}, {0,1}};

    private void dfs(char[][] grid, int row, int col, boolean[][] vis, int n, int m) {
        vis[row][col] = true;
        for ( int[] dir: dirs){
            int nRow = row+ dir[0];
            int nCol = col + dir[1];
            if ( nRow >=0 && nRow < n && nCol >=0 && nCol < m && grid[nRow][nCol] == '1' && !vis[nRow][nCol]){
                dfs(grid, nRow, nCol, vis, n, m);
            }
        }
    }
}
