package takeUForward.graph.hard_problems;

import java.util.*;

public class ShortestPathInUndirectedGraphWithUnitWeights {
    public int[] shortestPath(int[][] edges, int N, int M) {
        List<Integer>[] G = new ArrayList[N];
        for ( int i=0; i<N; i++) G[i] = new ArrayList<>();
        for (int[] edge: edges){
            G[edge[0]].add(edge[1]);
            G[edge[1]].add(edge[0]);
        }
        int[] dist = new int[N];
        Arrays.fill(dist, (int)1e9);
        dist[0] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()){
            int node = queue.poll();
            for ( int adjNode: G[node]){
                if ( dist[adjNode] > dist[node]+1){
                    dist[adjNode] = dist[node]+1;
                    queue.offer(adjNode);
                }
            }
        }
        for ( int i=0; i<N; i++) if ( dist[i] == (int)1e9) dist[i] = -1;
        return dist;
    }
}
