package takeUForward.graph.revision2;

import java.util.List;

public class P14DetectACycleInADirectedGraph {
    public boolean isCyclic(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];
        for ( int i=0; i<V; i++){
            if ( !vis[i]){
                if ( isCyclicDFS(i, vis, pathVis, adj)) return true;
            }
        }
        return false;
    }

    private boolean isCyclicDFS(int node, boolean[] vis, boolean[] pathVis, List<List<Integer>> adj) {
        vis[node] = true;
        pathVis[node] = true;
        for ( int adjNode: adj.get(node)){
            if ( !vis[adjNode] ){
                if (isCyclicDFS(adjNode, vis, pathVis, adj)) return true;
            }
            else if ( pathVis[adjNode]) return true;
        }
        pathVis[node] = false;
        return false;
    }
}
