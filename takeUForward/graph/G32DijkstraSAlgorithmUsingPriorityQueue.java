package takeUForward.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class G32DijkstraSAlgorithmUsingPriorityQueue {

    // minHeap + distance[]
    // Shorter distance at top ( Pq)

    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]); // <distance, node>
        int[] distance = new int[V];
        Arrays.fill(distance, (int)1e9);
        distance[S] = 0;
        pq.offer(new int[]{0, S});

        while (!pq.isEmpty()){
            int [] pair = pq.poll();
            int dist = pair[0];
            int node = pair[1];

            for ( List<Integer> edge: adj.get(node)){
                int adjNode = edge.get(0);
                int wt = edge.get(1);
                if ( distance[adjNode] > dist+wt){
                    distance[adjNode] = dist+node;
                    pq.offer(new int[]{distance[adjNode], adjNode});
                }
            }
        }

        for ( int i=0; i<V; i++){
            if (distance[i] == (int)1e9) distance[i] = -1;
        }

        return distance;
    }
}
