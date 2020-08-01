package books.EPI.Heaps;

import java.util.*;

public class Median {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public static List<Double> getMediansList(Iterator<Integer> sequence) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(DEFAULT_INITIAL_CAPACITY, Collections.reverseOrder());
        List<Double> result = new ArrayList<>();
        while (sequence.hasNext()) {
            int x = sequence.next();
            minHeap.add(x);
            maxHeap.add(minHeap.remove());
            if (maxHeap.size() > minHeap.size()) {
                minHeap.add(maxHeap.remove());
            }
            result.add((minHeap.size() == maxHeap.size()) ? 0.5 * (minHeap.peek() + maxHeap.peek()) : (double) minHeap.peek());
        }
        return result;
    }
}

// O (N log K) Time, O(K) Space (Revisit*)
