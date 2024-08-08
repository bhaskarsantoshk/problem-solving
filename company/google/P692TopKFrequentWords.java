package company.google;

import java.util.*;

public class P692TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> frequency = new HashMap<>();
        for ( String word: words) frequency.put(word, frequency.getOrDefault(word,0)+1);
        PriorityQueue<String> pq = new PriorityQueue<>((s1, s2)->
                (frequency.get(s1) == frequency.get(s2)) ? s1.compareTo(s2) : frequency.get(s2)-frequency.get(s1));
        for ( String word: frequency.keySet()){
            pq.offer(word);
        }
        List<String> res = new ArrayList<>();
        while ( k-- != 0){
            res.add(pq.poll());
        }
        return res;
    }
}
