package company.google;

import java.util.*;

public class P692TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for ( String word: words){
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>((a,b)->
                map.get(a)== map.get(b) ? a.compareTo(b) : map.get(b)-map.get(a));

        for ( String word: map.keySet()){
            pq.offer(word);
        }

        List<String> res = new ArrayList<>();

        while ( k-- != 0){
            res.add(pq.poll());
        }
        return res;
    }

    public List<String> topKFrequentMemoryOptimized(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for ( String word: words){
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>((a,b)->
                map.get(a)== map.get(b) ? b.compareTo(a) : map.get(a)-map.get(b));

        for ( String word: map.keySet()){
            pq.offer(word);
            if ( pq.size() > k) pq.poll();
        }

        List<String> res = new ArrayList<>();

        while ( k-- != 0){
            res.add(pq.poll());
        }
        Collections.reverse(res);
        return res;
    }
}
