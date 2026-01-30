package takeUForward.graph.cycles;

import java.util.List;

public class DetectACycleInADirectedGraph {
    public boolean isCyclic(int N, List<List<Integer>> adj) {
       boolean[] vis = new boolean[N];
        boolean[] path = new boolean[N];
       for ( int i=0; i<N; i++){
           if ( dfs(i, adj, vis, path)) return true;
       }
       return false;
    }

    private boolean dfs(int node, List<List<Integer>> adj, boolean[] vis, boolean[] path ){
        vis[node] = true;
        path[node] = true;
        for ( int adjNode: adj.get(node)){
            if ( !vis[adjNode]){
                if ( dfs(adjNode, adj, vis, path)) return true;
            } else {
               if ( path[adjNode] == true) return true;
            }
        }
        path[node] = false;
        return false;
    }
}
