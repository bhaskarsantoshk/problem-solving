package takeUForward.graph;

import java.util.ArrayList;

public class G6DepthFirstSearchDFS {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean []vis = new boolean[V];
        for ( int i=0; i<V; i++) {
            if ( !vis[i] ) dfs(i, adj, vis, result);
        }
        return result;
    }

    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, ArrayList<Integer> result) {
        vis[node] = true;
        result.add(node);
        for ( int adjNode: adj.get(node)){
            if ( !vis[adjNode]) dfs(adjNode, adj, vis, result);
        }
    }

    // T: O(V+ summation of degrees) = O(V+2E), S: O(V)+ recusrion stack space worst case O(N)
}
