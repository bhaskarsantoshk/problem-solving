package takeUForward.graph.revision3;

import java.util.*;

public class P27DijkstraSAlgorithmUsingPriorityQueue {
    public  int[] dijkstra(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int[] distance = new int[V];
        Arrays.fill(distance, (int)1e9);
        distance[S] = 0;

        List<int[]>[] g = new ArrayList[V];
        for ( int i=0; i<V; i++) g[i] = new ArrayList<>();
        for ( List<Integer> edge: edges ){
            g[edge.get(0)].add(new int[]{edge.get(1), edge.get(2)});
            g[edge.get(1)].add(new int[]{edge.get(0), edge.get(2)});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        pq.offer(new int[]{0, S});
        while ( !pq.isEmpty()){
            int[] nodeArr = pq.poll();
            int dist = nodeArr[0];
            int u = nodeArr[1];
            if ( dist > distance[u]) continue;

            for ( int adj[]: g[u] ){
                int v = adj[0];
                int wt = adj[1];
                if ( distance[v] > distance[u] + wt){
                    distance[v] = distance[u] + wt;
                    pq.offer(new int[]{distance[v], v});
                }
            }
        }
        return distance;
    }
}
