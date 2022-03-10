package company.amazon.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class P973KClosestPointsToOrigin {
    public int[][] kClosestSolution1(int[][] points, int k) {
        // Sorting based on distance from origin
        Arrays.sort(points, (x,y)-> x[0]*x[0] + x[1]*x[1] - y[0]*y[0] - y[1]*y[1]);
        return Arrays.copyOfRange(points, 0, k);
    }

    public int[][] kClosest(int[][] points, int k) {
        // Max Heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y)->(y[0]*y[0] + y[1]* y[1] - x[0]*x[0] - x[1]*x[1]));
        for ( int [] point: points){
            pq.offer(point);
            if ( pq.size() > k){
                pq.poll();
            }
        }
        int [][] res = new int[k][2];
        for ( int i=0; i<k; i++){
            res[i]= pq.poll();
        }
        return res;
    }

}
