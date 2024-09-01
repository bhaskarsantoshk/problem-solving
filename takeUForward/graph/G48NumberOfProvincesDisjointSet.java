package takeUForward.graph;

import java.util.ArrayList;
import java.util.List;

public class G48NumberOfProvincesDisjointSet {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        DisjointSet ds = new DisjointSet(V);
        for ( int i=0; i<V; i++){
            for ( int j=0; j<V; j++){
                if ( adj.get(i).get(j) == 1){
                    ds.unionBySize(i, j);
                }
            }
        }

        int count = 0;
        for ( int i=0; i<V; i++){
            if ( i == ds.findUParent(i)) count++;
        }
        return count;
    }

    static class DisjointSet{
        List<Integer> size = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();

        DisjointSet(int V){
            for ( int i=0; i<=V; i++){
                parent.add(i);
                size.add(1);
            }
        }

        public int findUParent(int node){
            if ( node == parent.get(node)) return node;
            int uParent = findUParent(parent.get(node));
            parent.set(node, uParent);
            return uParent;
        }

        public void unionBySize(int u, int v){
            int uParentU = findUParent(u);
            int uParentV = findUParent(v);
            if ( uParentU == uParentV) return;
            if ( size.get(uParentU) > size.get(uParentV)) {
                parent.set(uParentV, uParentU);
                size.set(uParentU, size.get(uParentU)+1);
            } else{
                parent.set(uParentU, uParentV);
                size.set(uParentV, size.get(uParentV)+1);
            }
        }
    }
}
