package takeUForward.graph.revision3;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class P39NumberOfOperationsToMakeNetworkConnected {
    public int solve(int n, int[][] Edges) {
        DisjointSet ds = new DisjointSet(n);
        int extraEdges = 0;
        for ( int[] edge: Edges){
            int u = edge[0], v = edge[1];
            if ( ds.find(u) == ds.find(v)) extraEdges++;
            else {
                ds.union(u, v);
            }
        }

        int components = 0;
        for ( int i=0; i<n; i++) if ( i == ds.parent.get(i)) components++;

        if ( extraEdges >= components-1) return components-1;
        return -1;
    }

    class DisjointSet{
        private List<Integer> parent = new ArrayList<>();
        private List<Integer> size = new ArrayList<>();
        private List<Integer> rank = new ArrayList<>();

        DisjointSet(int n){
            for ( int i=0; i<n; i++){
                parent.add(i);
                size.add(1);
                rank.add(0);
            }
        }

        public int find(int node){
            if ( node == parent.get(node)) return node;
            else {
                int ultimateParent = find(parent.get(node));
                parent.set(node, ultimateParent);
                return ultimateParent;
            }
        }

        public void union(int u, int v){
            int parentU = find(u);
            int parentV = find(v);
            if ( parentU == parentV) return;
            if ( size.get(parentU) < size.get(parentV)){
                parent.set(parentU, parentV);
                size.set(parentV, size.get(parentU)+size.get(parentV));
            } else {
                size.set(parentU, size.get(parentU)+size.get(parentV));
                parent.set(parentV, parentU);
            }
        }
    }
}
