package company.amazon.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class P295FindMedianFromDataStream {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public P295FindMedianFromDataStream() {

    }

    public void addNum(int num) {
        if ( maxHeap.isEmpty() || maxHeap.peek() > num ){
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }
        if ( maxHeap.size() > minHeap.size() + 1){
            minHeap.offer(maxHeap.poll());
        } else if ( minHeap.size() > maxHeap.size()+1 ){
            maxHeap.offer(minHeap.poll());
        }

    }

    public double findMedian() {
        if ( maxHeap.size() > minHeap.size() ) return maxHeap.peek();
        if ( minHeap.size() > maxHeap.size() ) return minHeap.peek();
        return (minHeap.peek() + maxHeap.peek() ) / 2.0d;
    }
}
