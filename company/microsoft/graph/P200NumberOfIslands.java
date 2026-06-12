package company.microsoft.graph;

public class P200NumberOfIslands {
    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int count = 0;
        for (int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( !vis[i][j] && grid[i][j] == '1') {
                    dfs(i,j, vis, grid, n, m);
                    count++;
                }
            }
        }
        return count;
    }

    private int[][] dirs = {{-1,0}, {0,-1}, {1,0}, {0,1}};

    private void dfs(int row, int col, boolean[][] vis, char[][] grid, int n, int m){
        vis[row][col] = true;

        for ( int[]dir: dirs){
            int nRow = row + dir[0];
            int nCol = col + dir[1];

            if ( nRow >=0 && nRow < n && nCol >=0 && nCol < m && grid[nRow][nCol] == '1' && !vis[nRow][nCol]){
                dfs(nRow, nCol, vis, grid, n, m);
            }
        }
    }
}
