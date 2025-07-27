package takeUForward.graph.revision2;
import java.util.ArrayList;
import java.util.List;

public class P1ConnectedComponents {
    public int findNumberOfComponent(int V, List<List<Integer>> edges) {
        List<Integer>[] G = new ArrayList[V];
        for ( int i=0; i<V; i++) G[i] = new ArrayList<>();
        for ( List<Integer> edge : edges){
            int u = edge.get(0);
            int v = edge.get(1);
            G[u].add(v);
            G[v].add(u);
        }

        int connectedComponents = 0;
        boolean []vis = new boolean[V];
        for ( int i=0; i<V; i++){
            if ( !vis[i]) {
                dfs(i, vis, G);
                connectedComponents++;
            }
        }
        return connectedComponents;
    }

    private void dfs(int i, boolean[] vis, List<Integer>[] g) {
        vis[i] = true;
        for (int node: g[i]){
           if(!vis[node]) dfs(node, vis, g);
        }
    }
}
