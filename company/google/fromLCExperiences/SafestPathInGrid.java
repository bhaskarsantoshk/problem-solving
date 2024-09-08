package company.google.fromLCExperiences;

// https://leetcode.com/discuss/interview-question/5661556/Google-L5-FE

import java.util.*;

public class SafestPathInGrid {

    // Similar Leetcode question
    // 2812. Find the Safest Path in a Grid
    // https://leetcode.com/problems/find-the-safest-path-in-a-grid

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        // Base cases
        int n = grid.size();
        if ( grid == null || grid.isEmpty() || grid.get(0).get(0)== 1 || grid.get(n-1).get(n-1) == 1){
            return 0;
        }
        int [][] distance = new int[n][n];
        for ( int[] row: distance) Arrays.fill(row, (int)1e9);
        bfs( grid, distance, n);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[0]-a[0]);
        pq.offer(new int[]{distance[0][0], 0, 0});
        boolean[][] vis = new boolean[n][n];

        while (!pq.isEmpty()){
            int[] cell = pq.poll();
            int safety = cell[0];
            int row = cell[1], col = cell[2];
            if ( row == n-1 && col == n-1){
                return safety;
            }
            vis[row][col] = true;

            for ( int [] dir : dirs){
                int nRow = row+ dir[0];
                int nCol = col + dir[1];

                if ( nRow >=0 && nRow < n && nCol>=0 && nCol < n && !vis[nRow][nCol]){
                    int s = Math.min(safety, distance[nRow][nCol]);
                    pq.offer(new int[]{s, nRow, nCol});
                    vis[nRow][nCol] = true;
                }
            }
        }
        return -1;
    }

    private int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};

    private void bfs(List<List<Integer>> grid, int[][] distance, int n) {
        Queue<int[]> q = new LinkedList<>();
        for ( int i=0; i<n; i++){
            for ( int j=0; j<n; j++){
                if ( grid.get(i).get(j) == 1) {
                    distance[i][j] = 0;
                    q.offer(new int[]{i,j});
                }
            }
        }

        while ( !q.isEmpty()){
            int[] cell = q.poll();
            int dist = distance[cell[0]][cell[1]];
            for ( int[] dir: dirs){
                int nRow = cell[0]+dir[0];
                int nCol = cell[1] + dir[1];

                if ( nRow >= 0 && nRow < n && nCol >=0 && nCol < n && distance[nRow][nCol] > 1 + dist){
                    distance[nRow][nCol] = 1+dist;
                    q.offer(new int[]{nRow, nCol});
                }
            }

        }
    }

}
