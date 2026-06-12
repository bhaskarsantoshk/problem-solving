package company.microsoft.graph;

import java.util.*;

public class P787CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] g = new ArrayList[n];
        for ( int i=0; i<n; i++) g[i] = new ArrayList<>();
        for ( int[] flight: flights){
            int u = flight[0];
            int v = flight[1];
            int wt = flight[2];
            g[u].add(new int[] { u, v, wt});
        }

        int[] distance = new int[n];
        Arrays.fill(distance, (int)1e9);
        distance[src] = 0;
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{src, 0, 0});

        while ( !queue.isEmpty()){
            int nodeArr[] = queue.poll();
            int node = nodeArr[0];
            int stops = nodeArr[1];
            int cost = nodeArr[2];
            if ( stops > k) continue;
            for ( int[] adj: g[node]){
                int adjNode = adj[1];
                int wt = adj[2];
                if ( cost + wt < distance[adjNode] && stops <= k){
                    distance[adjNode] = cost+wt;
                    queue.offer(new int[]{adjNode, stops+1, distance[adjNode]});
                }
            }
        }
        return (distance[dst] == (int)1e9) ? -1: distance[dst];
    }
}
