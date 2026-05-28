package takeUForward.graph.revision3;

import java.util.LinkedList;
import java.util.Queue;

public class P6RottenOranges {
    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( grid[i][j] == 2){
                    queue.offer(new int[]{i,j, 0});
                } else if ( grid[i][j] == 1) freshOranges++;
            }
        }
        int time = 0;

        int[][] dirs = {{-1,0}, {0,-1}, {1,0}, {0,1}};

        while ( !queue.isEmpty()){
            int [] orange = queue.poll();
            time =Math.max(time, orange[2]);

            for ( int[] dir: dirs){
                int row = dir[0]+orange[0];
                int col = dir[1]+orange[1];

                if ( row >=0 && row <n && col >=0 && col <m && grid[row][col] == 1){
                    grid[row][col] = 2;
                    freshOranges--;
                    queue.offer(new int[]{row, col, orange[2]+1});
                }
            }
        }
        if ( freshOranges != 0) return -1;
        return time;
    }

    /*
    BFS from all rotten oranges simultaneously. Time stored in queue. Mark fresh as rotten when pushed. Decrement fresh count. Return -1 if anything remains.

Interview notes:

Time: O(n*m)
Each cell processed once.

Space: O(n*m) worst case queue.
     */
}
