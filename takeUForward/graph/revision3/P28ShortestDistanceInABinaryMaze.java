package takeUForward.graph.revision3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P28ShortestDistanceInABinaryMaze {
    int shortestPath(int[][] grid, int[] source, int[] destination) {
        if ( source[0] == destination[0] && source[1] == destination[1]) return 0;
        int n = grid.length, m = grid[0].length;
        int[][] distance = new int[n][m];
        for ( int i=0; i<n; i++) Arrays.fill(distance[i], (int)1e9);
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, source[0], source[1]}); // distance, i, j
        distance[source[0]][source[1]] = 0;
        int [][]dirs = {{-1,0}, {0,-1}, {1,0}, {0,1}};
        while ( !queue.isEmpty()){
            int[] node = queue.poll();
            int dist = node[0];
            for ( int []dir: dirs){
                int row = node[1]+dir[0];
                int col = node[2] + dir[1];
                if ( row >=0 && row <n && col >=0 && col < m && grid[row][col] == 1 && distance[row][col] > 1+dist){
                    distance[row][col] = 1 + dist;
                    if ( row == destination[0] && col == destination[1]) return dist+1;
                    queue.offer(new int[]{dist+1, row, col});
                }
            }
        }
        return -1;
    }
}
