package takeUForward.graph.revision2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P11DetectACycleInAnUndirectedGraph {
    public boolean isCycle(int V, List<Integer>[] adj) {
        boolean [] vis = new boolean[V];
        for ( int i=0; i<V; i++){
            if ( !vis[i] && bfsIsCycle(adj, i, vis)) return true;
        }
        return false;
    }

    private boolean bfsIsCycle(List<Integer>[] adj, int src, boolean[] vis) {
        vis[src] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, -1});
        while ( !queue.isEmpty()){
            int[] pair = queue.poll();
            int node = pair[0];
            int parent = pair[1];

            for (int adjNode: adj[node]){
                if ( !vis[adjNode]){
                    vis[adjNode] = true;
                    queue.offer(new int[]{adjNode, node});
                } else if ( parent != adjNode){
                    return true;
                }
            }
        }
        return false;
    }
}
