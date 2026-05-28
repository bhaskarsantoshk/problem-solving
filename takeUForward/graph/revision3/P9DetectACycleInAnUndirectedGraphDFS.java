package takeUForward.graph.revision3;

import java.util.List;

public class P9DetectACycleInAnUndirectedGraphDFS {
    public boolean isCycle(int V, List<Integer>[] adj) {
        boolean[] vis = new boolean[V];
        for ( int i=0; i<V; i++){
            if ( !vis[i]) {
                if(isCycleDFS(i, -1, adj, vis)) return true;
            }
        }
        return false;
    }

    private boolean isCycleDFS(int node, int parent, List<Integer>[] adj, boolean[] vis) {
        vis[node] = true;
        for ( int adjNode: adj[node]){
            if ( !vis[adjNode]){
                if (isCycleDFS(adjNode, node, adj, vis)) return true;
            } else {
                if ( adjNode != parent) return true;
            }
        }
        return false;
    }

    /*
    Complexity:

* Time: O(V+E)
* Space: O(V) (visited + recursion stack)
     */
}
