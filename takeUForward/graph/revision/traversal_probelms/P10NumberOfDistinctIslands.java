package takeUForward.graph.revision.traversal_probelms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P10NumberOfDistinctIslands {
    public int countDistinctIslands(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] vis = new int[n][m];
        Set<List<String>> distinctIslands = new HashSet<>();
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( vis[i][j] == 0 && grid[i][j] == 1){
                    List<String> island = new ArrayList<>();
                    dfs(i,j, vis, grid, island, n, m, i, j);
                    distinctIslands.add(island);
                }
            }
        }
        return distinctIslands.size();
    }

    int [][] dirs = {{-1,0}, {0,1}, {1,0}, {0,-1}};

    private void dfs(int row, int col, int[][] vis, int[][] grid, List<String> island, int n, int m, int baseRow, int baseCol) {
        vis[row][col] = 1;
        island.add((row-baseRow) +":"+ (col-baseCol));
        for ( int [] dir : dirs){
            int nRow = row+ dir[0];
            int nCol = col+ dir[1];

            if ( nRow >=0 && nRow<n && nCol >=0 && nCol <m && vis[nRow][nCol] == 0 && grid[nRow][nCol] == 1){
                dfs(nRow, nCol, vis, grid, island, n, m, baseRow, baseCol);
            }
        }
    }
}
