package company.google.trees_and_graphs;

public class P200NumberOfIslands {
    public int numIslands(char[][] grid) {
        int[][] vis = new int[grid.length][grid[0].length];
        int numOfIslands = 0;
        for ( int i=0; i<grid.length; i++){
            for ( int j=0; j<grid[0].length; j++){
                if ( vis[i][j] != 1 && grid[i][j] == '1'){
                    dfs(grid, vis, i, j);
                    numOfIslands++;
                }
            }
        }
        return numOfIslands;
    }

    private void dfs(char[][] grid, int[][] vis, int i, int j) {
        if ( i<0 || i>= grid.length || j<0 || j >= grid[0].length || vis[i][j] == 1 || grid[i][j] == '0' ) return;
        vis[i][j] = 1;
        int [][] dirs = {{1,0}, {0,1}, {-1, 0}, {0,-1}};
        for ( int[] dir: dirs){
            dfs(grid, vis, i+dir[0], j+dir[1]);
        }
    }
}
