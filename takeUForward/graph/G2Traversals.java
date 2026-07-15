package takeUForward.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class G2Traversals {
    public List<Integer> dfsOfGraph(int V, List<List<Integer>> edges) {
        List<Integer>[] g = new ArrayList[V];
        for ( int i=0; i<V; i++) g[i] = new ArrayList<>();
        for ( List<Integer> edge: edges){
            int u = edge.get(0);
            int v = edge.get(1);
            g[u].add(v);
            g[v].add(u);
        }

        boolean[] vis = new boolean[V];
        List<Integer> dfsList = new ArrayList<>();
        for ( int i=0; i<V; i++) if (!vis[i]) dfs(i, vis, g, dfsList);

        return dfsList;
    }

    private void dfs(int node, boolean[] vis, List<Integer>[] g,  List<Integer> dfsList) {
        vis[node] = true;
        dfsList.add(node);
        for ( int adjNode: g[node]){
            if (!vis[adjNode]) dfs(adjNode, vis, g, dfsList);
        }
    }

    public List<Integer> bfsOfGraph(int V, List<List<Integer>> edges) {
        List<Integer>[] g = new ArrayList[V];
        for ( int i=0; i<V; i++) g[i] = new ArrayList<>();
        for ( List<Integer> edge: edges){
            int u = edge.get(0);
            int v = edge.get(1);
            g[u].add(v);
            g[v].add(u);
        }

        boolean[] vis = new boolean[V];
        List<Integer> bfsList = new ArrayList<>();
        for ( int i=0; i<V; i++) if (!vis[i]) bfs(i, vis, g, bfsList);

        return bfsList;

    }

    private void bfs(int node, boolean[] vis, List<Integer>[] g, List<Integer> bfsList) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        vis[node] = true;

        while (!queue.isEmpty()){
            node = queue.poll();
            bfsList.add(node);
            for (int adjNode: g[node]){
                if (!vis[adjNode]) {
                    queue.offer(adjNode);
                    vis[adjNode] = true;
                }
            }
        }
    }
}
