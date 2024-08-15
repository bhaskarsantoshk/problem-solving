package takeUForward.graph;

import java.util.ArrayList;
import java.util.List;

public class NumberOfProvinces {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        int numberOfProvinces = 0;
        List<Integer>[] adjacencyList = new ArrayList[V];
        for ( int i=0; i<V; i++){
            adjacencyList[i] = new ArrayList<>();
        }
        for ( int i=0; i<V; i++){
            for ( int j=0; j<V; j++){
                if ( adj.get(i).get(j) == 1 && i!= j){
                    adjacencyList[i].add(j);
                    adjacencyList[j].add(i);
                }
            }
        }
        boolean[] vis = new boolean[V];
        for ( int i=0; i<V; i++){
            if ( !vis[i]){
                dfs( i, vis, adjacencyList);
                numberOfProvinces++;
            }
        }
        return numberOfProvinces;
    }

    private static void dfs(int node, boolean[] vis, List<Integer>[] adj) {
        vis[node] = true;
        for ( int neighbour: adj[node]){
            if ( !vis[neighbour]){
                dfs(neighbour, vis, adj);
            }
        }
    }
}
