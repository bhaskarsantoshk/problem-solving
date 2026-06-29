package company.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortestPathInDAG {
    public int[] shortestPath(int N, int M, int[][] edges) {
        List<int[]>[] g = new ArrayList[N];
        for (int i=0; i<N; i++) g[i] = new ArrayList<>();
        for ( int []edge: edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            g[u].add(new int[]{v, wt});
        }

        boolean[] vis = new boolean[N];
        Stack<Integer> stack = new Stack<>();
        for ( int i=0; i<N; i++) if ( !vis[i]) dfs(i, vis, g, stack);
        int[] distance = new int[N];
        Arrays.fill(distance, (int)1e9);
        distance[0] = 0;
        while (!stack.isEmpty()){
            int node = stack.pop();
            for (int []adj: g[node]){
                int adjNode = adj[0];
                int wt = adj[1];
                if ( distance[node] + wt < distance[adjNode]) distance[adjNode] = distance[node] + wt;
            }
        }

        for (int i=0; i<N; i++) if ( distance[i] == (int)1e9) distance[i] = -1;

        return distance;
    }

    private void dfs(int node, boolean[] vis, List<int[]>[] g, Stack<Integer> stack) {
        vis[node] = true;
        for ( int[] adjNode: g[node]){
            if (!vis[adjNode[0]]){
                dfs(adjNode[0], vis, g, stack);
            }
        }
        stack.push(node);
    }
}
