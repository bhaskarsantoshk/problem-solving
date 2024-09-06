package takeUForward.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class G16NumberOfDistinctIslandsConstructiveThinkingDFS {

    int countDistinctIslands(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Set<List<String>> set = new HashSet<>();
        boolean[][] vis = new boolean[n][m];
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( !vis[i][j] && grid[i][j] == 1) {
                    List<String> list = new ArrayList<>();
                    dfs(grid, vis, i, j, i, j, list, n, m);
                    set.add(list);
                }
            }
        }
        return set.size();
    }

    private int[][] dirs = {{1,0}, {0,1}, {0,-1}, {-1,0}};

    private void dfs(int[][] grid, boolean[][] vis, int row, int col, int row0, int col0,
                     List<String> list, int n, int m) {
        vis[row][col] = true;
        list.add(toString(row-row0, col-col0));
        for ( int[] dir: dirs){
            int nrow = row+dir[0];
            int ncol = col+dir[1];
            if ( nrow >= 0 && nrow <n && ncol>=0 && ncol<m && grid[nrow][ncol]==1 && !vis[nrow][ncol]){
                dfs(grid, vis, nrow, ncol, row0, col0, list, n, m);
            }
        }
    }

    private String toString(int i, int j) {
        return i+","+j;
    }
}
