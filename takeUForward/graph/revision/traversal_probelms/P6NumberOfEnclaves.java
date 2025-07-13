package takeUForward.graph.revision.traversal_probelms;

import java.util.LinkedList;
import java.util.Queue;

public class P6NumberOfEnclaves {
    public int numberOfEnclaves(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int [][] vis = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( i==0 ||j ==0 || i==n-1|| j==m-1){
                    if ( grid[i][j] == 1) q.offer(new int[]{i,j});
                }
            }
        }

        int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};

        while ( !q.isEmpty()){
            int [] node = q.poll();
            for ( int dir[]: dirs){
                int newRow = node[0]+dir[0];
                int newCol = node[1]+dir[1];
                if ( newRow >=0 && newRow <n && newCol>=0 && newCol<m &&
                        vis[newRow][newCol] == 0 && grid[newRow][newCol] == 1){
                    vis[newRow][newCol] = 1;
                    q.offer(new int[]{newRow, newCol});
                }
            }
        }

        int numOfEnclaves = 0;

        for(int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( i !=0 && j!=0 && i != n-1 && j != m-1 && grid[i][j] == 1 && vis[i][j] == 0 ){
                    numOfEnclaves++;
                }
            }
        }
        return numOfEnclaves;
    }
}
