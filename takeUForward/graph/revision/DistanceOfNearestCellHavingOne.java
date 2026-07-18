package takeUForward.graph.revision;

import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestCellHavingOne {
    public int[][] nearest(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] distance = new int[n][m];

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( grid[i][j] == 1){
                    vis[i][j] = true;
                    queue.offer(new int[]{i,j,0});
                }
            }
        }

        int [][] dirs = {{-1,0}, {0,-1}, {1,0}, {0,1}};

        while (!queue.isEmpty()){
            int [] nodeArr = queue.poll();
            int row = nodeArr[0], col = nodeArr[1], dist = nodeArr[2];
            for ( int []dir: dirs){
                int nRow = row + dir[0], nCol = col + dir[1];
                if ( nRow >= 0 && nRow < n && nCol >=0 && nCol < m && !vis[nRow][nCol] ){
                    queue.offer(new int[]{nRow, nCol, dist+1});
                    vis[nRow][nCol] = true;
                    distance[nRow][nCol] = dist+1;
                }
            }
        }

        return distance;
    }
}
