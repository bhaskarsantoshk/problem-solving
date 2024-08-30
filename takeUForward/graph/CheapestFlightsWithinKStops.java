package takeUForward.graph;

import java.util.*;

public class CheapestFlightsWithinKStops {
    public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {

        List<int[]>[] G = new ArrayList[n];
        for ( int i=0; i<n; i++) G[i] = new ArrayList<>();
        for ( int[] flight: flights){
            G[flight[0]].add(new int[]{flight[1], flight[2]});
        }

       // take stops as deciding factor
        int[] distance = new int[n];
        Arrays.fill(distance, (int)1e9);

        Queue<int[]> queue = new LinkedList<>();
        distance[src] = 0;
        queue.offer(new int[]{0, src, 0});// stops, node, distance

        while (!queue.isEmpty()){
            int[] cell = queue.poll();
            int stops = cell[0];
            int node = cell[1];
            int dist = cell[2];
            if ( stops > k) continue;

            for ( int [] pair: G[node]){
                int adjNode = pair[0];
                int wt = pair[1];

                if ( dist+ wt < distance[adjNode] && stops <= k){
                    distance[adjNode] = dist+wt;
                    queue.offer(new int[]{stops+1, adjNode, distance[adjNode]});
                }
            }
        }
        if ( distance[dst] == (int)1e9) return -1;
        return distance[dst];
    }
}
