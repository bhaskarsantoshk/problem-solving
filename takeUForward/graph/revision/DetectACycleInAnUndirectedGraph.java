package takeUForward.graph.revision;

import java.util.List;

public class DetectACycleInAnUndirectedGraph {
    public boolean isCycle(int V, List<Integer>[] adj) {
        boolean[] vis = new boolean[V];
        for ( int i=0; i<V; i++){
            if (!vis[i]){
                if ( isCycleDFS(i, -1, adj, vis)) return true;
            }
        }
        return false;
    }

    private boolean isCycleDFS(int node, int parent, List<Integer>[] g, boolean[] vis) {
        vis[node] = true;
        for(int adjNode: g[node]){
            if ( !vis[adjNode]) {
                if (isCycleDFS(adjNode, node, g, vis)) return true;
            } else if ( adjNode != parent) return true;
        }

        return false;
    }
}
