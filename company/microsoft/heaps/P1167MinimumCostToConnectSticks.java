package company.microsoft.heaps;

import java.util.PriorityQueue;

public class P1167MinimumCostToConnectSticks {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for ( int i=0; i<sticks.length; i++){
            pq.offer(sticks[i]);
        }

        int res = 0;
        while ( pq.size() >= 2){
            int stick1 = pq.poll();
            int stick2 = pq.poll();
            res += (stick1+stick2);
            pq.offer(res);
        }
        if ( pq.isEmpty()) return res;
        return res + pq.poll();

    }
}
