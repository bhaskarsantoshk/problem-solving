package company.google;

import java.util.*;

public class ShortestPathInUndirectedGraphWithUnitWeights {
    public int[] shortestPath(int[][] edges, int N, int M) {
        List<Integer>[] g = new ArrayList[N];
        for ( int i=0; i<N; i++) g[i] = new ArrayList<>();
        for ( int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            g[u].add(v);
            g[v].add(u);
        }

        int[] distance = new int[N];
        Arrays.fill(distance, (int)1e9);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        distance[0] = 0;

        while ( !queue.isEmpty()){
            int node = queue.poll();
            for ( int adjNode: g[node]){
                if ( distance[adjNode] > distance[node]+1){
                    distance[adjNode] = distance[node]+1;
                    queue.offer(adjNode);
                }
            }
        }

        for ( int i=0; i<N; i++) if( distance[i] == (int)1e9) distance[i] = -1;
        return distance;
    }
}
