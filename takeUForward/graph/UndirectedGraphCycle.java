package takeUForward.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class UndirectedGraphCycle {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean []vis = new boolean[V];
        for ( int i=0; i<V; i++){
            if ( !vis[i]){
                if ( isCycleBFS(adj, vis, i, V)) return true;
            }
        }
        return false;
    }

    private boolean isCycleBFS(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int src, int V) {
        Queue<int[]> q = new LinkedList<>();
        vis[src] = true;
        q.offer(new int[]{src, -1});
        while ( !q.isEmpty()){
            int[] pair = q.poll();
            int node = pair[0], parent = pair[1];
            for( int adjNode: adj.get(node)){
                if ( !vis[adjNode]){
                    vis[adjNode] = true;
                    q.offer(new int[]{adjNode, node});
                } else {
                    if (adjNode != parent) return true;
                }
            }
        }
        return false;
    }

    public boolean isCycleDFS(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean []vis = new boolean[V];
        for ( int i=0; i<V; i++){
            if ( !vis[i]){
                if ( isCycleDFS(adj, vis, i,-1)) return true;
            }
        }
        return false;
    }

    private boolean isCycleDFS(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int node, int parent) {
        vis[node] = true;
        for ( int adjNode: adj.get(node)){
            if ( !vis[adjNode]) {
                if ( isCycleDFS(adj, vis, adjNode, node)) return true;
            }else if(adjNode != parent) return true;
        }
        return false;
    }
}
