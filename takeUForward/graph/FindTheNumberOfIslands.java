package takeUForward.graph;

import java.util.LinkedList;
import java.util.Queue;

public class FindTheNumberOfIslands {
    public int numIslands(char[][] grid) {
       int numOfIslands = 0;
       int n = grid.length;
       int m = grid[0].length;
       boolean[][] vis = new boolean[n][m];
       for ( int row = 0; row <n; row++ ){
           for ( int col =0; col <m; col++){
               if ( !vis[row][col] && grid[row][col] == '1'){
                   numOfIslands++;
                   bfs(row, col, vis, grid, n, m);
               }
           }
       }
       return numOfIslands;
    }

    private int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}, {1,1}, {-1,-1}, {1,-1}, {-1,1}};
    private void bfs(int row, int col, boolean[][] vis, char[][] grid, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        vis[row][col] = true;

        while ( !queue.isEmpty()){
            int[] cell = queue.poll();
            for ( int[] dir : dirs){
                int newRow = cell[0]+dir[0];
                int newCol = cell[1]+dir[1];
                if ( newRow >=0 && newRow <n && newCol >=0 && newCol <m
                        && !vis[newRow][newCol] &&grid[newRow][newCol] != '0'){
                    vis[newRow][newCol] = true;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
    }
}
