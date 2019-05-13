package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class P239SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if ( nums == null || k <= 0){
            return new int[0];
        }
        int n = nums.length;
        int []r = new int[n-k+1];
        int ri=0;
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0; i<nums.length; i++){
            while(!dq.isEmpty() && dq.peek() < i-k+1){
                dq.poll();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }
            dq.offer(i);
            if(i>= k-1){
                r[ri++] = nums[dq.peek()];
            }
        }
        return r;
    }
}
