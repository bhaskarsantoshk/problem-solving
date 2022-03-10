package company.amazon.leetcode;

import java.util.PriorityQueue;

public class P1167MinimumCostToConnectSticks {
    public int connectSticks(int[] sticks) {
        // We need to find two smallest sticks every time and add , because they sum up to smallest cost
        // Hence PriorityQueue/MinHeap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for ( int stick: sticks){
            pq.add(stick);
        }
        int res = 0;
        while ( pq.size() > 1){
            int cost = pq.poll() + pq.poll();
            res += cost;
            pq.add(cost);
        }
        return res;
    }
}
