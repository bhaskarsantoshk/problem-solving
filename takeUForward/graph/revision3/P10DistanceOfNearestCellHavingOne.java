package takeUForward.graph.revision3;

import java.util.LinkedList;
import java.util.Queue;

public class P10DistanceOfNearestCellHavingOne {
    public int[][] nearest(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] distance = new int[n][m];
        boolean[][] vis = new boolean[n][m];

        Queue<int[]> queue = new LinkedList<>();
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( grid[i][j] == 1){
                    queue.offer(new int[]{i,j, 0});
                    vis[i][j] = true;
                }
            }
        }

        int[][] dirs = {{-1,0}, {0,-1}, {1,0}, {0,1}};

        while ( !queue.isEmpty()){
            int[] node = queue.poll();
            for ( int []dir: dirs){
                int row = node[0]+dir[0];
                int col = node[1] + dir[1];
                if ( row >=0 && row < n && col >=0 && col < m && !vis[row][col] && grid[row][col] == 0){
                    queue.offer(new int[]{row, col, node[2]+1});
                    distance[row][col] = node[2]+1;
                    vis[row][col] = true;
                }
            }
        }
        return distance;
    }

    /*
    * Push all 1s into queue with distance 0.
* Mark them visited.
* BFS expands level by level.
* First time a 0 is reached = shortest distance from any 1.

Time: O(n*m)
Space: O(n*m)
     */
}
