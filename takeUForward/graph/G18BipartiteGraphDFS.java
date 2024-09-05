package takeUForward.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class G18BipartiteGraphDFS {
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj) {
        int[] colors = new int[V];
        Arrays.fill(colors, -1);
        for ( int i=0; i<V; i++){
            if ( colors[i] == -1) {
                if (!dfs(i, adj, colors, 0)) return false;
            }
        }
        return true;
    }

    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] colors, int color) {
        colors[node] = color;
        for ( int adjNode: adj.get(node)){
            if ( colors[adjNode] == -1){
                if ( !dfs(adjNode, adj, colors, 1-color)) return false;
            } else if ( colors[adjNode] == color) return false;
        }
        return true;
    }
}
