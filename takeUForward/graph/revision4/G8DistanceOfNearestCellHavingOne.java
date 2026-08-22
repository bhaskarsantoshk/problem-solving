package takeUForward.graph.revision4;

import java.util.LinkedList;
import java.util.Queue;

public class G8DistanceOfNearestCellHavingOne {
    public int[][] nearest(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] distance = new int[n][m];
        boolean[][] vis = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( grid[i][j] == 1){
                    vis[i][j] = true;
                    queue.offer(new int[]{i,j, 0});
                }
            }
        }

        int[][] dirs = {{-1,0}, {0,-1}, {1,0}, {0,1}};

        while (!queue.isEmpty()){
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1], steps=cell[2];
            for ( int[] dir: dirs){
                int nRow = row+dir[0];
                int nCol = col+dir[1];
                if ( nRow >= 0 && nRow < n && nCol >=0 && nCol < m && !vis[nRow][nCol]){
                    vis[nRow][nCol] = true;
                    queue.offer(new int[]{nRow, nCol, steps+1});
                    distance[nRow][nCol] = steps+1;
                }
            }
        }

        return distance;
    }
}
