package takeUForward.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortestPathInDirectedAcyclicGraph {
    public int[] shortestPath(int N,int M, int[][] edges) {
        List<int[]>[] G = new ArrayList[N];
        for ( int i=0; i<N; i++){
            G[i]= new ArrayList<>();
        }
        for ( int[] edge: edges){
            G[edge[0]].add(new int[]{edge[1], edge[2]});
        }

        // Step 1: Do a Topological sort
        boolean[] vis = new boolean[N];
        Stack<Integer> stack = new Stack<>();
        for ( int i=0; i<N; i++){
            if ( !vis[i]) topologicalSortDFS(G, N, i, vis, stack);
        }

        // Step 2: do the distance thing
        int [] distance = new int[N];
        Arrays.fill(distance, (int)1e9);
        distance[0] = 0;
        while (!stack.isEmpty()){
            int node = stack.pop();
            for ( int[] edge: G[node]){
                int v = edge[0];
                int wt = edge[1];
                if ( distance[node] + wt < distance[v]) distance[v] = distance[node]+wt;
            }
        }
        
        for ( int i=0; i<N; i++){
            if ( distance[i] == (int)1e9) distance[i] = -1;
        }

        return distance;

    }

    private void topologicalSortDFS(List<int[]>[] g, int n, int node, boolean[] vis, Stack<Integer> stack) {
        vis[node] = true;
        for ( int[] adjNode: g[node]){
            if ( !vis[adjNode[0]]) topologicalSortDFS(g, n, adjNode[0], vis, stack);
        }
        stack.push(node);
    }
}
