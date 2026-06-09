package takeUForward.graph.revision3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P34BellmanFordAlgorithm {
    static int[] bellman_ford(int V,
                              ArrayList<ArrayList<Integer>> edges, int S) {
        int[] distance = new int[V];
        Arrays.fill(distance, (int)1e9);
        distance[S] = 0;

        for ( int i=1; i<= V-1; i++ ){
            for ( List<Integer> edge : edges){
                int u = edge.get(0);
                int v = edge.get(1);
                int wt = edge.get(2);
                if ( distance[u] != (int)1e9 && distance[u] + wt < distance[v]) distance[v] = distance[u] + wt;
            }
        }

        for ( List<Integer> edge : edges){
            int u = edge.get(0);
            int v = edge.get(1);
            int wt = edge.get(2);
            if ( distance[u] != (int)1e9 && distance[u] + wt < distance[v]) {
                return new int[]{-1};
            }
        }
        return distance;
    }
}
