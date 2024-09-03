package takeUForward.graph;

import java.util.ArrayList;
import java.util.Stack;

public class G54StronglyConnectedComponentsKosarajuSAlgorithm {
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        // step 1 : sort the nodes based on the finishing time
        Stack<Integer> stack = new Stack<>();
        boolean[] vis = new boolean[V];
        for ( int i=0; i<V; i++){
            if ( !vis[i]){
                dfs(i, vis, adj, stack);
            }
        }

        // Reverse edges
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for ( int i=0; i<V; i++) adjT.add(new ArrayList<>());
        for ( int i=0; i<V; i++){
            for ( int adjNode: adj.get(i)){
                adjT.get(adjNode).add(i);
            }
        }

        // DFS on sorted nodes
        vis = new boolean[V];
        int scc = 0;
        while ( !stack.isEmpty()){
            int node = stack.pop();
            if ( !vis[node]){
                dfs2(node, vis, adjT);
                scc++;
            }
        }
        return scc;
    }

    private void dfs2(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adjT) {
        vis[node] = true;
        for ( int adjNode : adjT.get(node)){
            if ( !vis[adjNode]) dfs2(adjNode, vis, adjT);
        }
    }

    private void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack) {
        vis[node] = true;
        for ( int adjNode: adj.get(node)){
            if ( !vis[adjNode]) dfs(adjNode, vis, adj, stack);
        }
        stack.push(node);
    }
}
