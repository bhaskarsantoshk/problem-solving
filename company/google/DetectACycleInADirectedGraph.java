package company.google;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectACycleInADirectedGraph {
    public boolean isCyclic(int N, List<List<Integer>> adj) {
        // return isCyclicDFS(N, adj);
        return isCyclicBFS(N, adj);
    }

    private boolean isCyclicBFS(int n, List<List<Integer>> adj) {
        boolean[] vis = new boolean[n];
        int []inDegree = new int[n];
        for ( int i=0; i<n; i++){
            for(int adjNode: adj.get(i)) inDegree[adjNode]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for ( int i=0; i<n; i++) if ( inDegree[i] == 0) queue.offer(i);
        int topSortCount = 0;
        while (!queue.isEmpty()){
            int node = queue.poll();
            topSortCount++;
            for ( int adjNode: adj.get(node)){
                inDegree[adjNode]--;
                if ( inDegree[adjNode] == 0){
                    queue.offer(adjNode);
                }
            }
        }
        return topSortCount == n ? false: true;
    }

    private boolean isCyclicDFS(int n, List<List<Integer>> adj) {
        boolean[] vis = new boolean[n];
        boolean[] pathVis = new boolean[n];
        for ( int i=0; i<n; i++){
            if (!vis[i] && isCyclicDFS(i, adj, vis, pathVis)) return true;
        }
        return false;
    }

    private boolean isCyclicDFS(int node, List<List<Integer>> adj, boolean[] vis, boolean[] pathVis) {
        vis[node] = true;
        pathVis[node] = true;

        for ( int adjNode: adj.get(node)){
            if (!vis[adjNode]){
                if ( isCyclicDFS(adjNode, adj, vis, pathVis)) return true;
            } else if ( pathVis[adjNode] ) return true;
        }
        return false;
    }
}
