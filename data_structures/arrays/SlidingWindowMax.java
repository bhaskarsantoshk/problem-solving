package data_structures.arrays;

import java.util.ArrayDeque;

public class SlidingWindowMax {
    public static int[] slidingWindowMax(int[] a, int k) {
        if (a== null || k<=0){
            return null;
        }
        int[] res = new int[a.length-k+1];
        int index = 0;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for ( int i=0; i<a.length; i++){
            // Check if the latest index stored is outside window
            while ( !deque.isEmpty() && deque.peek() <= i-k+1){
                deque.poll();
            }
            // check if the least element is smaller than the current, remove if it is.
            while ( !deque.isEmpty() && a[deque.peekLast()] < a[i]){
                deque.pollLast();
            }
            deque.offer(i);
            if ( i >= k-1){
                res[index++] = a[deque.peek()];
            }
        }
        return res;
    }
}
