package takeUForward.graph.revision3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P22FindEventualSafeStates {
    public int[] eventualSafeNodes(int V, int[][] adj) {
        List<Integer> res = new ArrayList<>();
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];

        for(int i=0; i<V; i++){
            if ( !vis[i]){
                dfs(i, adj, vis, pathVis, res);
            }
        }

        int[] result = new int[res.size()];
        int index = 0;
        for ( int num: res) result[index++] = num;
        Arrays.sort(result);
        return result;
    }

    private boolean dfs(int node, int[][] adj, boolean[] vis, boolean[] pathVis, List<Integer> res) {
        vis[node] = pathVis[node] = true;
        for ( int adjNode: adj[node]){
            if ( !vis[adjNode]){
                if ( dfs(adjNode, adj, vis, pathVis, res)) return true;
            } else if ( pathVis[adjNode]) return true;
        }
        pathVis[node] = false;
        res.add(node);
        return false;
    }
}
