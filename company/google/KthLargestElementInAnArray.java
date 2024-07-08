package company.google;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b-a);
        for ( int num: nums){
            pq.offer(num);
        }

        while ( k-- > 1){
            pq.poll();
        }
        return pq.poll();
    }
}
