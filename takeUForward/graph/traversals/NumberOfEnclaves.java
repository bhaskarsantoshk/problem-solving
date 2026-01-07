package takeUForward.graph.traversals;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {
    public int numberOfEnclaves(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( i==0 || j==0 || i==n-1 || j == m-1){
                    if ( grid[i][j] == 1) {
                        queue.add(new int[]{i,j});
                        vis[i][j] = true;
                    }
                }
            }
        }
        int [][] dirs = {{-1,0}, {0,-1}, {1,0}, {0,1}};
        while ( !queue.isEmpty()){
            int [] node = queue.poll();
            for ( int[] dir : dirs){
                int newRow = node[0]+ dir[0];
                int newCol = node[1]+ dir[1];

                if ( newRow >= 0 & newRow <n && newCol >=0 && newCol<m && grid[newRow][newCol]==1 && !vis[newRow][newCol]){
                    vis[newRow][newCol] = true;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
        int count = 0;
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( grid[i][j] == 1 && !vis[i][j]) count++;
            }
        }
        return count;
    }
}
