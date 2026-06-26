package company.google;

import java.util.List;
import java.util.Stack;

public class TopologicalSort {
    public int[] topoSort(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for ( int i=0; i<V; i++) if ( !vis[i]) dfs(i, adj, vis, stack);
        int [] res = new int[V];
        for (int i=0; i<V; i++) res[i] = stack.pop();
        return res;
    }

    private void dfs(int node, List<List<Integer>> adj, boolean[] vis, Stack<Integer> stack) {
        vis[node] = true;
        for ( int adjNode: adj.get(node)) {
            if (!vis[adjNode]) dfs(adjNode, adj , vis, stack);
        }
        stack.push(node);
    }
}
