package takeUForward.graph.revision3;
import java.util.*;

public class P15BipartiteGraphDFS {
    public boolean isBipartite(int V, List<List<Integer>> edges) {
        List<Integer>[] g = new ArrayList[V];
        for ( int i=0; i<V; i++) g[i] = new ArrayList<>();
        for (List<Integer> edge: edges){
            int u = edge.get(0); int v = edge.get(1);
            g[u].add(v);
            g[v].add(u);
        }

        int[] color = new int[V];
        Arrays.fill(color, -1);

        for(int i=0; i<V; i++){
            if (color[i] == -1){
                if (!isBipartiteDFS(i, g, color, 0)) return false;
            }
        }

        return true;
    }

    private boolean isBipartiteDFS(int node, List<Integer>[] g, int[] color, int col) {
        color[node] = col;
        for ( int adjNode: g[node]){
            if ( color[adjNode] == -1){
                if (!isBipartiteDFS(adjNode, g, color, 1-col)) return false;
            }  else if ( col == color[adjNode]) return false;
        }
        return true;
    }
}
