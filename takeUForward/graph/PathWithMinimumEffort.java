package takeUForward.graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {
    public static int MinimumEffort(int rows, int columns, int[][] heights) {
        int [][] distance = new int[rows][columns];
        for ( int[] row: distance) Arrays.fill(row, (int)1e9);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]); // dist, row, col - Create a Node class
        distance[0][0] = 0;
        int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        pq.offer(new int[]{0, 0, 0});
        while ( !pq.isEmpty()){
            int[] cell = pq.poll();
            int diff = cell[0];
            int row = cell[1];
            int col = cell[2];
            for ( int [] dir : dirs){
                int nRow = row+dir[0];
                int nCol = col+dir[1];
                if ( nRow >= 0 && nRow < rows && nCol >=0 && nCol <columns){
                   int newEffort = Math.max ( Math.abs( heights[row][col] - heights[nRow][nCol]), diff);
                   if ( newEffort < distance[nRow][nCol]) {
                       distance[nRow][nCol] = newEffort;
                       pq.offer(new int[]{newEffort, nRow, nCol});
                   }
                }
            }
        }
        return distance[rows-1][columns-1];
    }
}
