package takeUForward.graph.revision;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P2TraversalTechniques {
    public List<Integer> dfsOfGraph(int V, List<List<Integer>> adj) {
       int [] vis = new int[V];
        List<Integer> res = new ArrayList<>();
       for ( int i=0; i<V; i++){
           if ( vis[i] == 0){
               dfs(adj, vis, i, res);
           }
       }
       return res;
    }

    private void dfs(List<List<Integer>> adj, int[] vis, int i, List<Integer> res) {
        vis[i] = 1;
        res.add(i);
        for ( int node: adj.get(i)){
            if ( vis[node] == 0) dfs(adj, vis, node, res);
        }
    }

    public List<Integer> bfsOfGraph(int V, List<List<Integer>> adj) {
        List<Integer> res = new ArrayList<>();
        boolean[] vis = new boolean[V];
        for ( int i=0; i<V; i++){
            if ( !vis[i]) {
                bfs(adj, vis, i, res);
            }
        }
        return res;
    }

    private void bfs(List<List<Integer>> adj, boolean[] vis, int i, List<Integer> res) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        vis[i] = true;
        while (!q.isEmpty()){
            int node = q.poll();
            res.add(node);
            for ( int neighbour: adj.get(node)){
                if ( !vis[neighbour]){
                    q.offer(neighbour);
                    vis[neighbour] = true;
                }
            }
        }
    }
}
