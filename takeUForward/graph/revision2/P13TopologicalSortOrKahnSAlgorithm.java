package takeUForward.graph.revision2;

import java.util.List;
import java.util.Stack;

public class P13TopologicalSortOrKahnSAlgorithm {
    public int[] topoSortDFS(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for ( int i=0; i<V; i++){
            if ( !vis[i]) dfs(i, adj, vis, stack);
        }
        int [] res = new int[V];
        int index = 0;
        while ( !stack.isEmpty() && index < V){
            res[index++] = stack.pop();
        }
        return res;
    }

    private void dfs(int node, List<List<Integer>> adj, boolean[] vis, Stack<Integer> stack) {
        vis[node] = true;
        for ( int adjNode : adj.get(node)){
            if ( !vis[adjNode]) dfs(adjNode, adj, vis, stack);
        }
        stack.push(node);
    }
}
