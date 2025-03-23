package takeUForward.blind75.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public FindMedianFromDataStream() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        if ( maxHeap.isEmpty() || maxHeap.peek() > num) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }
        if ( minHeap.size() > maxHeap.size() + 1) maxHeap.offer(minHeap.poll());
        else if ( maxHeap.size() > minHeap.size()+1 ) minHeap.offer(maxHeap.poll());
    }

    public double findMedian() {
        if ( minHeap.size() > maxHeap.size() ) return minHeap.peek();
        if ( maxHeap.size() > minHeap.size() ) return maxHeap.peek();
        return (double) (minHeap.peek()+maxHeap.peek())/2.0;
    }
}
