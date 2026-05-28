package takeUForward.graph.revision3;

import java.sql.NClob;
import java.util.LinkedList;
import java.util.Queue;

public class P12NumberOfEnclaves {
    public int numberOfEnclaves(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();

        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( ( i == 0 || i == n-1 || j==0 || j== m-1 ) &&  !vis[i][j] && grid[i][j] == 1){
                    queue.offer(new int[]{i,j});
                    vis[i][j] = true;
                }
            }
        }

        int[][] dirs = {{-1,0}, {0,-1}, {1,0}, {0,1}};

        while (!queue.isEmpty()){
            int[] node = queue.poll();
            for ( int[] dir: dirs){
                int nRow = node[0] + dir[0];
                int nCol = node[1] + dir[1];
                if ( nRow >= 0 && nRow <n && nCol >=0 && nCol <m && !vis[nRow][nCol] && grid[nRow][nCol]== 1){
                    vis[nRow][nCol] = true;
                    queue.offer(new int[]{nRow, nCol});
                }
            }
        }

        int count = 0;
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( !vis[i][j] && grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }
}
