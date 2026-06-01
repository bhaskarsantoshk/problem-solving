package takeUForward.graph.revision3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class P32NumberOfWaysToArriveAtDestination {
    public int countPaths(int n, List<List<Integer>> roads) {
        List<int[]>[] g = new ArrayList[n];
        for ( int i=0; i<n; i++) g[i] = new ArrayList<>();
        for ( List<Integer> edge: roads){
            int u = edge.get(0);
            int v = edge.get(1);
            int wt = edge.get(2);
            g[u].add(new int[]{v, wt});
            g[v].add(new int[]{u, wt});
        }
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)-> Long.compare(a[0], b[0]));
        long[] distance = new long[n];
        Arrays.fill(distance, Long.MAX_VALUE);
        int [] ways = new int[n];
        distance[0] = 0;
        ways[0] = 1;
        pq.offer(new long[]{0, 0});
        while ( !pq.isEmpty()){
            long []nodeArr = pq.poll();
            long dist = nodeArr[0];
            int node = (int) nodeArr[1];
            if (dist > distance[node]) continue;

            for ( int adj[] : g[node]){
                int adjNode = adj[0];
                int wt = adj[1];
                if ( distance[adjNode] > distance[node] + wt){
                    distance[adjNode] = distance[node] + wt;
                    ways[adjNode] = ways[node];
                    pq.offer(new long[]{distance[adjNode], adjNode});
                } else if ( distance[adjNode] == distance[node] + wt){
                    ways[adjNode] = (ways[node]+ways[adjNode])%1000000007;
                }
            }
        }
        return ways[n-1]%1000000007;
    }
}
