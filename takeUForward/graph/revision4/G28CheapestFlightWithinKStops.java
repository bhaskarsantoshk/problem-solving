package takeUForward.graph.revision4;

import java.util.*;

public class G28CheapestFlightWithinKStops {
    public int CheapestFlight(int n, int[][] flights, int src, int dst, int K) {
        List<int[]>[] graph = new ArrayList[n];
        for ( int i=0; i<n; i++) graph[i] = new ArrayList<>();
        for ( int [] flight: flights){
            int u = flight[0], v = flight[1], wt = flight[2];
            graph[u].add(new int[]{v, wt});
        }

        int [] distance = new int[n];
        Arrays.fill(distance, (int)1e9);

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0, 0});

        while (!queue.isEmpty()){
            int[] nodeArr = queue.poll();
            int node = nodeArr[0];
            int cost = nodeArr[1];
            int steps = nodeArr[2];

            if ( node == dst) return steps;
            if ( steps > K ) continue;

            for ( int[] adjNodeArr: graph[node]){
                int adjNode = adjNodeArr[0];
                int newCost = adjNodeArr[1];

                if ( distance[adjNode] > distance[node] + newCost && steps <= K){
                    distance[adjNode] = distance[node] + newCost;
                    queue.offer(new int[]{adjNode, distance[adjNode], steps+1});
                }
            }
        }

        for ( int i=0; i<n; i++) if ( distance[i] == (int)1e9) distance[i] = -1;

        return distance[dst];

    }
}
