package company.amazon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CycleDetectionInUndirectedGraphUsingBFS {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V];
        for ( int i=0; i<V; i++){
            if ( !vis[i]) {
                if (checkForCycle(i, V, adj, vis)) return true;
            }
        }
        return false;
    }

    private boolean checkForCycle(int src, int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[src] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{src, -1});
        while ( !queue.isEmpty()){
            int [] pair = queue.poll();
            int node = pair[0], parentNode = pair[1];
            for ( int adjNode : adj.get(node)){
                if ( !vis[adjNode]){
                    vis[adjNode] = true;
                    queue.offer(new int[]{adjNode, node});
                } else {
                    if ( adjNode != parentNode) return true;
                }
            }
        }
        return false;
    }
}
