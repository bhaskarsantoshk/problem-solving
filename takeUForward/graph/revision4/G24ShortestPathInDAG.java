package takeUForward.graph.revision4;

import java.util.*;

public class G24ShortestPathInDAG {
    public int[] shortestPath(int N, int M, int[][] edges) {
        List<int[]>[] g = new ArrayList[N];
        for ( int i=0; i<N; i++) g[i] = new ArrayList<>();
        for ( int []edge: edges){
            int u = edge[0], v = edge[1], wt = edge[2];
            g[u].add(new int[]{v, wt});
        }
        boolean[] vis = new boolean[N];
        Deque<Integer> stack = new ArrayDeque<>();
        for ( int i=0; i<N; i++){
            if (!vis[i]) dfs(i, g, vis, stack);
        }
        int[] distance = new int[N];
        Arrays.fill(distance, (int)1e9);
        distance[0] = 0;

        while (!stack.isEmpty()){
            int node = stack.poll();
            for ( int adjNodeArr[]: g[node]){
                int adjNode = adjNodeArr[0];
                int wt = adjNodeArr[1];
                if ( distance[adjNode] > distance[node]+wt) distance[adjNode] = distance[node]+wt;
            }
        }
        for ( int i=0; i<distance.length; i++){
            if ( distance[i] == (int)1e9) distance[i] = -1;
        }
        return distance;
    }

    private void dfs(int node, List<int[]>[] g, boolean[] vis, Deque<Integer> stack) {
        vis[node] = true;
        for ( int[] adjNode: g[node]){
            if (!vis[adjNode[0]]) dfs(adjNode[0], g, vis, stack);
        }
        stack.push(node);
    }
}
