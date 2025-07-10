package takeUForward.graph.revision.traversal_probelms;

public class P4NumberOfIslands {

    int[][] dirs = {{-1,0}, {1,0},{0,-1},{0,1},{-1,-1}, {1,1}, {1,-1}, {-1,1} };
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int numIslands = 0;

        for ( int row=0; row<n; row++){
            for ( int col=0; col < m; col++){
                if ( !vis[row][col] && grid[row][col] == '1'){
                    dfs(grid, vis, row, col);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }

    private void dfs(char[][] grid, boolean[][] vis, int row, int col) {
        if ( row < 0 || row >=grid.length || col < 0 || col >= grid[0].length
                || vis[row][col] || grid[row][col] == '0') return;
        vis[row][col] = true;
        for ( int[] dir: dirs){
            int newRow = row+ dir[0];
            int newCol = col+ dir[1];
            dfs(grid, vis, newRow, newCol);
        }
    }
}
