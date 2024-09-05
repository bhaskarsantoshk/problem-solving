package takeUForward.graph;

import java.util.LinkedList;
import java.util.Queue;

public class G10RottenOranges {
    int[][] dirs = {{0,1}, {1,0}, {-1,0},{0,-1}};

    //Function to find minimum time required to rot all oranges.
    public int orangesRotting(int[][] grid)
    {
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length, m = grid[0].length;
        int fresh = 0;
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( grid[i][j] == 2){
                    q.offer(new int[]{i, j, 0});
                } else if ( grid[i][j] == 1) fresh++;
            }
        }

        int rotten =0;
        int max = 0;
        while ( !q.isEmpty()){
            int size = q.size();
            for ( int i=0; i<size ; i++){
                int[] orange = q.poll();
                max = Math.max(max, orange[2]);
                for ( int [] dir: dirs){
                    int row = orange[0]+dir[0];
                    int col = orange[1]+dir[1];
                    if ( row >=0 && row<n && col >=0 && col < m && grid[row][col] == 1){
                        grid[row][col] = 2;
                        q.offer(new int[]{row, col, orange[2]+1});
                        rotten++;
                    }
                }
            }
        }
        return (fresh == rotten) ? max: -1;
    }
}
