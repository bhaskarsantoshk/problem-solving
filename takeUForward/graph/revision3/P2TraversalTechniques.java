package takeUForward.graph.revision3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P2TraversalTechniques {
    public List<Integer> dfsOfGraph(int V, List<List<Integer>> edges) {
        List<Integer>[] G = new ArrayList[V];
        for ( int i=0; i<V; i++) G[i] = new ArrayList<>();
        for ( List<Integer> edge: edges){
            int u = edge.get(0);
            int v = edge.get(1);
            G[u].add(v);
            G[v].add(u);
        }

        List<Integer> dfsList = new ArrayList<>();
        boolean[] vis = new boolean[V];
        for ( int i=0; i<V; i++){
            if ( !vis[i]) dfs(i, G, vis, dfsList);
        }
        return dfsList;
    }

    private void dfs(int node, List<Integer>[] g, boolean[] vis, List<Integer> dfsList) {
        vis[node] = true;
        dfsList.add(node);
        for ( int adjNode: g[node]){
            if ( !vis[adjNode]) dfs(adjNode, g, vis, dfsList);
        }
    }

    /*
    DFS
     * Time: O(V + E)
     * Space:
     * graph O(V + E)
     * visited O(V)
     * recursion stack worst O(V)
     */

    public List<Integer> bfsOfGraph(int V, List<List<Integer>> edges) {
        List<Integer>[] G = new ArrayList[V];
        for ( int i=0; i<V; i++) G[i] = new ArrayList<>();
        for ( List<Integer> edge: edges){
            int u = edge.get(0);
            int v = edge.get(1);
            G[u].add(v);
            G[v].add(u);
        }

        List<Integer> bfsList = new ArrayList<>();
        boolean[] vis = new boolean[V];
        for ( int i=0; i<V; i++){
            if ( !vis[i]) bfs(i, G, vis, bfsList);
        }
        return bfsList;
    }

    private void bfs(int node, List<Integer>[] g, boolean[] vis, List<Integer> bfsList) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        vis[node] = true;
        while ( !queue.isEmpty()){
            node = queue.poll();
            bfsList.add(node);
            for ( int adjNode: g[node]){
                if ( !vis[adjNode]){
                    queue.offer(adjNode);
                    vis[adjNode] = true;
                }
            }
        }
    }
    /*
    BFS

* Time: O(V + E)
* Space:
    * graph O(V + E)
    * visited O(V)
    * queue worst O(V)
     */
}
