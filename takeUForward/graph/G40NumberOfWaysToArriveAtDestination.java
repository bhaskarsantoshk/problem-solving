package takeUForward.graph;

import java.util.*;

public class G40NumberOfWaysToArriveAtDestination {
    static int countPaths(int n, List<List<Integer>> roads) {
        List<int[]>[] G = new ArrayList[n];
        for ( int i=0; i<n; i++) G[i] = new ArrayList<>();
        for ( List<Integer> road: roads){
            G[road.get(0)].add(new int[]{road.get(1), road.get(2)}); // u -> ( v, time)
            G[road.get(1)].add(new int[]{road.get(0), road.get(2)});
        }

        long[] distance = new long[n];
        Arrays.fill(distance, Long.MAX_VALUE);
        int []ways = new int[n];
        distance[0] = 0;
        ways[0] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(a->a.dist));
        pq.offer(new Pair(0,0));
        int mod = (int) 1e9+7;

        while (!pq.isEmpty()){
            Pair pair = pq.poll();
            long dist = pair.dist;
            int node = pair.node;

            for ( int adj[]: G[node] ){
                int adjNode = adj[0];
                int wt = adj[1];

                if ( dist + wt < distance[adjNode]){
                    distance[adjNode]= dist+wt;
                    pq.offer(new Pair(distance[adjNode], adjNode));
                    ways[adjNode] = ways[node];
                } else if ( dist+wt == distance[adjNode]){
                    ways[adjNode] = (ways[adjNode] + ways[node])%mod;
                }
            }
        }
        return ways[n-1]%mod;
    }

    static class Pair{
        int node;
        long dist;

        public Pair(long dist, int node) {
            this.node = node;
            this.dist = dist;
        }
    }
}
