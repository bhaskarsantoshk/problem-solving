package takeUForward.graph.traversals;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIslands {
    public int countDistinctIslands(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Set<String> set = new HashSet<>();

        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( !vis[i][j] && grid[i][j] == 1){
                    StringBuffer sb = new StringBuffer();
                    dfs(i,j, grid, vis, i, j, n, m, sb);
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }

    int [][] dirs = {{-1,0}, {0,-1}, {1,0}, {0,1}};

    private void dfs(int row, int col, int[][] grid, boolean[][] vis, int row0, int col0, int n, int m, StringBuffer sb) {
        sb.append((row0-row)+" "+(col0-col));
        vis[row][col] = true;
        for ( int []dir: dirs){
            int nRow = row+dir[0];
            int nCol = col+dir[1];

            if ( nRow >=0 && nRow < n && nCol>=0 && nCol < m && !vis[nRow][nCol] && grid[nRow][nCol] == 1){
                dfs(nRow, nCol, grid, vis, row0, col0, n, m, sb);
            }
        }
    }
}
