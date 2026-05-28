package takeUForward.graph.revision3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P4NumberOfProvinces {
    public int numProvinces(int[][] adj) {
        int n = adj.length;
        List<Integer>[] g = new ArrayList[n];
        for ( int i=0; i<n; i++) g[i] = new ArrayList<>();
        for ( int i=0; i<n; i++){
            for ( int j=0; j<n; j++){
                if ( i!=j && adj[i][j] == 1){
                    g[i].add(j);
                }
            }
        }

        boolean[] vis = new boolean[n];
        int count = 0;
        for ( int i=0; i<n; i++){
            if ( !vis[i]){
                bfs(i, g, vis);
                count++;
            }
        }
        return count;
    }

    private void bfs(int node, List<Integer>[] g, boolean[] vis) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        vis[node] = true;

        while (!queue.isEmpty()){
            node = queue.poll();
            for ( int adjNode: g[node]){
                if ( !vis[adjNode]){
                    vis[adjNode] = true;
                    queue.offer(adjNode);
                }
            }
        }
    }
}
