package takeUForward.graph.revision4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class G25DijkstraAlgorithm {
    public  int[] dijkstra(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        List<int[]>[] g = new ArrayList[V];
        for ( int i=0; i<V; i++) g[i] = new ArrayList<>();
        for ( ArrayList<Integer> edge: edges){
            int u = edge.get(0), v = edge.get(1), wt = edge.get(2);
            g[u].add(new int[]{v, wt});
            g[v].add(new int[]{u, wt});
        }

        int[] distance = new int[V];
        Arrays.fill(distance, (int)1e9);
        distance[S] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b)-> a[1]-b[1]);
        pq.offer(new int[]{S,0});
        while (!pq.isEmpty()){
            int nodeArr[] = pq.poll();
            int u = nodeArr[0];
            int dist= nodeArr[1];
            if ( dist > distance[u]) continue;
            for ( int adjNode[] : g[u]){
                int v = adjNode[0];
                int wt = adjNode[1];
                if (  distance[v] > distance[u] + wt){
                    distance[v] = distance[u] + wt;
                    pq.offer(new int[]{v, distance[v]});
                }
            }
        }
        return distance;
    }
}
