package books.EPI.Heaps;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AlmostSortedArray {
    public static List<Integer> sortAlmostSortedArray (Iterator<Integer> iterator, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        List<Integer> result = new ArrayList<>();
        while ( iterator.hasNext() ){
            minHeap.add(iterator.next());
            if ( minHeap.size() > k){
                result.add(minHeap.poll());
            }
        }
        //result.addAll(new ArrayList<>(minHeap));
        result.addAll(Stream.generate(minHeap::remove).limit(minHeap.size()).collect(Collectors.toList()));
        return result;
    }

    public static void main(String[] args){
        List<Integer> a = new ArrayList<>();
        a.add(3);
        a.add(-1);
        a.add(2);
        a.add(6);
        a.add(4);
        a.add(5);
        a.add(8);
        System.out.println(sortAlmostSortedArray(a.iterator(), 2));
    }
}


// GIST: as the numbers are placed at max k positions from their actual sorted positions, 
//you need to read at max k+1 elements to find the min element for that window
