package takeUForward.graph.revision4;

import java.sql.NClob;
import java.util.*;

public class G27PathWithMinimumEffort {
    public int MinimumEffort(List<List<Integer>> heights) {
        int n = heights.size(), m = heights.get(0).size();
        int [][] distance = new int[n][m];
        for ( int i=0; i<n; i++) Arrays.fill(distance[i], (int)1e9);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        pq.offer(new int[]{0, 0, 0});
        int [][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        while (!pq.isEmpty()){
            int [] nodeArr = pq.poll();
            int diff = nodeArr[0];
            int row = nodeArr[1];
            int col = nodeArr[2];
            if ( row == n-1 && col == m-1) return diff;
            for ( int [] dir: dirs){
                int nRow = row + dir[0];
                int nCol = col+ dir[1];
                if ( nRow >=0 && nRow < n && nCol >=0 && nCol < m ){
                    int newEffort = Math.max(diff, Math.abs(heights.get(nRow).get(nCol) - heights.get(row).get(col)));
                    if ( newEffort < distance[nRow][nCol]) {
                        distance[nRow][nCol] = newEffort;
                        pq.offer(new int[]{newEffort, nRow, nCol});
                    }
                }
            }
        }
        return 0;
    }
}
