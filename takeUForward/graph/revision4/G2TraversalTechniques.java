package takeUForward.graph.revision4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class G2TraversalTechniques {
    public List<Integer> dfsOfGraph(int V, List<List<Integer>> edges) {
        List<Integer>[] graph = buildGraph(edges, V);
        List<Integer> dfsList = new ArrayList<>();
        boolean[] vis = new boolean[V];
        for ( int i=0; i<V; i++){
            if (!vis[i]) dfs(i, graph, vis, dfsList);
        }
        return dfsList;
    }

    private void dfs(int node, List<Integer>[] graph, boolean[] vis, List<Integer> dfsList) {
        vis[node] = true;
        dfsList.add(node);
        for ( int adjNode: graph[node]){
            if (!vis[adjNode]) dfs(adjNode, graph, vis, dfsList);
        }
    }

    private List<Integer>[] buildGraph(List<List<Integer>> edges, int V) {
        List<Integer>[] graph = new ArrayList[V];
        for ( int i=0; i<V; i++) graph[i] = new ArrayList<>();
        for ( List<Integer> edge : edges){
            int u = edge.get(0), v = edge.get(1);
            graph[u].add(v);
            graph[v].add(u);
        }
        return graph;
    }

    public List<Integer> bfsOfGraph(int V, List<List<Integer>> edges) {
        List<Integer>[] graph = buildGraph(edges, V);
        List<Integer> bfsList = new ArrayList<>();
        boolean[] vis = new boolean[V];
        for ( int i=0; i<V; i++){
            if (!vis[i]) bfs(i, graph, vis, bfsList);
        }
        return bfsList;
    }

    private void bfs(int node, List<Integer>[] graph, boolean[] vis, List<Integer> bfsList) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        vis[node] = true;

        while (!queue.isEmpty()){
            node = queue.poll();
            bfsList.add(node);
            for ( int adjNode: graph[node]){
                if (!vis[adjNode]){
                    queue.offer(adjNode);
                    vis[adjNode] = true;
                }
            }
        }
    }
}
