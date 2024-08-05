package company.google;

import java.util.LinkedList;
import java.util.Queue;

public class P994RottingOranges {
    int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        int time = 0;
        int m = grid.length, n= grid[0].length;
        for ( int i=0; i<grid.length; i++){
            for ( int j=0; j< grid[0].length ; j++){
                if ( grid[i][j] == 1) fresh++;
                if ( grid[i][j] == 2 ) queue.offer(new int[]{i,j});
            }
        }

        while ( !queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            for ( int i=0; i<size; i++){
                int[] cell = queue.poll();
                for ( int dir[] : dirs){
                    int row = cell[0]+ dir[0];
                    int col = cell[1]+ dir[1];

                    if ( row < 0 || row >= m || col <0 || col>= n || grid[row][col] != 1) continue;
                    grid[row][col] = 2;
                    fresh--;
                    queue.offer(new int[]{row,col});
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}
