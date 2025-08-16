package takeUForward.graph.revision2;

import java.util.Arrays;

public class P15FindEventualSafeStates {
    public int[] eventualSafeNodes(int V, int[][] adj) {
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];
        boolean[] check = new boolean[V];
        for ( int i=0; i<V; i++){
            if (!vis[i]) dfsCycleCheck(i, vis, pathVis, check, adj);
        }
        int len = 0;
        for ( int i=0; i<V; i++) {
            if ( check[i] ) len++;
        }
        int [] ans = new int[len];
        int index = 0;
        for ( int i=0; i<V; i++){
            if ( check[i] ){
                ans[index++] = i;
            }
        }
        Arrays.sort(ans);
        return ans;
    }

    private boolean dfsCycleCheck(int node, boolean[] vis, boolean[] pathVis, boolean[] check, int[][] adj) {
        vis[node] = true;
        pathVis[node] = true;
        check[node] = false;
        for ( int adjNode: adj[node]){
            if ( !vis[adjNode]) {
                if ( dfsCycleCheck(adjNode, vis, pathVis, check, adj) ) return true;
            } else if ( pathVis[adjNode]) return true;
        }

        pathVis[node] = false;
        check[node] = true;
        return false;
    }
}
