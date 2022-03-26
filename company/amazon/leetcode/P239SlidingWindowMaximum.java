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
        Deque<Integer> deque = new ArrayDeque<>();
        for ( int i=0; i<nums.length; i++){
            // Remove the indexes that are outside window
            while (!deque.isEmpty() && deque.peek() < i-k+1){
                deque.poll();
            }

            while (!deque.isEmpty() && nums[deque.pollLast()] < nums[i]){
                deque.pollLast();
            }
            deque.offer(i);
            if ( i >= k-1){
                res[resIndex++] = deque.peek();
            }
        }
        return res;
    }
}
