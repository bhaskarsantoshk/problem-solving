package takeUForward.graph.revision3;
import java.util.*;

public class P30CheapestFlightWithinKStops {
    public int CheapestFlight(int n, int[][] flights, int src, int dst, int K) {
        List<int[]>[] g = new ArrayList[n];
        for (int i=0; i<n; i++) g[i] = new ArrayList<>();
        for ( int[] flight: flights){
            int u = flight[0];
            int v = flight[1];
            int cost = flight[2];
            g[u].add(new int[]{v, cost});
        }

        int[] distance = new int[n];
        Arrays.fill(distance, (int)1e9);
        distance[src] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, src, 0});
        while (!queue.isEmpty()){
            int [] nodeArr = queue.poll();
            int steps = nodeArr[0];
            int node = nodeArr[1];
            int dist = nodeArr[2];

            if ( steps > K) continue;

            for ( int[] adj: g[node]){
                int adjNode = adj[0];
                int wt = adj[1];

                if ( distance[adjNode] > dist+ wt && steps <= K){
                    distance[adjNode] = dist+ wt;
                    queue.offer(new int[] {steps+1, adjNode, distance[adjNode]});
                }
            }

        }

        for ( int i=0; i<n; i++) if ( distance[i] == (int)1e9) distance[i] = -1;
        return distance[dst];
    }
}
