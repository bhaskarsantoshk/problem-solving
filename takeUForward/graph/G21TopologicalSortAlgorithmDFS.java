package takeUForward.graph;

import java.util.ArrayList;
import java.util.Stack;

public class G21TopologicalSortAlgorithmDFS {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
       boolean[] vis = new boolean[V];
       Stack<Integer> stack = new Stack<>();
       for( int i=0; i<V; i++){
           if ( !vis[i]){
               dfs(i, vis, adj, stack);
           }
       }
       if ( stack.size() != V) return new int[]{-1};
       int[] result = new int[V];
       for ( int i=0; i<V; i++){
           result[i] = stack.pop();
       }
       return result;
    }

    private static void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack) {
        vis[node] = true;
        for ( int adjNode: adj.get(node)){
            if ( !vis[adjNode]) dfs(adjNode, vis, adj, stack);
        }
        stack.push(node);
    }
}
