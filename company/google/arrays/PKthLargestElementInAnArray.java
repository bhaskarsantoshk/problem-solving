package company.google.arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PKthLargestElementInAnArray {
    public int findKthLargestBruteForce(int[] nums, int k) {
        Arrays.sort(nums);
        if ( k > nums.length ) return -1;
        return nums[nums.length-k];
    }

    public int findKthLargestUsingMinHeap(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for ( int num : nums){
            if ( pq.size() == k) pq.poll();
            pq.offer(num);
        }
        return pq.poll();
    }
}
