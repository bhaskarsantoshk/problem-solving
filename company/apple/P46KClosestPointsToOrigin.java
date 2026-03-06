package company.apple;

import java.util.PriorityQueue;

public class P46KClosestPointsToOrigin {
    // (0,0) -
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (p1,p2) -> Integer.compare(p2[0]*p2[0]+ p2[1]*p2[1] , p1[0]*p1[0]+p1[1]*p1[1])
        );

        for ( int[] point: points){
            pq.offer(point);
            if ( pq.size() > k) pq.poll();
        }

        int[][] res = new int[pq.size()][2];
        int index = 0;
        while (!pq.isEmpty()){
            res[index++] = pq.poll();
        }
        return res;
    }
}
