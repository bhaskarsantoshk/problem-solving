package takeUForward.graph.traversals;

import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestCellHavingOne {
    public int[][] nearest(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] res = new int[n][m];
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

        int[][] dirs = { {-1,0}, {0,-1}, {1,0}, {0,1}};

        while ( !queue.isEmpty()){
            int[] node = queue.poll();
            for ( int []dir: dirs){
                int nRow = node[0]+dir[0];
                int nCol = node[1] + dir[1];
                if ( nRow >=0 && nRow <n && nCol >=0 && nCol <m && !vis[nRow][nCol] && grid[nRow][nCol] == 0){
                    res[nRow][nCol] = node[2]+1;
                    vis[nRow][nCol] = true;
                    queue.offer(new int[]{nRow, nCol, res[nRow][nCol]});
                }
            }
        }
        return res;
    }
}
