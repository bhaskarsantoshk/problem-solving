package takeUForward.graph;

import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestCellHaving1 {
    int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    public int[][] nearest(int[][] grid)
    {
       int n = grid.length, m = grid[0].length;
       int [][] vis = new int[n][m];
       int [][] dis = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
       for ( int i=0; i<n; i++){
           for ( int j=0; j<m; j++){
               if ( grid[i][j] == 1){
                   q.offer(new int[]{i, j, 0});
                   vis[i][j] = 1;
               }
           }
       }
       while(!q.isEmpty()){
           int[] cell = q.poll();
           int row = cell[0];
           int col = cell[1];
           int steps = cell[2];
           dis[row][col] = steps;
           for ( int[] dir : dirs){
               int nrow = row+dir[0];
               int ncol = col+ dir[1];
               if ( nrow >=0 && nrow < n && ncol >=0 && ncol < m && vis[nrow][ncol] == 0 ){
                   vis[nrow][ncol] = 1;
                   q.offer(new int[]{nrow, ncol, steps+1});
               }
           }
       }
       return dis;
    }
}
