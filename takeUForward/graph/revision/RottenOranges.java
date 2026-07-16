package takeUForward.graph.revision;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;
        int n = grid.length, m = grid[0].length;
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( grid[i][j] == 2){
                    queue.offer(new int[]{i, j, 0});
                } else if ( grid[i][j] == 1) freshOranges++;
            }
        }

        int [][] oranges = new int[n][m];
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                oranges[i][j] = grid[i][j];
            }
        }

        int [][] dirs = {{-1,0}, {0,-1}, {1,0}, {0,1}};

        int maxSteps = 0;
        while (!queue.isEmpty()){
            int []orange = queue.poll();
            int row = orange[0];
            int col = orange[1];
            int steps = orange[2];
            maxSteps = Math.max(steps, maxSteps);

            for ( int [] dir: dirs){
                int nRow = row + dir[0];
                int nCol = col + dir[1];

                if ( nRow >= 0 && nRow < n && nCol >=0 && nCol < m && oranges[nRow][nCol] == 1){
                    oranges[nRow][nCol] = 2;
                    queue.offer(new int[]{nRow, nCol, steps+1});
                    freshOranges--;
                }
            }
        }

        return (freshOranges == 0) ? maxSteps: -1;
    }
}
