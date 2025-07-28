package takeUForward.graph.revision2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P2TraversalTechniques {
    public List<Integer> dfsOfGraph(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V];
        List<Integer> result = new ArrayList<>();
        for ( int i=0; i<V; i++){
            if ( !vis[i]) dfs(i, vis, adj, result);
        }
        return result;
    }

    private void dfs(int i, boolean[] vis, List<List<Integer>> adj, List<Integer> result) {
        result.add(i);
        vis[i] = true;
        for ( int node: adj.get(i)){
            if ( !vis[node]) dfs(node, vis, adj, result);
        }
    }

    public List<Integer> bfsOfGraph(int V, List<List<Integer>> adj) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[V];
        for (int i=0; i<V; i++){
            if ( !vis[i]){
                q.offer(i);
                vis[i] = true;
                while ( !q.isEmpty()){
                  int node = q.poll();
                  result.add(node);
                  for ( int neighbour: adj.get(node)){
                      if ( !vis[neighbour]) {
                          q.offer(neighbour);
                          vis[neighbour] = true;
                      }
                  }
                }
            }
        }
        return result;
    }
}
