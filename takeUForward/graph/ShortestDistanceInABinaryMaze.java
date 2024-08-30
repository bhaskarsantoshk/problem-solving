package takeUForward.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ShortestDistanceInABinaryMaze {
    int shortestPath(int[][] grid, int[] source, int[] destination) {
        int n = grid.length;
        int m = grid[0].length;
        int [][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        int[][] distance = new int[n][m];
        for ( int [] row: distance) Arrays.fill(row, (int)1e9);
        distance[source[0]][source[1]] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, source[0], source[1]}); // distance, row, col

        while ( !q.isEmpty()){
            int[] cell = q.poll();
            int dist = cell[0];
            int row = cell[1];
            int col = cell[2];
            for ( int[] dir: dirs){
                int nRow = row+ dir[0];
                int nCol = col + dir[1];
                if ( nRow >= 0 && nRow < n && nCol>=0 && nCol < m && grid[nRow][nCol] == 1){
                    if ( dist + 1 < distance[nRow][nCol]) {
                        distance[nRow][nCol] = dist+1;
                        q.offer(new int[]{distance[nRow][nCol], nRow, nCol});
                    }
                }
            }
        }

        int ans = ( distance[destination[0]][destination[1]] == (int) 1e9) ? -1: distance[destination[0]][destination[1]];
        return ans;
    }
}
