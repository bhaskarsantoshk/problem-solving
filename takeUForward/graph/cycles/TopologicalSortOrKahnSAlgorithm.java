package takeUForward.graph.cycles;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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


    public int[] topoSortBFS(int V, List<List<Integer>> adj) {
        int[] indegree = new int[V];
        Queue<Integer> queue = new LinkedList<>();
        for ( int u=0; u<V; u++){
            for ( int v: adj.get(u) ){
                indegree[v]++;
            }

        }
        for ( int u=0; u<V; u++){
            if ( indegree[u] == 0) queue.offer(u);
        }
        int [] res = new int[V];
        int index = 0;
        while (!queue.isEmpty()){
            int node = queue.poll();
            res[index++] = node;
            for ( int adjNode: adj.get(node)){
                indegree[adjNode]--;
                if ( indegree[adjNode] == 0) queue.offer(adjNode);
            }
        }
        return res;
    }
}
