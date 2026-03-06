package company.apple;

import java.util.*;

public class P45TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for ( String word : words) map.put(word, map.getOrDefault(word, 0)+1);

        // reason to store in reverse is to poll when size > k

        PriorityQueue<String> pq = new PriorityQueue<>(
                (a,b)-> map.get(a).equals( map.get(b)) ?
                        b.compareTo(a) : Integer.compare(map.get(a), map.get(b)) );

        for ( String word: words){
            pq.offer(word);
            if ( pq.size() > k) pq.poll();
        }

        List<String> result = new ArrayList<>();
        while ( !pq.isEmpty()) result.add(pq.poll());
        Collections.reverse(result);
        return result;
    }
}
