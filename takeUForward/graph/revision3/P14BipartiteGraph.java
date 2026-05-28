package takeUForward.graph.revision3;
import java.util.*;

public class P14BipartiteGraph {
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
                if (!isBipartiteBFS(i, g, color)) return false;
            }
        }

        return true;
    }

    private boolean isBipartiteBFS(int i, List<Integer>[] g, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        color[i] = 0;
        while ( !q.isEmpty()){
            int node = q.poll();
            for ( int adjNode: g[node]){
                if ( color[adjNode] == -1){
                    color[adjNode] = 1-color[node];
                    q.offer(adjNode);
                } else {
                    if ( color[adjNode] == color[node]) return false;
                }
            }
        }
        return true;
    }
}
