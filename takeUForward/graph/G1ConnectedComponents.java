package takeUForward.graph;

import java.util.ArrayList;
import java.util.List;

public class G1ConnectedComponents {
    public int findNumberOfComponent(int V, List<List<Integer>> edges) {
        List<Integer>[] g = new ArrayList[V];
        for ( int i=0; i<V; i++) g[i] = new ArrayList<>();
        boolean[] vis = new boolean[V];
        for ( List<Integer> edge: edges){
            int u = edge.get(0), v = edge.get(1);
            g[u].add(v);
            g[v].add(u);
        }
        int connectedComponents = 0;
        for ( int i=0; i<V; i++){
            if ( !vis[i]) {
                dfs(i, g, vis);
                connectedComponents++;
            }
        }
        return connectedComponents;
    }

    private void dfs(int node, List<Integer>[] g, boolean[] vis) {
        vis[node] = true;
        for ( int adjNode: g[node]) if (!vis[adjNode])  dfs(adjNode, g, vis);
    }
}
