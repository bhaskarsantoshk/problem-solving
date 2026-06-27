package company.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindEventualSafeStates {
    public int[] eventualSafeNodes(int V, int[][] adj) {
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];
        List<Integer> res = new ArrayList<>();
        for ( int i=0; i<V; i++){
            if (!vis[i]) dfs(i, adj, vis,pathVis, res);
        }
        int[] ans = new int[res.size()];
        for ( int i=0; i<res.size(); i++) ans[i] = res.get(i);
        Arrays.sort(ans);
        return ans;
    }

    private boolean dfs(int node, int[][] adj, boolean[] vis, boolean[] pathVis, List<Integer> res) {
        vis[node] = pathVis[node] = true;
        for (int adjNode : adj[node]){
            if ( !vis[adjNode]){
                if (dfs(adjNode, adj, vis, pathVis, res)) return true;
            } else if ( pathVis[adjNode] ) return true;
        }
        pathVis[node] = false;
        res.add(node);
        return false;
    }
}
