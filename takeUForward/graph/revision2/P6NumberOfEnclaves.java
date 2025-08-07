package takeUForward.graph.revision2;

import java.util.LinkedList;
import java.util.Queue;

public class P6NumberOfEnclaves {
    public int numberOfEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( i == 0 || i == n-1 || j == 0 || j == m-1) {
                    if ( grid[i][j] == 1) q.offer(new int[]{i,j});
                }
            }
        }
        int [][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        while (!q.isEmpty()){
            int [] node = q.poll();
            for ( int []dir: dirs){
                int nRow = node[0] + dir[0];
                int nCol = node[1] + dir[1];
                if ( nRow >= 0 && nRow < n && nCol >=0 && nCol < m && grid[nRow][nCol] == 1 && !vis[nRow][nCol]){
                    vis[nRow][nCol] = true;
                    q.offer(new int[]{nRow, nCol});
                }
            }
        }
        int numEnclaves = 0;
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( i!=0 && i!= n-1 && j!=0 && j!= m-1 && grid[i][j] == 1 && !vis[i][j]){
                    numEnclaves++;
                }
            }
        }
        return numEnclaves;
    }
}
