package company.amazon;

import java.util.ArrayList;

public class CycleDetectionInUndirectedGraphUsingDFS {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean [] visited = new boolean[V];
        for ( int i=0; i<V; i++){
            if ( !visited[i] && dfs(i,-1, V, adj, visited)) return true;
        }
        return false;
    }

    private boolean dfs(int src, int v, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[src] = true;
        for ( int adjNode: adj.get(src)){
            if ( !visited[adjNode] ){
                if ( dfs(adjNode, v, src, adj, visited)) return true;
            } else {
                if ( parent != adjNode) return true;
            }
        }
        return false;
    }
}
