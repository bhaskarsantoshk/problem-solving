package takeUForward.graph.revision3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P46BridgesInGraph {

    private int timer = 1;

    public List<List<Integer>> criticalConnections(int V, List<List<Integer>> edges) {
        List<Integer>[] g = new ArrayList[V];
        for ( int i=0; i<V; i++) g[i] = new ArrayList<>();
        for ( List<Integer> edge : edges){
            int u = edge.get(0);
            int v = edge.get(1);
            g[u].add(v);
            g[v].add(u);
        }

        int []low = new int[V];
        int []time = new int[V];
        boolean[] vis = new boolean[V];
        List<List<Integer>> bridges = new ArrayList<>();
        dfs( 0, -1, vis, g, time, low, bridges);
        return bridges;
    }

    private void dfs(int node, int parent, boolean[] vis, List<Integer>[] g, int[] time, int[] low, List<List<Integer>> bridges) {
        vis[node] = true;
        time[node] = low[node] = timer;
        timer++;
        for ( int adjNode: g[node]){
            if (adjNode == parent) continue;
            if (!vis[adjNode]) {
                dfs( adjNode, node, vis, g, time, low, bridges);
                low[node] = Math.min(low[node], low[adjNode]);
                if ( low[adjNode] > time[node]) bridges.add(Arrays.asList(node, adjNode));
            } else {
                low[node] = Math.min(low[node], low[adjNode]);
            }

        }
    }
}
