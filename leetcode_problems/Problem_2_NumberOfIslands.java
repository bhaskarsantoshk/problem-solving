package leetcode_problems;

public class Problem_2_NumberOfIslands {
    public int numIslands(char[][] grid) {
        if ( grid == null || grid.length == 0){
            return 0;
        }
        int count = 0;
        for ( int i=0; i<grid.length; i++){
            for ( int j=0; j<grid[i].length; j++){
                if ( grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if ( i<0 || i>= grid.length || j<0 || j>= grid[i].length || grid[i][j] != '1'){
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i+1, j);
        dfs(grid, i, j+1);
        dfs(grid, i-1, j);
        dfs(grid, i, j-1);
    }
}
