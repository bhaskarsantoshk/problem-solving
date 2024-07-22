package company.microsoft.trees;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int[][] vis = new int[grid.length][grid[0].length];
        int count = 0;
        for ( int i=0; i<grid.length; i++){
            for ( int j=0; j<grid[0].length; j++){
                if ( vis[i][j] != 1 && grid[i][j] == '1'){
                    dfs(grid, vis, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int[][] vis, int i, int j) {
        if ( i < 0 || i> grid.length-1 || j <0 || j> grid[0].length-1 || vis[i][j] == 1 || grid[i][j] == '0') return;
        vis[i][j] = 1;
        dfs( grid, vis, i+1, j);
        dfs( grid, vis, i, j+1);
        dfs(grid, vis, i-1, j);
        dfs( grid, vis, i, j-1);
    }
}
