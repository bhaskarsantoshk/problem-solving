package takeUForward.graph.revision3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P48KosarajuSAlgorithm {
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> stack = new Stack<>();
        boolean[] vis = new boolean[V];
        for ( int i=0; i<V; i++){
            if (!vis[i]) dfs(i, adj, vis, stack);
        }

        List<Integer>[] reverseG = new ArrayList[V];
        for ( int i=0; i<V; i++) reverseG[i] = new ArrayList<>();
        for ( int i=0; i<adj.size(); i++){
            for ( int adjNode: adj.get(i)){
                reverseG[adjNode].add(i);
            }
        }

        int scc = 0;
        vis = new boolean[V];

        while (!stack.isEmpty()){
            int node = stack.pop();
            if (!vis[node]){
                scc++;
                dfs3(node, reverseG, vis);
            }
        }
     return scc;
    }

    private void dfs3(int node, List<Integer>[] reverseG, boolean[] vis) {
        vis[node] = true;
        for ( int adjNode: reverseG[node]){
            if (!vis[adjNode]) dfs3(adjNode, reverseG, vis);
        }
    }

    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, Stack<Integer> stack) {
        vis[node] = true;
        for ( int adjNode: adj.get(node)){
            if ( !vis[adjNode]) dfs( adjNode, adj, vis, stack);
        }
        stack.push(node);
    }
}
