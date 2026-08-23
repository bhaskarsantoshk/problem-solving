package takeUForward.graph.revision4;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class G15TopologicalSortDFS {
    public int[] topoSort(int V, List<List<Integer>> adj) {
        return topoSortDFS(V, adj);
    }

    private int[] topoSortDFS(int v, List<List<Integer>> adj) {
        int[] res = new int[v];
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] vis = new boolean[v];
        for ( int i=0; i<v; i++){
            if ( !vis[i] ) dfs( i, stack, vis, adj);
        }
        for ( int i=0; i<v; i++) res[i] = stack.pop();
        return res;
    }

    private void dfs(int node, Deque<Integer> stack, boolean[] vis, List<List<Integer>> adj) {
        vis[node] = true;
        for ( int adjNode: adj.get(node)){
            if (!vis[adjNode]) dfs(adjNode, stack, vis, adj );
        }
        stack.push(node);
    }
}
