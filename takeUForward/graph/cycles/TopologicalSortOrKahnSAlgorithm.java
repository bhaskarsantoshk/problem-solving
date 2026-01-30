package takeUForward.graph.cycles;

import java.util.List;
import java.util.Stack;

public class TopologicalSortOrKahnSAlgorithm {
    public int[] topoSort(int V, List<List<Integer>> adj) {
        Stack<Integer> stack = new Stack<>();
        boolean[] vis = new boolean[V];
        for ( int i=0; i<V; i++){
            if ( !vis[i]){
                dfs(i, adj, stack, vis);
            }
        }
        int[] res = new int[V];
        int index = 0;
        while ( !stack.isEmpty()) res[index++] = stack.pop();
        return res;
    }

    private void dfs(int node, List<List<Integer>> adj, Stack<Integer> stack, boolean[] vis) {
        vis[node] = true;
        for ( int adjNode: adj.get(node)){
            if ( !vis[adjNode]){
                dfs(adjNode, adj, stack, vis);
            }
        }
        stack.push(node);
    }
}
