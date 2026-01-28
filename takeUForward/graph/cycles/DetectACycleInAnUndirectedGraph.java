package takeUForward.graph.cycles;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectACycleInAnUndirectedGraph {
    public boolean isCycle(int V, List<Integer>[] adj) {
      boolean[] vis = new boolean[V];
      for (int i=0; i<V; i++){
          if ( !vis[i]){
              if ( isCycle(i, adj, vis)){
                  return true;
              }
          }
      }
      return false;
    }

    private boolean isCycle(int source, List<Integer>[] adj, boolean[] vis) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{source, -1});
        vis[source] = true;
        while ( !queue.isEmpty()){
            int[] nodeArr = queue.poll();
            int parent = nodeArr[1];
            int node = nodeArr[0];
            for ( int adjNode: adj[node]){
                if ( !vis[adjNode]){
                    vis[adjNode] = true;
                    queue.offer(new int[]{adjNode, node});
                } else {
                    if ( adjNode != parent) return true;
                }
            }
        }
        return false;
    }

    public boolean isCycleDFS(int V, List<Integer>[] adj) {
        boolean[] vis = new boolean[V];
        for (int i=0; i<V; i++){
            if ( !vis[i]){
                if ( isCycleDFS(i, adj, vis, -1)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isCycleDFS(int node, List<Integer>[] adj, boolean[] vis, int parent) {
        vis[node] = true;
        for ( int adjNode: adj[node]){
            if ( !vis[adjNode]){
                if ( isCycleDFS(adjNode, adj, vis, node)) return true;
            } else {
                if ( adjNode != parent) return true;
            }
        }
        return false;
    }
}
