package takeUForward.graph.revision;

import java.util.ArrayList;
import java.util.List;

public class P1ConnectedComponents {
    public int findNumberOfComponent(int V, List<List<Integer>> edges) {
        int [] vis = new int[V];
        List<List<Integer>> G = new ArrayList<>();
        for ( int i=0; i<V; i++) G.add(new ArrayList<>());
        for ( List<Integer> edge: edges){
            G.get(edge.get(0)).add(edge.get(1));
            G.get(edge.get(1)).add(edge.get(0));
        }
        int connectedComponents = 0;
        for ( int i=0; i < V; i++){
            if ( vis[i] == 0){
                connectedComponents++;
                dfs(G, vis, i);
            }
        }
        return connectedComponents;
    }

    private void dfs(List<List<Integer>> graph, int[] vis, int i) {
        vis[i] = 1;
        for ( int node: graph.get(i) ){
            if ( vis[node] == 0) dfs(graph, vis, node);
        }
    }
}
