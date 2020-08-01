package books.EPI.Heaps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeSortedArrays {

    public static List<Integer> mergeSortedArrays(List<List<Integer>> sortedArrays) {
        List<Iterator<Integer>> iterators = new ArrayList<>(sortedArrays.size());
        for ( List<Integer> array: sortedArrays){
            iterators.add(array.iterator());
        }

        PriorityQueue<ArrayEntry> minHeap= new PriorityQueue<>(sortedArrays.size(),
                (o1,o2)-> Integer.compare(o1.value, o2.value));
        for ( int i=0; i<iterators.size(); i++){
            if ( iterators.get(i).hasNext() ){
                minHeap.add( new ArrayEntry(iterators.get(i).next(), i));
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()){
            ArrayEntry headEntry = minHeap.poll();
            result.add(headEntry.value);
            if(iterators.get(headEntry.arrayId).hasNext()){
                minHeap.add(new ArrayEntry(iterators.get(headEntry.arrayId).next(), headEntry.arrayId));
            }
        }
        return result;
    }

    private static class ArrayEntry {
        public Integer value;
        public Integer arrayId;

        public ArrayEntry( Integer value, Integer arrayId){
            this.value = value;
            this.arrayId = arrayId;
        }
    }
}

// O (N log K) Time, O(K) Space
