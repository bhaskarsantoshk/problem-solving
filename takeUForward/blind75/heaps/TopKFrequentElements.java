package takeUForward.blind75.heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for ( int num: nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq =
                new PriorityQueue<>( (a,b)->Integer.compare(b.getValue(), a.getValue()));
        for ( Map.Entry<Integer, Integer> entry: map.entrySet()){
            pq.offer(entry);
            if ( pq.size() > k) pq.poll();
        }
        int [] res = new int[pq.size()];
        int index = 0;
        while (!pq.isEmpty()) {
            res[index++] = pq.poll().getKey();
        }
        return res;
    }
}
