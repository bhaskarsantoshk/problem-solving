package company.microsoft.revision;

import java.util.ArrayList;

public class DFS {
    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean vis[] = new boolean[adj.size()];
        dfs(dfs, adj, 0, vis);
        return dfs;
    }

    private void dfs(ArrayList<Integer> dfs,
                     ArrayList<ArrayList<Integer>> adj, int node, boolean[] vis){
        vis[node] = true;
        dfs.add(node);
        for ( int adjNode: adj.get(node)){
            if(!vis[adjNode]){
                dfs(dfs, adj, adjNode, vis);
            }
        }
    }
}
