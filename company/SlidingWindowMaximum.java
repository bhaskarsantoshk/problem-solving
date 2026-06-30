package company;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindowBruteForce(int[] arr, int k) {
        int n = arr.length;
        // 1 2 3 4 5 6 7
        // 3
        int[] res = new int[n-k+1];
        for ( int i=0; i<=n-k; i++){
            res[i] = arr[i];
            for ( int j=i; j<= i+k-1; j++){
                res[i] = Math.max(res[i], arr[j]);
            }
        }
        return res;
    }

    public int[] maxSlidingWindow(int[] arr, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = arr.length;
        int[] res = new int[n-k+1];
        for ( int i=0; i<n; i++){
            // let's say k = 3, when i = 3, 0 should go out of the window.
            while ( !dq.isEmpty() && dq.peekFirst() <= i-k) dq.pollFirst();
            while ( !dq.isEmpty() && arr[dq.peekLast()] <= arr[i] ) dq.pollLast();
            dq.offerLast(i);
            if ( i >= k-1) res[i-k+1] = arr[dq.peekFirst()];
        }
        return res;
    }
}
