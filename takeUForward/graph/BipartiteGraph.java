package takeUForward.graph;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj) {
        int[] color = new int[V];
        Arrays.fill(color, -1);
        for ( int i=0; i<V; i++){
            if ( color[i] == -1){
                if (!check(i, V, adj, color)) return false;
            }
        }
        return true;
    }

    private boolean check(int start, int V, ArrayList<ArrayList<Integer>> adj, int[] color){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;
        while ( !q.isEmpty()){
            int node = q.poll();
            for ( int neighbour: adj.get(node)){
                if (color[neighbour] == -1){
                    color[neighbour] = 1- color[node];
                    q.offer(neighbour);
                } else {
                    if (color[neighbour] == color[node]) return false;
                }
            }
        }
        return true;
    }

    public boolean isBipartiteDFS(int V, ArrayList<ArrayList<Integer>>adj) {
        int[] color = new int[V];
        Arrays.fill(color, -1);
        for ( int i=0; i<V; i++){
            if ( color[i] == -1){
                if (!checkDFS(i, 0, V, adj, color)) return false;
            }
        }
        return true;
    }

    private boolean checkDFS(int node, int color, int V, ArrayList<ArrayList<Integer>> adj, int[] colors){
        colors[node] = color;
        for ( int adjNode: adj.get(node)){
            if ( colors[adjNode] == -1){
                if ( !checkDFS(adjNode, 1-color, V, adj, colors)) return false;
            } else if (colors[adjNode] == color) return false;
        }
        return true;
    }
}
