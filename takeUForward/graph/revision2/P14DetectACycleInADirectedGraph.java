package takeUForward.graph.revision2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P14DetectACycleInADirectedGraph {
    public boolean isCyclic(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];
        for ( int i=0; i<V; i++){
            if ( !vis[i]){
                if ( isCyclicDFS(i, vis, pathVis, adj)) return true;
            }
        }
        return false;
    }

    private boolean isCyclicDFS(int node, boolean[] vis, boolean[] pathVis, List<List<Integer>> adj) {
        vis[node] = true;
        pathVis[node] = true;
        for ( int adjNode: adj.get(node)){
            if ( !vis[adjNode] ){
                if (isCyclicDFS(adjNode, vis, pathVis, adj)) return true;
            }
            else if ( pathVis[adjNode]) return true;
        }
        pathVis[node] = false;
        return false;
    }

    public boolean isCyclicBFS(int V, List<List<Integer>> adj) {
        int[] inDegree = new int[V];
        Queue<Integer> queue = new LinkedList<>();
        for ( int i=0; i<V; i++){
            for ( int adjNode: adj.get(i)) inDegree[adjNode]++;
        }
        for ( int i=0; i<V; i++) {
            if ( inDegree[i] == 0) queue.offer(i);
        }
        List<Integer> topoSort = new ArrayList<>();
        while ( !queue.isEmpty()){
            int node = queue.poll();
            topoSort.add(node);
            for ( int adjNode: adj.get(node)){
                inDegree[adjNode]--;
                if ( inDegree[adjNode] == 0) queue.offer(adjNode);
            }
        }
        return topoSort.size() != V;
    }
}
