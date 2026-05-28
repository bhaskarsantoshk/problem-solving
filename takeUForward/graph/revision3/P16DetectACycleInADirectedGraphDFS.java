package takeUForward.graph.revision3;

import java.util.List;

public class P16DetectACycleInADirectedGraphDFS {
    public boolean isCyclic(int N, List<List<Integer>> adj) {
        boolean[] vis = new boolean[N];
        boolean[] pathVis = new boolean[N];
        for ( int i=0; i<N; i++){
            if ( !vis[i]){
                if ( dfs(i, vis, pathVis, adj)) return true;
            }
        }
        return false;
    }

    private boolean dfs(int i, boolean[] vis, boolean[] pathVis, List<List<Integer>> g) {
        vis[i] = true;
        pathVis[i] = true;
        for ( int adjNode: g.get(i)){
            if (!vis[adjNode]){
                if ( dfs(adjNode, vis, pathVis, g)) return true;
            } else if ( pathVis[adjNode]) return true;
        }
        pathVis[i] = false;
        return false;
    }
}
