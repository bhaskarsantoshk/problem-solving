package takeUForward.recursion.contest;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumOperationsToExceedTarget {
    public int minOperationsToExceedTarget(List<Integer> nums, int targetValue) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        while ( !minHeap.isEmpty()){
            if ( minHeap.peek() < targetValue ){
                if ( minHeap.size() < 2) return -1;
                int min = minHeap.poll();
                int max = minHeap.poll();
                minHeap.offer(2*min+max);
            }
        }
        return minHeap.size();
    }
}
