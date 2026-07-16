package takeUForward.graph;

import java.util.ArrayList;
import java.util.List;

public class G3NumberOfProvinces {
    public int numProvinces(int[][] adj) {
        int n = adj.length;
        List<Integer>[] g = new ArrayList[n];
        for ( int i=0; i<n; i++) g[i] = new ArrayList<>();
        for ( int i=0; i<n; i++){
            for ( int j=0; j<n; j++){
                if ( adj[i][j] == 1) {
                    int u = i, v = j;
                    g[u].add(v);
                }
            }
        }

        boolean[] vis = new boolean[n];
        int numProvinces = 0;
        for ( int i=0; i<n; i++){
            if (!vis[i]) {
                dfs(i, vis, g);
                numProvinces++;
            }
        }
        return numProvinces;
    }

    private void dfs(int node, boolean[] vis, List<Integer>[] g) {
        vis[node] = true;
        for ( int adjNode: g[node]){
            if (!vis[adjNode]) dfs(adjNode, vis, g);
        }
    }
}
