package takeUForward.graph.traversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberOfProvinces {
    public int numProvinces(int[][] adj) {
        List<Integer>[] G = getGraph(adj);
        boolean[] vis = new boolean[G.length];
        int count = 0;
        for ( int i=0; i<G.length; i++){
            if ( !vis[i]){
                bfs(i, G, vis);
                count++;
            }
        }
        return count;
    }

    private void bfs(int i, List<Integer>[] g, boolean[] vis) {
        Queue<Integer> q= new LinkedList<>();
        vis[i] = true;
        q.offer(i);
        while ( !q.isEmpty()){
            int node = q.poll();
            for ( int adjNode: g[node] ){
                if ( !vis[adjNode] ) {
                    vis[adjNode] = true;
                    q.offer(adjNode);
                }
            }
        }
    }

    private List<Integer>[] getGraph(int[][] adj) {
        List<Integer>[] G = new ArrayList[adj.length];
        for ( int i=0; i<adj.length; i++) G[i] = new ArrayList<>();
        for ( int i=0; i<adj.length; i++){
            for ( int j=0; j<adj[0].length; j++){
                if ( adj[i][j] == 1) {
                    G[i].add(j);
                    G[j].add(i);
                }
            }
        }
        return G;
    }
}
