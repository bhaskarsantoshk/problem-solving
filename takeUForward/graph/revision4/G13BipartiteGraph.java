package takeUForward.graph.revision4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class G13BipartiteGraph  {
    public boolean isBipartite(int V, List<List<Integer>> edges) {
        List<Integer>[] g = buildGraph(edges, V);
        int [] color = new int[V];
        Arrays.fill(color, -1);
        for ( int i=0; i<V; i++){
            if ( color[i] == -1) {
                color[i] = 0;
                if ( !dfs( i, g, color) ) return false;
            }
        }
        return true;
    }

    private boolean dfs(int node, List<Integer>[] g, int[] color) {
        for ( int adjNode: g[node]){
            if ( color[adjNode] == -1 ){
                color[adjNode] = 1 - color[node];
                dfs(adjNode, g, color);
            } else if ( color[adjNode] == color[node]) return false;
        }

        return true;
    }

    private List<Integer>[] buildGraph(List<List<Integer>> edges, int V) {
        List<Integer>[] graph = new ArrayList[V];
        for ( int i=0; i<V; i++) graph[i] = new ArrayList<>();
        for(List<Integer> edge : edges){
            int u = edge.get(0), v = edge.get(1);
            graph[u].add(v);
            graph[v].add(u);
        }
        return graph;
    }
}
