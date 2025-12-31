package takeUForward.graph.traversals;

import java.util.ArrayList;
import java.util.List;

public class ConnectedComponents {
    public int findNumberOfComponent(int V, List<List<Integer>> edges) {
        List<List<Integer>> G = createGraph(V, edges);
        boolean[] vis = new boolean[V];
        int count = 0;
        for ( int i=0; i<V; i++){
            if ( !vis[i] ) {
                dfs(i, G, vis);
                count++;
            }
        }
        return count;
    }

    private List<List<Integer>> createGraph(int v, List<List<Integer>> edges) {
        List<List<Integer>> G = new ArrayList<>();
        for ( int i=0; i<v; i++) G.add(new ArrayList<>());
        for ( int i=0; i<edges.size(); i++){
            G.get(edges.get(i).get(0)).add(edges.get(i).get(1));
            G.get(edges.get(i).get(1)).add(edges.get(i).get(0));
        }
        return G;
    }

    private void dfs(int node, List<List<Integer>> G, boolean[] vis) {
        vis[node] = true;
        for ( int adjNode: G.get(node)){
            if ( !vis[adjNode]) dfs(adjNode, G, vis );
        }
    }
}
