package takeUForward.graph.revision4;

import java.util.ArrayList;
import java.util.List;

public class G3NumberOfProvinces  {
    public int numProvinces(int[][] adj) {
        int n = adj.length;
        List<Integer>[] g = new ArrayList[n];
        for ( int i=0; i<n; i++) g[i] = new ArrayList<>();
        for ( int i=0; i<n; i++){
            for ( int j=0; j<n; j++){
                if ( adj[i][j] == 1) {
                    g[i].add(j);
                }
            }
        }

        boolean[] vis = new boolean[n];
        int numProvinces = 0;
        for ( int i=0; i<n; i++){
            if ( !vis[i]) {
                dfs(i, g, vis);
                numProvinces++;
            }
        }

        return numProvinces;
    }

    private void dfs(int node, List<Integer>[] g, boolean[] vis) {
        vis[node] = true;
        for ( int adjNode: g[node]){
            if ( !vis[adjNode]) dfs(adjNode, g, vis);
        }
    }
}
