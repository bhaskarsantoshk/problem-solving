package takeUForward.graph.revision4;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class G7CycleDetectionInUndirectedGraphDFS {
    public boolean isCycle(int V, List<Integer>[] adj) {
        boolean[] vis = new boolean[V];
        for ( int i=0; i<V; i++) {
            if (!vis[i]) {
                if (isCycleDFS(i, adj, vis, -1)) return true;
            }
        }
        return false;
    }

    private boolean isCycleDFS(int node, List<Integer>[] adj, boolean[] vis, int parent) {
        vis[node] = true;
        for ( int adjNode: adj[node]){
            if (!vis[adjNode]) {
                if ( isCycleDFS(adjNode, adj, vis, node)) return true;
            } else if ( adjNode != parent) return true;
        }
        return false;
    }

}
