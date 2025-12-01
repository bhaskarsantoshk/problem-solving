package takeUForward.QR;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class P45DijkstrasAlgorithm {
    public int[] dijkstra(int V,  ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e9);
        dist[S] = 0;
        pq.add(new int[]{0, S});
        while (!pq.isEmpty()) {
            int dis = pq.peek()[0];
            int node = pq.peek()[1];
            pq.poll();
            for (ArrayList<Integer> it : adj.get(node)) {
                int adjNode = it.get(0);
                int edgeWt = it.get(1);
                if (dis + edgeWt < dist[adjNode]) {
                    dist[adjNode] = dis + edgeWt;
                    pq.add(new int[]{dist[adjNode], adjNode});
                }
            }
        }
        return dist;
    }
}
