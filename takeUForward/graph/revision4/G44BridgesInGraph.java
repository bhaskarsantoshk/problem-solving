package takeUForward.graph.revision4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class G44BridgesInGraph {
    private int timer = 1;
    public List<List<Integer>> criticalConnections(int V, List<List<Integer>> E) {
        List<Integer>[] g = new ArrayList[V];
        for ( int i=0; i<V; i++) g[i] = new ArrayList<>();
        for ( List<Integer> edge: E){
            int u = edge.get(0), v = edge.get(1);
            g[u].add(v);
            g[v].add(u);
        }

        int [] vis = new int[V];
        int [] tin = new int[V];
        int [] low = new int[V];

        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0, -1, vis, g, tin, low, bridges);
        return bridges;
    }

    private void dfs(int node, int parent, int[] vis, List<Integer>[] g, int[] tin, int[] low, List<List<Integer>> bridges) {
        vis[node] = 1;
        tin[node] = low[node] = timer;
        timer++;
        for ( int adjNode: g[node]){
            if ( adjNode == parent) continue;
            if ( vis[adjNode] == 0){
                dfs(adjNode, node, vis, g, tin, low, bridges);
                low[node] = Math.min(low[node], low[adjNode]);
                if ( low[adjNode] > tin[node]){
                    bridges.add(Arrays.asList(node, adjNode));
                }
            } else {
                low[node] = Math.min(low[node], low[adjNode]);
            }
        }
    }
}
