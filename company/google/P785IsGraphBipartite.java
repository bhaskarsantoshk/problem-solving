package company.google;

import java.util.*;

public class P785IsGraphBipartite {
    public boolean isBipartiteBFS(int[][] graph) {
        int [] colors = new int[graph.length];
        Arrays.fill(colors, -1);
        for ( int i=0; i<graph.length; i++){
            if ( colors[i] == -1){
                if (!checkBFS(i, graph.length, colors, graph)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkBFS(int src, int length, int[] colors, int[][] graph) {
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

    public boolean isBipartiteDFS(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);
        for ( int i=0; i<graph.length; i++){
            if ( colors[i] == -1 ) if (!dfs(graph, i, colors, 0)) return false;
        }
        return true;
    }

    private boolean dfs(int[][] graph, int i, int[] colors, int color) {
        colors[i] = color;
        for ( int adjNode: graph[i]){
            if ( colors[adjNode] == -1) {
                if (!dfs(graph, adjNode, colors, 1 - color)) return false;
            } else if ( colors[adjNode] == color) return false;
        }
        return true;
    }
}
