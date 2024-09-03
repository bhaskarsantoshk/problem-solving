package takeUForward.graph;

import java.util.*;

public class G56ArticulationPointInGraph {
    int timer = 0;
    public ArrayList<Integer> articulationPoints(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int[] tin = new int[V];
        int[] low = new int[V];
        boolean[] vis = new boolean[V];
        Set<Integer> articulationPoints = new HashSet<>();

        dfs(0, -1, tin, low, vis, articulationPoints, adj );
        ArrayList<Integer> res = new ArrayList<>();
        if ( articulationPoints.isEmpty()) {
            res.add(-1);
            return res;
        }
        for ( Integer num: articulationPoints){
            res.add(num);
        }
        Collections.sort(res);
        return res;
    }

    private void dfs(int node, int parent, int[] tin, int[] low, boolean[] vis,
                     Set<Integer> articulationPoints, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;
        tin[node] = low[node] = timer;
        timer++;
        int child = 0;
        for ( int adjNode : adj.get(node)){
            if ( adjNode == parent) continue;
            if ( !vis[adjNode]){
                dfs(adjNode, node, tin, low, vis, articulationPoints, adj);
                low[node] = Math.min( low[node], low[adjNode]);
                if ( low[adjNode] >= tin[node] && parent != -1){
                    articulationPoints.add(node);
                }
                child++;
            } else {
                low[node] = Math.min( low[node], tin[adjNode]);
            }
        }

        if ( parent == -1 && child > 1) articulationPoints.add(node);
    }
}
