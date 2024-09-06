package takeUForward.graph;

import java.util.ArrayList;

public class G12DetectACycleInAnUndirectedGraphUsingDFS {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        for ( int i=0; i<V; i++){
            if ( !vis[i]){
                if ( isCycleDFS(i, adj, vis, -1)) return true;
            }
        }
        return false;
    }

    private boolean isCycleDFS(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, int parent) {
        vis[node] = true;
        for ( int adjNode: adj.get(node)){
            if ( !vis[adjNode]) {
                if ( isCycleDFS(adjNode, adj, vis, node)) return true;
            } else if ( parent != adjNode){
                return true;
            }
        }
        return false;
    }
}
