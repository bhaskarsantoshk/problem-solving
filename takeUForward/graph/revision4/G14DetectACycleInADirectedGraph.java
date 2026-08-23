package takeUForward.graph.revision4;

import java.util.List;

public class G14DetectACycleInADirectedGraph {
    public boolean isCyclic(int N, List<List<Integer>> adj) {
        boolean[] vis = new boolean[N];
        boolean[] pathVis = new boolean[N];
        for ( int i=0; i<N; i++){
            if (!vis[i]) if ( dfs( i, vis, pathVis, adj)) return true;
        }
        return false;
    }

    private boolean dfs(int node, boolean[] vis, boolean[] pathVis, List<List<Integer>> adj) {
        vis[node] = true;
        pathVis[node] = true;
        for ( int adjNode: adj.get(node)){
            if ( vis[adjNode] && pathVis[adjNode]) return true;
            else {
                if (dfs(adjNode, vis, pathVis, adj)) return true;
            }
        }
        pathVis[node] = false;
        return false;
    }
}
