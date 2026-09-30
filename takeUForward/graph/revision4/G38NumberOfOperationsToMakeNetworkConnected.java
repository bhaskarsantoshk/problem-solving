package takeUForward.graph.revision4;

import java.util.ArrayList;
import java.util.List;

public class G38NumberOfOperationsToMakeNetworkConnected {
    public int solve(int n, int[][] edges) {
        int extraEdges = 0;
        DisjointSet ds = new DisjointSet(n);
        for ( int[] edge: edges){
            int u = edge[0], v = edge[1];
            if (ds.findUltimateParent(u) == ds.findUltimateParent(v) ) extraEdges++;
            else {
                ds.union(u, v);
            }
        }
        int componets = 0;
        for ( int i=0; i<n; i++) if ( ds.parent.get(i) == i) componets++;
        return (extraEdges >= componets-1) ? componets-1: -1;
    }

    class DisjointSet{
        List<Integer> parent, size;
        DisjointSet(int n){
            parent = new ArrayList<>();
            size = new ArrayList<>();
            for ( int i=0; i<n; i++) {
                parent.add(i);
                size.add(1);
            }
        }

        private void union(int u, int v){
            int uParent = findUltimateParent(u);
            int vParent = findUltimateParent(v);
            if ( uParent == vParent) return;
            if ( size.get(uParent) >= size.get(vParent)){
                parent.set(vParent, uParent);
                size.set(uParent, size.get(uParent)+ size.get(vParent));
            } else {
                parent.set(uParent, vParent);
                size.set(vParent, size.get(uParent)+ size.get(vParent));
            }
        }

        private int findUltimateParent(int node) {
            if ( node == parent.get(node) ) return node;
            else {
                int uParent = findUltimateParent(parent.get(node));
                parent.set(node, uParent);
                return uParent;
            }
        }
    }
}
