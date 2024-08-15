package takeUForward.graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    private static int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};

    public int orangesRotting(int[][] grid)
    {
        Queue<Orange> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        int rotten = 0;
        int [][] vis = new int[m][n];
        for ( int i=0; i<m; i++){
            for ( int j=0; j<n ; j++){
                if ( grid[i][j] == 2){
                    vis[i][j] = 2;
                    queue.offer(new Orange(i, j, 0));
                } else if ( grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        int time = 0;

        while ( !queue.isEmpty() ){
            Orange rottenOrange = queue.poll();
            time = Math.max(time, rottenOrange.time);
            for ( int[] dir : dirs){
                int newRow = rottenOrange.row+ dir[0];
                int newCol = rottenOrange.col + dir[1];
                if ( newRow >=0 && newRow <m && newCol >=0 && newCol < n
                        && vis[newRow][newCol] == 0 && grid[newRow][newCol] == 1){
                    vis[newRow][newCol] = 2;
                    rotten++;
                    queue.offer(new Orange(newRow, newCol, rottenOrange.time+1));
                }
            }
        }

        return fresh == rotten ? time: -1;
    }

     class Orange{
        int row, col, time;
        Orange( int row, int col, int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
}
