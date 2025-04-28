package takeUForward.heaps;

import java.util.PriorityQueue;

public class P8KThLargestElementInAnArray {
    public int kthLargestElement(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for ( int i=0; i<k; i++) pq.offer(nums[i]);
        for ( int i=k;i<nums.length; i++){
            if(nums[i] > pq.peek()) {
                pq.poll();
                pq.add(nums[i]);
            }
        }
        return pq.peek();
    }
}
