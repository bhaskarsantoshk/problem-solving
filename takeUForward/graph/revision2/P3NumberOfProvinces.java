package takeUForward.graph.revision2;

import java.util.ArrayList;
import java.util.List;

public class P3NumberOfProvinces {
    public int numProvinces(int[][] adj) {
        int V = adj.length;
        List<Integer>[] G = new ArrayList[V];
        for ( int i=0; i<V; i++) G[i] = new ArrayList<>();
        for ( int i=0; i<V; i++){
            for ( int j=0; j<V; j++){
                if ( adj[i][j] == 1) {
                    G[i].add(j);
                    G[j].add(i);
                }
            }
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
