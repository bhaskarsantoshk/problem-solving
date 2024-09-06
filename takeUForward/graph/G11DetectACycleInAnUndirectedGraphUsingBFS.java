package takeUForward.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class G11DetectACycleInAnUndirectedGraphUsingBFS {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        for ( int i=0; i<V; i++){
            if ( !vis[i]){
                if ( isCycleBFS(i, adj, vis)) return true;
            }
        }
        return false;
    }

    private boolean isCycleBFS(int source, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        Queue<int[]> q = new LinkedList<>(); // [ node, parent ]
        q.offer(new int[]{source, -1});
        vis[source] = true;
        while ( !q.isEmpty()){
            int[] pair = q.poll();
            int node = pair[0];
            int parent = pair[1];

            for ( int adjNode : adj.get(node)){
                if ( !vis[adjNode]) {
                    q.offer(new int[]{adjNode, node});
                } else {
                    if ( adjNode != parent) return true;
                }
            }
        }
        return false;
    }
}
