package takeUForward.graph.traversals;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];

        int count = 0;
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( !vis[i][j] && grid[i][j] == '1'){
                    dfs(grid, i, j, vis);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j, boolean[][] vis) {
        if ( i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0' || vis[i][j]) return;
        vis[i][j] = true;
        for ( int dr=-1; dr<=1; dr++){
            for ( int dc=-1; dc <= 1; dc++ ){
                dfs(grid, i+dr, j+dc, vis);
            }
        }
    }
}
