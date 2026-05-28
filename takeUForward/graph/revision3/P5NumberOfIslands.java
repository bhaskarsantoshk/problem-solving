package takeUForward.graph.revision3;

public class P5NumberOfIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( !vis[i][j] && grid[i][j] == '1'){
                    dfs(i,j, grid, vis, n, m);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j, char[][] grid, boolean[][] vis, int n, int m) {
        if ( i <0 || i>=n || j<0 || j>=m || grid[i][j] == '0' || vis[i][j]) return;
        vis[i][j] = true;
        for ( int dr=-1; dr<=1; dr++){
            for ( int dc=-1; dc<=1; dc++){
                dfs(i+dr, j+dc, grid, vis, n, m);
            }
        }
    }
}
