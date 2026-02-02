package takeUForward.graph.hard_problems;

import java.util.*;

public class FindEventualSafeStates {
    public int[] eventualSafeNodes(int V, int[][] adj) {
        List<Integer> res = new ArrayList<>();
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];
        for ( int i=0; i<V; i++){
            if ( !vis[i]){
                dfs(i, vis, pathVis, res, adj);
            }
        }
        int[] result = new int[res.size()];
        for ( int i=0; i<res.size(); i++) result[i] = res.get(i);
        Arrays.sort(result);
        return result;
    }

    private boolean dfs(int node, boolean[] vis, boolean[] pathVis, List<Integer> res, int[][] adj) {
        vis[node] = true;
        pathVis[node] = true;

        for ( int adjNode: adj[node]){
            if(!vis[adjNode]){
                if(dfs(adjNode, vis, pathVis, res, adj)) return true;
            } else {
                if(pathVis[adjNode]) return true;
            }
        }
        pathVis[node] = false;
        res.add(node);
        return false;
    }

    public int[] eventualSafeNodesTopoSort(int V, int[][] adj) {
        List<List<Integer>> G = new ArrayList<>();
        for ( int i=0; i<V; i++) G.add(new ArrayList<>());
        for (int i=0; i<adj.length; i++){
            G.add(new ArrayList<>());
            for ( int j=0; j<adj[i].length; j++){
                G.get(adj[i][j]).add(i);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();

        int[] indegree = new int[V];
        for ( int i=0; i<G.size(); i++){
           for ( int adjNode: G.get(i)) indegree[adjNode]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for ( int i=0; i<V; i++){
            if ( indegree[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()){
            int node = queue.poll();
            safeNodes.add(node);
            for ( int adjNode: G.get(node)){
                indegree[adjNode]--;
                if ( indegree[adjNode] == 0) queue.offer(adjNode);
            }
        }

        int[] res = new int[safeNodes.size()];
        for ( int i=0; i<res.length; i++){
            res[i] = safeNodes.get(i);
        }
        Arrays.sort(res);
        return res;
    }
}
