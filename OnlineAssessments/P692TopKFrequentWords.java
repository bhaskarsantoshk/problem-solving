package OnlineAssessments;

import java.util.*;

public class P692TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> frequency = new HashMap<>();
        for (String word: words){
            frequency.put(word, frequency.getOrDefault(word,0)+1);
        }
        PriorityQueue<String> maxHeap = new PriorityQueue<>((o1,o2)-> (frequency.get(o1) == frequency.get(o2) ? o1.compareTo(o2) : frequency.get(o2)-frequency.get(o1)));
        List<String> res = new ArrayList<>();
        while ( k-- != 0){
            res.add(maxHeap.poll());
        }

        return res;
    }
}
