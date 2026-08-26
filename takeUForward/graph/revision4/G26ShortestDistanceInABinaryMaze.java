package takeUForward.graph.revision4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class G26ShortestDistanceInABinaryMaze {
    int shortestPath(int[][] grid, int[] source, int[] destination) {
        if (grid[source[0]][source[1]] == 0 || grid[destination[0]][destination[1]] == 0) return -1;
        int n = grid.length, m = grid[0].length;
        int[][] distance = new int[n][m];
        for ( int i=0; i<n; i++) Arrays.fill(distance[i], (int)1e9);

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, source[0], source[1]});
        distance[source[0]][source[1]] = 0;
        int [][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        while (!queue.isEmpty()){
            int[] nodeArr = queue.poll();
            int dist = nodeArr[0];
            int row = nodeArr[1];
            int col = nodeArr[2];

            if ( row == destination[0] && col == destination[1]) return dist;

            for (int[] dir: dirs){
                int nRow = row+ dir[0];
                int nCol = col + dir[1];
                if ( nRow >=0 && nRow < n && nCol >=0 && nCol < m && grid[nRow][nCol] == 1 && distance[nRow][nCol] > dist + 1 ){
                    queue.offer(new int[]{dist+1, nRow, nCol});
                    distance[nRow][nCol] = dist + 1;
                }
            }
        }
        return -1;
    }
}
