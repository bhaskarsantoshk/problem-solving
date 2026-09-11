package takeUForward.graph.revision4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class G32BellmanFordAlgorithm {
    static int[] bellmanFord(int V, ArrayList<ArrayList<Integer>> edges, int S){
        int[] distance = new int[V];
        Arrays.fill(distance, (int)1e9);
        distance[S] = 0;


        for ( int i=1; i<=V-1; i++){
            for ( ArrayList<Integer> edge : edges){
                int u = edge.get(0), v = edge.get(1), wt = edge.get(2);
                if ( distance[u] != (int)1e9 && distance[v] > distance[u] + wt) distance[v] = distance[u] + wt;
            }
        }

        for ( int i=1; i<=V-1; i++){
            for ( ArrayList<Integer> edge : edges){
                int u = edge.get(0), v = edge.get(1), wt = edge.get(2);
                if ( distance[u] != (int)1e9 && distance[v] > distance[u] + wt) return new int[]{-1};
            }
        }

        return distance;
    }
}
