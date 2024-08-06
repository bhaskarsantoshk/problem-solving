package company.google;

import java.util.*;

public class P785IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int [] colors = new int[graph.length];
        Arrays.fill(colors, -1);
        for ( int i=0; i<graph.length; i++){
            if ( colors[i] == -1){
                if (!check(i, graph.length, colors, graph)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean check(int src, int length, int[] colors, int[][] graph) {
        Queue<Integer> queue = new LinkedList<>();
        colors[src] = 0;
        queue.offer(src);
        while ( !queue.isEmpty()){
            int node = queue.poll();
            for ( int adjNode: graph[node]){
                if ( colors[adjNode] == -1){
                    colors[adjNode] = 1 - colors[node];
                    queue.offer(adjNode);
                } else if (colors[node] == colors[adjNode]){
                    return false;
                }
            }
        }
        return true;
    }
}
