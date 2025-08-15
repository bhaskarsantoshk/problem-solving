package takeUForward.graph.revision2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P12BipartiteGraph {
    public boolean isBipartite(int V, List<List<Integer>> adj) {
        int[] colors = new int[V];
        Arrays.fill(colors, -1);
        for ( int i=0; i<V; i++){
            if ( colors[i] == -1){
                if (!checkIfBiPartite(adj, i, colors)) return false;
            }
        }
        return true;
    }

    private boolean checkIfBiPartite(List<List<Integer>> adj, int start, int[] colors) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        colors[start] = 0;

        while ( !queue.isEmpty()){
            int node = queue.poll();
            for ( int adjNode: adj.get(node)){
                if ( colors[adjNode] == -1){
                    queue.offer(adjNode);
                    colors[adjNode] = 1- colors[node];
                } else {
                    if ( colors[node] == colors[adjNode]) return false;
                }
            }
        }
        return true;
    }

    public boolean isBipartiteDFS(int V, List<List<Integer>> adj) {
        int[] colors = new int[V];
        Arrays.fill(colors, -1);
        for ( int i=0; i<V; i++){
            if ( colors[i] == -1){
                if (!checkIfBiPartiteDFS(adj, i,0, colors)) return false;
            }
        }
        return true;
    }

    private boolean checkIfBiPartiteDFS(List<List<Integer>> adj, int node, int color, int[] colors) {
        colors[node] = color;
        for ( int adjNode: adj.get(node)){
            if ( colors[adjNode] == -1) {
                if (!checkIfBiPartiteDFS(adj, adjNode, 1 - color, colors)) return false;
            }
            else if ( colors[node] == colors[adjNode]) return false;
        }
        return true;
    }
}
