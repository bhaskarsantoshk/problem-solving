package takeUForward.graph.revision4;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class G43KosarajusAgorithm {
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> stack = new Stack<>();
        boolean[] vis = new boolean[V];
        for ( int i=0; i<V; i++){
            if ( !vis[i]){
                dfs(i, vis, adj, stack);
            }
        }

        List<Integer>[] G = new ArrayList[V];
        for ( int i=0; i<V; i++) G[i] = new ArrayList<>();
        for ( int i=0; i<V; i++){
            for ( int adjNode: adj.get(i)){
                G[adjNode].add(i);
            }
        }

        int scc= 0;
        vis = new boolean[V];
        while (!stack.isEmpty()){
            int node = stack.pop();
            if ( !vis[node]){
                dfs2(node, G, vis);
                scc++;
            }
        }
        return scc;
    }

    private void dfs2(int node, List<Integer>[] g, boolean[] vis) {
        vis[node] = true;
        for ( int adjNode: g[node]){
            if ( !vis[adjNode] ) dfs2(adjNode, g, vis);
        }
    }

    private void dfs(int i, boolean[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack) {
        vis[i] = true;
        for ( int adjNode: adj.get(i)){
            if (!vis[adjNode]) dfs(adjNode, vis, adj, stack);
        }
        stack.push(i);
    }
}
