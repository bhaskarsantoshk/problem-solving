package takeUForward.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSort {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[V];
        for ( int i=0; i<V; i++){
            for ( int adjNode: adj.get(i)) indegree[adjNode]++;
        }
        for ( int i=0; i< indegree.length; i++){
            if (indegree[i] == 0) q.offer(i);
        }
        int [] result = new int[V];
        int index=0;
        while ( !q.isEmpty()){
            int node = q.poll();
            result[index++] = node;
            for ( int adjNode: adj.get(node)){
                indegree[adjNode]--;
                if ( indegree[adjNode] == 0) q.offer(adjNode);
            }
        }
        return result;
    }

    static int[] topoSortDFS(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int[] result = new int[V];
        Stack<Integer> stack = new Stack<>();
        boolean[] vis = new boolean[V];
        for ( int i=0; i<V; i++){
            if ( !vis[i]){
             dfs(adj, vis, stack, i);
            }
        }
        for (int i=0; i<V; i++){
            result[i] = stack.pop();
        }
        return result;
    }

    private static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, Stack<Integer> stack, int node) {
        vis[node] = true;
        for ( int adjNode: adj.get(node)){
            if ( !vis[adjNode]){
                dfs(adj, vis, stack, adjNode);
            }
        }
        stack.push(node);
    }

}
