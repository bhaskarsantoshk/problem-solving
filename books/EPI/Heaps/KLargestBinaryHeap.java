package books.EPI.Heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KLargestBinaryHeap {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public static List<Integer> getKLargestInBinaryHeap (List<Integer> a, int k){
        if( k<=0){
            return Collections.EMPTY_LIST;
        }

        PriorityQueue<HeapEntry> candidatemaxHeap = new PriorityQueue<>(DEFAULT_INITIAL_CAPACITY, Collections.reverseOrder());
        candidatemaxHeap.add(new HeapEntry(0, a.get(0)));
        List<Integer> result = new ArrayList<>();
        for ( int i=0; i<k; i++){
            Integer candidateIndex = candidatemaxHeap.peek().index;
            result.add(candidatemaxHeap.remove().value);

            Integer leftChildIndex = 2 * candidateIndex + 1;
            Integer rightChildIndex = 2 * candidateIndex + 2;

            if(leftChildIndex < a.size()){
                candidatemaxHeap.add(new HeapEntry(leftChildIndex, a.get(leftChildIndex)));
            }
            if(rightChildIndex < a.size()){
                candidatemaxHeap.add(new HeapEntry(rightChildIndex, a.get(rightChildIndex)));
            }
        }
        return result;
    }

    private static class HeapEntry{
        public Integer index;
        public Integer value;

        public HeapEntry(Integer index, Integer value){
            this.index = index;
            this.value = value;
        }
    }
}
// O (k log K) Time, O(K) Space 
