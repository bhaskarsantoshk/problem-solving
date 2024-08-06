package company.google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfDistinctIslands {
    // intuition
    // follow the same order
    // use base as origin

    int[][] dirs = {{0,1}, {1,0}, {0,-1},{-1,0}};

    int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int [][] vis = new int[n][m];
        Set<List<String>> set = new HashSet<>();
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( vis[i][j] == 0 && grid[i][j] == 1){
                    List<String> list = new ArrayList<>();
                    dfs(i, j, grid, vis, i, j, list, set);
                    set.add(list);
                }
            }
        }
        return set.size();
    }

    private void dfs(int row, int col, int[][] grid, int[][] vis, int row0, int col0, List<String> list, Set<List<String>> set) {
        vis[row][col] = 1;
        list.add(toString(row-row0, col-col0));
        for ( int[] dir: dirs){
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if ( newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length || vis[newRow][newCol] == 1 || grid[newRow][newCol] == 0) continue;
            dfs(newRow, newCol, grid, vis, row0, col0, list, set);
        }

    }

    private String toString(int i, int j) {
        return String.valueOf(i)+" "+String.valueOf(j);
    }
}
