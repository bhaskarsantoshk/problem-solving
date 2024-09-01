package takeUForward.graph;

import java.util.ArrayList;
import java.util.List;

public class G49NumberOfOperationsToMakeNetworkConnectedDSU {
    public int Solve(int n, int[][] edges) {

        DisjointSet ds = new DisjointSet(n);
        int extraEdges = 0;
        for ( int[] edge: edges){
            int u = edge[0];
            int v= edge[1];
            if ( ds.findUParent(u) == ds.findUParent(v)) extraEdges++;
            else ds.unionBySize(u, v);
        }

        int connectedComponents = 0;

        for ( int i=0; i<n; i++){
            if ( i == ds.findUParent(i)) connectedComponents++;
        }

        int ans = connectedComponents-1;
        if ( extraEdges >= ans) return ans;
        return -1;

    }

    class DisjointSet{
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        DisjointSet(int n){
            for ( int i=0; i<=n; i++){
                parent.add(i);
                size.add(1);
            }
        }

        public int findUParent( int node){
            if ( node == parent.get(node)) return node;
            int uParent = findUParent(parent.get(node));
            parent.set(node, uParent);
            return uParent;
        }

        public void unionBySize(int u, int v){
            int uParent = findUParent(u);
            int vParent = findUParent(v);
            if ( uParent == vParent) return;
            if ( size.get(uParent) > size.get(vParent)) {
                parent.set(vParent, uParent);
                size.set(uParent, size.get(uParent)+1);
            } else {
                parent.set(vParent, uParent);
                size.set(vParent, size.get(vParent)+1);
            }
        }

    }
}
