package takeUForward.graph;

import java.util.ArrayList;

public class DirectedGraphCycle {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];
        for ( int i=0; i<V; i++){
            if ( !vis[i]) {
                if ( dfsCheck(adj, vis, pathVis, i)) return true;
            }
        }
        return false;
    }

    private boolean dfsCheck(ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] pathVis, int node) {
        vis[node] = pathVis[node] = true;
        for ( int adjNode: adj.get(node)){
            if ( !vis[adjNode]) {
                if ( dfsCheck(adj, vis, pathVis, adjNode)) return true;
            } else if ( pathVis[adjNode]) return true;
        }
        pathVis[node] = false;
        return false;
    }


}
