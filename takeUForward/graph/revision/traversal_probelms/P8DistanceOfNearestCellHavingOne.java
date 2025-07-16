package takeUForward.graph.revision.traversal_probelms;

import java.util.LinkedList;
import java.util.Queue;

public class P8DistanceOfNearestCellHavingOne {

    int [][] dirs = {{0,-1}, {-1,0}, {0,1}, {1,0}};

    public int[][] nearest(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int [][] vis = new int[n][m];
        int [][] dis = new int[n][m];

        Queue<int[]> queue= new LinkedList<>(); // int[] - row, col, steps
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( grid[i][j] == 1){
                    vis[i][j] = 1;
                    queue.offer(new int[]{i,j,0});
                }
            }
        }

        while (!queue.isEmpty()){
            int [] cell = queue.poll();
            int steps = cell[2];
            int row = cell[0];
            int col = cell[1];
            dis[row][col] = steps;
            for ( int[]dir : dirs){
                int nRow = row+dir[0];
                int nCol = col+dir[1];

                if ( nRow >= 0 && nRow < n && nCol >=0 && nCol < m && vis[nRow][nCol] == 0){
                    vis[nRow][nCol] = 1;
                    queue.offer(new int[]{nRow, nCol, steps+1});
                }
            }
        }
        return dis;
    }
}
