package takeUForward.graph.revision2;

import java.util.LinkedList;
import java.util.Queue;

public class P7RottenOranges {
    int [][] dirs = {{0,-1}, {-1,0}, {1,0}, {0,1}};
    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int freshOranges = 0;
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( grid[i][j] == 2) q.offer(new int[]{i,j,0});
                else if ( grid[i][j] == 1) freshOranges++;
            }
        }
        int time = 0;
        while (!q.isEmpty()){
            int [] orange = q.poll();
            time = Math.max(time, orange[2]);
            for ( int[] dir: dirs){
                int row = orange[0] + dir[0];
                int col = orange[1] + dir[1];
                if ( row >= 0 && row < n && col >=0 && col < m && grid[row][col] == 1){
                    freshOranges--;
                    grid[row][col] = 2;
                    q.offer(new int[]{row, col, orange[2]+1});
                }
            }
        }
        return freshOranges == 0 ? time: -1;
    }
}
