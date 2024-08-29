package takeUForward.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        int[] distance = new int[V];
        Arrays.fill(distance, (int)1e9);

        distance[S] = 0;
        pq.add(new int[]{0, S});

        while ( !pq.isEmpty()){
            int[] pair = pq.poll();
            int dist = pair[0];
            int node = pair[1];

            for ( int i=0; i<adj.get(node).size(); i++){
                int edgeWt = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);

                if (dist+edgeWt < distance[adjNode]){
                    distance[adjNode] = dist+edgeWt;
                    pq.add(new int[] {distance[adjNode], adjNode});
                }
            }
        }
        return distance;
    }
}
