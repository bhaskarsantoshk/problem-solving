package company.google;

import java.util.HashSet;
import java.util.Set;

public class P694NumberOfDistinctIslands {
    public int numDistinctIslands(int[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        Set<String> set = new HashSet<>();
        int ans = 0;
        for ( int i=0; i<grid.length; i++){
            for ( int j=0; j< grid[0].length; j++){
                if (!vis[i][j] && grid[i][j] == 1){
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, vis, i, j, 0, 0, sb);
                    String s = sb.toString();
                    if (!set.contains(s)) {
                        ans++;
                        set.add(s);
                    }
                }
            }
        }
        return ans;
    }

    private int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};

    private void dfs(int[][] grid, boolean[][] vis, int i, int j, int xpos, int ypos, StringBuilder sb) {
        vis[i][j] = true;
        sb.append(xpos+" "+ypos);
        for ( int[] dir: dirs){
            int x = i+dir[0];
            int y = j+dir[1];
            if ( x < 0 || x >=grid.length || y < 0 || y>=grid[0].length || grid[x][y] == 0 || vis[x][y]) continue;
            dfs(grid, vis, x, y, xpos+dir[0], ypos+dir[1], sb);
        }
    }
}
