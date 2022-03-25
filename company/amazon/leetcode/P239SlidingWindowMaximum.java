package company.amazon.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class P239SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if ( nums == null || nums.length == 0 || k <= 0){
            return new int[0];
        }
        int res[] = new int[nums.length-k+1];
        int resIndex = 0;
        Deque<Integer> dequeue = new ArrayDeque<>();
        for ( int i=0; i<nums.length; i++) {
            if ( !dequeue.isEmpty() && dequeue.peek() < i-k+1){
                dequeue.poll();
            }
            while ( !dequeue.isEmpty() && nums[dequeue.peekLast()] < nums[i]){
                dequeue.poll();
            }
            dequeue.offer(i);
            if ( i>= k-1){
                res[resIndex++] = nums[dequeue.peek()];
            }
        }
        return res;
    }
}
