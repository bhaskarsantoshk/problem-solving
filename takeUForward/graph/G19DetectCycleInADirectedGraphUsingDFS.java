package takeUForward.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class G19DetectCycleInADirectedGraphUsingDFS {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
       boolean[] vis = new boolean[V];
       boolean[] pathVis = new boolean[V];
       for ( int i=0; i<V; i++){
           if ( !vis[i]) {
               if (detectCycleDFS(i, vis, pathVis, adj)) return true;
           }
       }
       return false;
    }

    private boolean detectCycleDFS(int node, boolean[] vis, boolean[] pathVis, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = pathVis[node] = true;
        for ( int adjNode: adj.get(node)){
            if ( !vis[adjNode]){
                if ( detectCycleDFS(adjNode, vis, pathVis, adj)) return true;
            } else if ( pathVis[adjNode]) return true;
        }
        pathVis[node] = false;
        return false;
    }
}
/*

A —> B
^    |
|    v
D <— C
 */