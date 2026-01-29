package takeUForward.graph.cycles;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BipartiteGraph {
    public boolean isBipartite(int V, List<List<Integer>> adj) {
        int[] color = new int[V];
        Arrays.fill(color, -1);
        for ( int i=0; i<V; i++){
            if ( color[i] == -1){
                if ( !isBipartite(i, adj, color)) return false;
            }
        }
        return true;
    }

    private boolean isBipartite(int i, List<List<Integer>> adj, int[] color) {
        color[i] += 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        while ( !queue.isEmpty()){
            int node = queue.poll();
            for ( int adjNode: adj.get(node)){
                if (color[adjNode] == -1){
                    color[adjNode] = 1- color[node];
                    queue.offer(adjNode);
                } else {
                    if ( color[adjNode] == color[node]) return false;
                }
            }
        }
        return true;
    }


    public boolean isBipartiteDFS(int V, List<List<Integer>> adj) {
        int[] color = new int[V];
        Arrays.fill(color, -1);
        for ( int i=0; i<V; i++){
            if ( color[i] == -1){
                if ( !isBipartiteDFS(i, adj, color, 0)) return false;
            }
        }
        return true;
    }

    private boolean isBipartiteDFS(int node, List<List<Integer>> adj, int[] color, int col) {
        color[node] = col;
        for ( int adjNode: adj.get(node)){
            if ( color[adjNode] == -1){
                if ( !isBipartiteDFS(adjNode,adj, color, 1-col )) return false;
            } else if ( color[adjNode] == col) return false;
        }
        return true;
    }
}
