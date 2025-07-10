package takeUForward.graph.revision.traversal_probelms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P3NumberOfProvinces {
    public int numProvinces(int[][] adj) {
        int V = adj.length;
        List<List<Integer>> graph = new ArrayList<>();
        for ( int i=0; i<V; i++){
            graph.add(new ArrayList<>());
        }
        for ( int i=0; i<V; i++){
            for ( int j=0; j<adj[0].length; j++){
                if ( adj[i][j] == 1){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        int []vis = new int[V];
        int numProvinces = 0;
        for ( int i=0; i<V; i++){
            if ( vis[i] == 0){
                bfs(graph, i, vis);
                numProvinces++;
            }
        }
        return numProvinces;
    }

    private void bfs(List<List<Integer>> graph, int i, int[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        vis[i] = 1;
        while ( !q.isEmpty()){
            int node = q.poll();
            for ( int neighbour: graph.get(node)){
                if ( vis[neighbour] == 0){
                    q.offer(neighbour);
                    vis[neighbour] = 1;
                }
            }
        }
    }
}
