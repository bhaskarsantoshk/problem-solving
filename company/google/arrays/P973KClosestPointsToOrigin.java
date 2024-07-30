package company.google.arrays;

import java.util.PriorityQueue;

public class P973KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x,y)-> (y[0]*y[0]+y[1]*y[1] -x[0]*x[0]-x[1]*x[1]));
        for (int []point: points){
            maxHeap.offer(point);
            if ( maxHeap.size() > k) maxHeap.poll();
        }
        int [][] res = new int[k][2];
        for ( int i=0; i<k; i++){
            res[i] = maxHeap.poll();
        }
        return res;
    }
}
