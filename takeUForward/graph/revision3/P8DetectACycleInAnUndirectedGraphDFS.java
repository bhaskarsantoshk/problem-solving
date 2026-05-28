package takeUForward.graph.revision3;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P8DetectACycleInAnUndirectedGraphDFS {
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
