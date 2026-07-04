package takeUForward.graph.revision3;

import java.util.ArrayList;
import java.util.List;

public class P47ArticulationPointInGraph {

    private int timer = 1;
    public ArrayList<Integer> articulationPoints(int n,
                                                 ArrayList<ArrayList<Integer>> adj) {
        boolean[] articulationMarker = new boolean[n];
        boolean[] vis = new boolean[n];
        int [] time = new int[n];
        int [] low = new int[n];

        for ( int i=0; i<n; i++){
            if (!vis[i]) dfs(i, -1, time, low, articulationMarker, adj, vis);
        }

        ArrayList<Integer> articulationPoints = new ArrayList<>();

        for ( int i=0; i< n; i++) if ( articulationMarker[i] ) articulationPoints.add(i);

        return articulationPoints;
    }

    private void dfs(int node, int parent, int[] time, int[] low,
                     boolean[] articulationMarker, ArrayList<ArrayList<Integer>> g, boolean[] vis) {
        vis[node] = true;
        time[node] = low[node] = timer;
        timer++;
        int child = 0;
        for ( int adjNode: g.get(node)){
            if ( adjNode == parent) continue;
            if (!vis[adjNode]){
                child++;
                dfs(adjNode, node, time, low, articulationMarker, g, vis);
                low[node] = Math.min(low[node], low[adjNode]);
                if ( low[adjNode] >= time[node] && parent != -1) articulationMarker[node] = true;
            } else {
                low[node] = Math.min(low[node], time[adjNode]);
            }
        }

        if (parent == -1  && child > 1) articulationMarker[node] = true;

    }
}
