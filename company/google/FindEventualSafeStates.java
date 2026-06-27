package company.google;

import java.util.*;

public class FindEventualSafeStates {
    public int[] eventualSafeNodesDFS(int V, int[][] adj) {
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];
        List<Integer> res = new ArrayList<>();
        for ( int i=0; i<V; i++){
            if (!vis[i]) dfs(i, adj, vis,pathVis, res);
        }
        int[] ans = new int[res.size()];
        for ( int i=0; i<res.size(); i++) ans[i] = res.get(i);
        Arrays.sort(ans);
        return ans;
    }

    private boolean dfs(int node, int[][] adj, boolean[] vis, boolean[] pathVis, List<Integer> res) {
        vis[node] = pathVis[node] = true;
        for (int adjNode : adj[node]){
            if ( !vis[adjNode]){
                if (dfs(adjNode, adj, vis, pathVis, res)) return true;
            } else if ( pathVis[adjNode] ) return true;
        }
        pathVis[node] = false;
        res.add(node);
        return false;
    }


    public int[] eventualSafeNodesBFS(int V, int[][] adj) {
        List<Integer>[] g = new ArrayList[V];
        for ( int i=0; i<V; i++) g[i] = new ArrayList<>();
        int[] indegree = new int[V];
        for (int i=0; i<V; i++){
            for ( int j=0; j<adj[i].length; j++){
                int u = i;
                int v = adj[i][j];
                g[v].add(u);
                indegree[u]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for ( int i=0; i<V; i++) if (indegree[i] == 0) queue.offer(i);
        List<Integer> res = new ArrayList<>();
        while ( !queue.isEmpty()){
            int node = queue.poll();
            res.add(node);
            for ( int adjNode: g[node]){
                indegree[adjNode]--;
                if ( indegree[adjNode] == 0) queue.offer(adjNode);
            }
        }

        int[] ans = new int[res.size()];
        for ( int i=0; i<res.size(); i++){
            ans[i] = res.get(i);
        }

        Arrays.sort(ans);
        return ans;
    }
}
