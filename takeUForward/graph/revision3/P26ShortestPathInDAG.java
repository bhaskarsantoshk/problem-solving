package takeUForward.graph.revision3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class P26ShortestPathInDAG {
    public int[] shortestPath(int N, int M, int[][] edges) {
        List<int[]>[] g = new ArrayList[N];
        for(int i=0; i<N; i++) g[i] = new ArrayList<>();
        for ( int [] edge: edges){
            int u = edge[0], v = edge[1], wt = edge[2];
            g[u].add(new int[]{v, wt});
        }

        Stack<Integer> stack = new Stack<>();
        boolean[] vis = new boolean[N];
        for ( int i=0; i<N; i++){
            if (!vis[i]) topoSort(i, g, vis, stack);
        }

        int[] distance = new int[N];
        Arrays.fill(distance, (int)1e9);
        distance[0] = 0;
        while ( !stack.isEmpty()){
            int node = stack.pop();
            for ( int[] adj: g[node]){
                int v = adj[0];
                int wt = adj[1];
                if ( distance[v] > distance[node]+wt){
                    distance[v] = distance[node]+wt;
                }
            }
        }
        for ( int i=0; i<N; i++) if (distance[i] == (int)1e9) distance[i] = -1;
        return distance;
    }

    private void topoSort(int node, List<int[]>[] g, boolean[] vis, Stack<Integer> stack) {
        vis[node] = true;
        for ( int adjNode[]: g[node]){
            if ( !vis[adjNode[0]]) topoSort(adjNode[0], g, vis, stack);
        }
        stack.push(node);
    }
}
