package takeUForward.graph.revision4;

import java.util.LinkedList;
import java.util.Queue;

public class G4RottenOranges {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int n = grid.length, m = grid[0].length;
        int freshOranges = 0;
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( grid[i][j] == 1) freshOranges++;
                else if ( grid[i][j] == 2) queue.offer(new int[]{i,j, 0});
            }
        }
        int [][] dirs = {{-1,0}, {0,-1}, {1,0}, {0,1}};
        int maxSteps = 0;
        while(!queue.isEmpty()){
            int orange[] = queue.poll();
            int row = orange[0], col = orange[1], steps = orange[2];
            maxSteps = Math.max(maxSteps, steps);

            for ( int[] dir: dirs){
                int nRow = row + dir[0];
                int nCol = col + dir[1];
                if ( nRow >= 0 && nRow < n && nCol >=0 && nCol < m && grid[nRow][nCol] == 1){
                    freshOranges--;
                    queue.offer(new int[]{nRow, nCol, steps+1});
                }
            }
        }

        return freshOranges==0 ? maxSteps: -1;
    }
}
