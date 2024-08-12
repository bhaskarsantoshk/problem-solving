package company.google;

import java.util.PriorityQueue;

public class P703KthLargestElementInAStream {

    PriorityQueue<Integer> pq;
    int size;

    public P703KthLargestElementInAStream(int k, int[] nums) {
        pq = new PriorityQueue<>();
        size = k;
        for ( int num: nums){
            pq.offer(num);
            if ( pq.size() > k) pq.poll();
        }
    }

    public int add(int val) {
        pq.offer(val);
        if ( pq.size() >size ) pq.poll();
        if ( pq.isEmpty()) throw new IllegalStateException("queue is empty");
        return pq.peek();
    }
}
