package takeUForward.google;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceLeadToDestination {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> g = buildGraph(edges, n);
        int[] color = new int[n]; // -1 or partially processed, 1 for fully processed
        return leadsToDestination(n, g, source, destination, color);
    }

    private boolean leadsToDestination(int n, List<List<Integer>> g, int node, int destination, int[] col) {
        // fully processed and still encountered , cycle
        if ( col[node] != 0 ) return col[node] == 1;
        if ( g.get(node).isEmpty()) return node == destination;
        col[node] = -1;
        for ( int next: g.get(node)){
            if ( !leadsToDestination(n, g, next, destination, col)) return false;
        }
        col[node] = 1;
        return true;
    }

    private List<List<Integer>> buildGraph(int[][] edges, int n) {
        List<List<Integer>> g = new ArrayList<>();
        for ( int i=0; i<n; i++) g.add(new ArrayList<>());
        for ( int[] edge : edges) g.get(edge[0]).add(edge[1]);
        return g;
    }
}
