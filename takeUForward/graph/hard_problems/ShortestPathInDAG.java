package takeUForward.graph.hard_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortestPathInDAG {
    public int[] shortestPath(int N, int M, int[][] edges) {
       List<int[]>[] G = new ArrayList[N];
       for (int i=0; i<N; i++) G[i] = new ArrayList<>();
       for ( int[]edge: edges){
           G[edge[0]].add(new int[]{edge[1], edge[2]});
       }

       boolean[] vis = new boolean[N];
       Stack<Integer> stack = new Stack<>();
       for (int i=0; i<N; i++){
           if (!vis[i]){
               topoSort(i, stack, vis, G);
           }
       }
       int[] dist = new int[N];
        Arrays.fill(dist, (int) 1e9);
        dist[0] = 0;
        while ( !stack.isEmpty()){
            int u = stack.pop();
            for ( int[] adj: G[u]){
                int v = adj[0];
                int wt = adj[1];
                if ( dist[u] + wt < dist[v] + wt) dist[v] = dist[u]+wt;
            }
        }
        for ( int i=0; i<N; i++) if ( dist[i] == (int)1e9) dist[i] = -1;
        return dist;
    }

    private void topoSort(int node, Stack<Integer> stack, boolean[] vis, List<int[]>[] g) {
        vis[node] = true;
        for ( int[] adj: g[node]){
            if(!vis[adj[0]]){
                topoSort(adj[0], stack, vis, g);
            }
        }
        stack.push(node);
    }
}
