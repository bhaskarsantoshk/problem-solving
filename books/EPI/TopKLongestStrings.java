package books.EPI;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class TopKStrings {
    public static List<String> topKLongestStrings (int k, Iterator<String> iterator){
        PriorityQueue<String> minHeap = new PriorityQueue<>(k, (s1,s2)-> Integer.compare(s1.length(), s2.length()));
        while ( iterator.hasNext()){
            minHeap.add(iterator.next());
            if ( minHeap.size() > k ){
                minHeap.poll();
            }
        }
        return new ArrayList<>(minHeap);
    }
}
