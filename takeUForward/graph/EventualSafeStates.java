package takeUForward.graph;

import java.util.ArrayList;
import java.util.List;

public class EventualSafeStates {
    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];
        boolean[] safeNodes = new boolean[V];
        for ( int i=0; i<V; i++){
            if ( !vis[i]) dfs(adj, vis, pathVis, safeNodes, i);
        }
        List<Integer> res= new ArrayList<>();
        for ( int i=0; i<V; i++){
            if ( safeNodes[i]) res.add(i);
        }
        return res;
    }

    private boolean dfs(List<List<Integer>> adj, boolean[] vis, boolean[] pathVis, boolean[] safeNodes, int node) {
        vis[node] = true;
        pathVis[node] = true;
        for ( int adjNode: adj.get(node)){
            if ( !vis[node]) {
                if (dfs(adj, vis, pathVis, safeNodes, adjNode)) return true;
            }else if ( pathVis[adjNode]) return true;
        }
        pathVis[node] = false;
        safeNodes[node] = true;
        return false;
    }
}
