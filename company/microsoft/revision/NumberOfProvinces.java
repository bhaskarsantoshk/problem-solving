package company.microsoft.revision;

import java.util.ArrayList;
import java.util.List;

public class NumberOfProvinces {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
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
        int numOfProvinces = 0;
        boolean[] vis = new boolean[V];
        for ( int i=0; i<V; i++){
            if (!vis[i]){
                dfs(vis, adjacencyList, i );
                numOfProvinces++;
            }
        }
        return numOfProvinces;
    }

    private static void dfs(boolean[] vis, List<Integer>[] adj, int node) {
        vis[node] = true;
        for ( int adjNode: adj[node]){
            if(!vis[adjNode]){
                dfs(vis, adj, adjNode);
            }
        }
    }
}
