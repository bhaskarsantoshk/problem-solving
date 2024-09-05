package takeUForward.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class G17BipartiteGraphBFS {
    public boolean isBipartiteBFS(int V, ArrayList<ArrayList<Integer>>adj){
        int[] colors = new int[V];
        Arrays.fill(colors, -1);
        for ( int i=0; i<V; i++){
            if ( colors[i] == -1) {
                if (!checkBFS(i, 0, adj, colors)) return false;
            }
        }
        return false;
    }

    private boolean checkBFS(int source, int color, ArrayList<ArrayList<Integer>> adj, int[] colors) {
        colors[source] = color;
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        while (!q.isEmpty()){
            int node = q.poll();
            for ( int adjNode: adj.get(node)) {
                if (colors[adjNode] == -1) {
                    colors[adjNode] = 1 - colors[node];
                    q.offer(adjNode);
                } else if (colors[adjNode] == colors[node]) return false;
            }
        }
        return true;
    }
}
