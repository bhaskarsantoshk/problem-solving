package takeUForward.heaps;

import java.util.PriorityQueue;

public class P9KthLargestElementInAStreamOfRunningIntegers {
    PriorityQueue<Integer> minHeap;
    int k;
    public P9KthLargestElementInAStreamOfRunningIntegers(int k, int[] nums) {
        this.k = k;
        this.minHeap =  new PriorityQueue<>();
        for ( int i=0; i<nums.length; i++){
            if ( minHeap.size() <k) minHeap.add(nums[i]);
            else if ( nums[i] > minHeap.peek()){
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
    }

    public int add(int val) {
        if ( minHeap.size() < k) minHeap.add(val);
        else if ( val > minHeap.peek()) {
            minHeap.poll();
            minHeap.add(val);
        }
        return minHeap.size() == k ? minHeap.peek() : -1;
    }
}
