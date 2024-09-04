package takeUForward.trees;

import java.util.Collections;
import java.util.PriorityQueue;

public class P295FindMedianFromDataStream {

    PriorityQueue<Integer> minHeap ;
    PriorityQueue<Integer> maxHeap;

    public P295FindMedianFromDataStream() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        if ( maxHeap.isEmpty() || maxHeap.peek() > num){
            maxHeap.offer(num);
        } else{
            minHeap.add(num);
        }
        if ( maxHeap.size() > minHeap.size()+1){
            minHeap.add(maxHeap.poll());
        } else if ( minHeap.size() > maxHeap.size()+1){
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if ( minHeap.size() > maxHeap.size()) return minHeap.peek();
        if ( maxHeap.size() > minHeap.size()) return maxHeap.peek();
        return (maxHeap.peek() + minHeap.peek())/2.0;
    }
}
