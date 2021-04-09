class P695MaxAreaofIsland{
  
  public int maxAreaOfIsland(int[][] grid) {
        if ( grid == null || grid.length == 0){
            return 0;
        }
        int maxArea = 0;
        for ( int i=0; i<grid.length; i++){
            for ( int j=0; j<grid[0].length ; j++){
                if ( grid[i][j] == 1) maxArea = Math.max(maxArea , maxAreaOfIsland(grid, i, j));
            }
        }
        return maxArea;
    }
    
    
    private static int maxAreaOfIsland(int[][] grid, int i, int j){
        if (i >= 0 && i< grid.length && j>=0 && j < grid[0].length && grid[i][j] == 1){
        grid[i][j] = 0;
        return 1+ maxAreaOfIsland(grid, i+1, j) + maxAreaOfIsland(grid, i, j+1) + maxAreaOfIsland(grid, i-1,j)+ maxAreaOfIsland(grid, i, j-1);
        }
        return 0;
    }
  
}
