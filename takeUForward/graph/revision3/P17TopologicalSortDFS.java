package takeUForward.graph.revision3;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class P17TopologicalSortDFS {
    public int[] topoSort(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for ( int i=0; i<V; i++){
            if (!vis[i]) dfs(i, vis, stack, adj);
        }
        int[] res = new int[V];
        int index = 0;
        while (!stack.isEmpty()){
            res[index++] = stack.pop();
        }
        return res;
    }

    private void dfs(int node, boolean[] vis, Stack<Integer> stack, List<List<Integer>> g) {
        vis[node] = true;
        for ( int adjNode: g.get(node)){
            if ( !vis[adjNode]) dfs(adjNode, vis, stack, g);
        }
        stack.push(node);
    }
}
