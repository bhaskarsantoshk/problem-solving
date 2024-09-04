package takeUForward.graph;

import java.util.Arrays;

public class P785IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);
        for ( int i=0; i<graph.length; i++){
            if ( colors[i] != -1) continue;
            if ( !dfs(i, graph, colors, 0)) return false;
        }
        return true;
    }

    private boolean dfs(int i, int[][] graph, int[] colors, int color) {
        colors[i] = color;

        for ( int adjNode: graph[i]){
            if ( colors[adjNode] == color) return false;
            if ( colors[adjNode] != -1) continue;
            if ( !dfs(adjNode, graph, colors, 1-color)) return false;
        }
        return true;
    }
}
