package takeUForward.graph.revision.traversal_probelms;

import java.util.LinkedList;
import java.util.Queue;

public class P7RottenOranges {
    int[][] dirs = {{-1,0}, {0,-1}, {1,0}, {0,1}};
    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] data = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                data[i][j] = grid[i][j];
                if ( data[i][j] == 2) queue.offer(new int[]{i,j, 0});
                if ( data[i][j] == 1 ) freshOranges++;
            }
        }

        int time = 0;
        while ( !queue.isEmpty()){
            int[] orange = queue.poll();
            time = Math.max( time, orange[2]);
            for ( int [] dir: dirs){
                int nRow = orange[0]+dir[0];
                int nCol = orange[1]+dir[1];
                if ( nRow >=0 && nRow < n && nCol >=0 && nCol < m && data[nRow][nCol] == 1){
                    data[nRow][nCol] = 2;
                    freshOranges--;
                    queue.offer(new int[]{nRow, nCol, orange[2]+1});
                }
            }
        }
        return freshOranges == 0 ? time:-1;
    }
}
