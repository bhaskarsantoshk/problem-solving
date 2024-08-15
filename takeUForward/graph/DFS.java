package takeUForward.graph;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> dfs = new ArrayList<>();
        boolean []vis = new boolean[V];
        vis[0] = true;
        dfs(0, vis, dfs, adj);
        return dfs;
    }

    private void dfs(int node, boolean[] vis, ArrayList<Integer> dfs, ArrayList<ArrayList<Integer>> adj) {
        dfs.add(node);
        for ( int neighbour: adj.get(node)){
            if ( !vis[neighbour]) {
                vis[neighbour] = true;
                dfs(neighbour, vis, dfs, adj);
            }
        }
    }
}
