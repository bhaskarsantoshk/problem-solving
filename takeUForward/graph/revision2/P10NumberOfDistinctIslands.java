package takeUForward.graph.revision2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P10NumberOfDistinctIslands {
    public int countDistinctIslands(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Set<List<String>> result = new HashSet<>();
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( grid[i][j] == 1 && !vis[i][j]){
                    List<String> list = new ArrayList<>();
                    dfs(grid, vis, i, j, i, j, result, list);
                    result.add(list);
                }
            }
        }
        return result.size();
    }

    int [][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};

    private void dfs(int[][] grid, boolean[][] vis, int i, int j, int baseRow, int baseCol, Set<List<String>> result, List<String> list) {
        vis[i][j] = true;
        list.add((i-baseRow)+","+(j-baseCol));
        for ( int[] dir: dirs){
            int row = i+dir[0];
            int col = j+ dir[1];
            if ( row >= 0 && row < grid.length && col >=0 && col <grid[0].length
                    && !vis[row][col] && grid[row][col] == 1){
                dfs(grid, vis, row, col, i, j, result, list);
            }
        }
    }
}
