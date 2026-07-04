package company.microsoft;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;
    public MedianFinder(){
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public double findMedian(){
        if ( minHeap.size() > maxHeap.size()) return minHeap.peek();
        else if ( minHeap.size() < maxHeap.size()) return maxHeap.peek();
        else return (double) (minHeap.peek()+maxHeap.peek())/2.0;
    }

    public void addNum(int num){
        if ( maxHeap.isEmpty() || maxHeap.peek() > num){
            maxHeap.offer(num);
        } else{
            minHeap.offer(num);
        }
        if ( minHeap.size() > maxHeap.size()+1) maxHeap.offer(minHeap.poll());
        else if ( maxHeap.size() > minHeap.size()+1) minHeap.offer(maxHeap.poll());
    }
}
