package takeUForward.graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {
    int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
    int numberOfEnclaves(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] vis = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( ( i==0 || i == n-1 || j==0 || j==m-1 ) && (grid[i][j] == 1 && vis[i][j] == 0)){
                    vis[i][j] = 1;
                    q.offer(new int[]{i, j});
                }
            }
        }

        while ( !q.isEmpty()){
            int []cell = q.poll();
            for ( int dir[]:dirs){
                int nrow = cell[0]+dir[0];
                int ncol = cell[1]+dir[1];
                if ( nrow >=0 && nrow <n && ncol >=0 && ncol <m
                        && grid[nrow][ncol] == 1 && vis[nrow][ncol] == 0){
                    q.offer(new int[]{nrow, ncol});
                    vis[nrow][ncol] = 1;
                }
            }
        }

        int count =0;
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( grid[i][j] == 1 && vis[i][j] == 0) count++;
            }
        }
        return count;
    }
}
