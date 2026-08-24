package takeUForward.graph.revision4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class G20FindEventualSafeStatesDFS {
    public int[] eventualSafeNodes(int V, int[][] adj) {
        List<Integer> safeNodes = new ArrayList<>();
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];
        for ( int i=0; i<V; i++){
            if (!vis[i]) dfs(i, adj, vis, pathVis, safeNodes);
        }
        Collections.sort(safeNodes);
        return safeNodes.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean dfs(int node, int[][] adj, boolean[] vis, boolean[] pathVis, List<Integer> safeNodes) {
        vis[node] = pathVis[node] = true;
        for ( int adjNode: adj[node]){
            if (!vis[adjNode]){
                if (!dfs(adjNode, adj, vis, pathVis, safeNodes)) return false;
            } else if ( pathVis[adjNode]) return false;
        }
        pathVis[node] = false;
        safeNodes.add(node);
        return true;
    }
}
