package takeUForward.graph.traversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Traversals {
    public List<Integer> dfsOfGraph(int V, List<List<Integer>> adj) {
        List<Integer> dfs = new ArrayList<>();
        boolean[] vis = new boolean[V];
        for ( int i=0; i<V; i++){
            if ( !vis[i]){
                dfs(adj, i, dfs, vis);
            }
        }
        return dfs;
    }

    private void dfs(List<List<Integer>> adj, int i, List<Integer> dfs, boolean[] vis) {
        vis[i] = true;
        dfs.add(i);
        for ( int adjNode : adj.get(i)){
            if ( !vis[adjNode]) dfs(adj, adjNode, dfs, vis);
        }
    }

    public List<Integer> bfsOfGraph(int V, List<List<Integer>> adj) {
        List<Integer> bfs = new ArrayList<>();
        boolean[] vis = new boolean[V];
        for ( int i=0; i<V; i++){
            if ( !vis[i]){
                bfs(adj, vis, bfs, i);
            }
        }
        return bfs;
    }

    private void bfs(List<List<Integer>> adj, boolean[] vis, List<Integer> bfs, int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        vis[node] = true;
        while ( !queue.isEmpty()){
            node = queue.poll();
            bfs.add(node);
            for ( int adjNode: adj.get(node)){
                if ( !vis[adjNode]){
                    queue.offer(adjNode);
                    vis[adjNode] = true;
                }
            }
        }
    }
}
