package takeUForward.graph.revision2;

import java.util.LinkedList;
import java.util.Queue;

public class P8DistanceOfNearestCellHavingOne {
    public int[][] nearest(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int [][] dis = new int[n][m];
        boolean [][] vis = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( grid[i][j] == 1){
                    vis[i][j] = true;
                    queue.offer(new int[]{i,j,0});
                }
            }
        }

        int [][] dirs = {{-1,0}, {0,-1}, {0,1}, {1,0}};

        while (!queue.isEmpty()){
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1], steps=cell[2];
            dis[r][c] = steps;
            for ( int[] dir: dirs){
                int row = cell[0] + dir[0];
                int col = cell[1] + dir[1];
                if ( row >= 0 && row < n && col >=0 && col < m && !vis[row][col] ) {
                    vis[row][col] = true;
                    queue.offer(new int[]{row, col, cell[2]+1});
                }
            }
        }
        return dis;
    }
}
