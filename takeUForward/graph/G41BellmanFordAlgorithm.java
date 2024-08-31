package takeUForward.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class G41BellmanFordAlgorithm {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int[] distance = new int[V];
        Arrays.fill(distance, (int)1e8);
        distance[S] = 0;
        // Do N-1 relaxations
        for ( int i=0; i<V-1; i++){
            for ( ArrayList<Integer> edge : edges){
                int u = edge.get(0);
                int v = edge.get(1);
                int wt = edge.get(2);
                if ( distance[u] != (int)1e8 && distance[u] + wt < distance[v]){
                    distance[v] = distance[u] + wt;
                }
            }
        }

        // Nth relaxation is to determine if there is a negative cycle
        for ( ArrayList<Integer> edge : edges){
            int u = edge.get(0);
            int v = edge.get(1);
            int wt = edge.get(2);
            if ( distance[u] != (int)1e8 && distance[u] + wt < distance[v]){
               return new int[]{-1};
            }
        }
        return distance;
    }
}

// T : O(V*E)
