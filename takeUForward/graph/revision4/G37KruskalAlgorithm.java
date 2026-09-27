package takeUForward.graph.revision4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class G37KruskalAlgorithm {
    public int spanningTree(int V, List<List<List<Integer>>> adj) {
        List<int[]> edges = new ArrayList<>();
        for ( int i=0; i<adj.size(); i++){
            for ( List<Integer> edge : adj.get(i)){
                int u = i, v = edge.get(0), wt = edge.get(1);
                edges.add(new int[]{ wt, u, v});
            }
        }
        Collections.sort(edges, (a,b)-> a[0]-b[0]);
       DisjointSet dsu = new DisjointSet(V);
       int edgesConnected = 0;
       int mstWt = 0;
        for ( int[] edge : edges){
            int wt = edge[0], u = edge[1], v = edge[2];
            if ( dsu.findUltimateParent(u) == dsu.findUltimateParent(v)) continue;
            else {
                mstWt += wt;
                edgesConnected++;
                dsu.unionBySize(u, v);
            }
        }
        return edgesConnected == V-1 ?mstWt : -1;
    }

    class DisjointSet{
        List<Integer> parent, size ;
        DisjointSet(int n){
            size = new ArrayList<>();
            parent = new ArrayList<>();
            for ( int i=0; i<n; i++){
                parent.add(i);
                size.add(1);
            }
        }

        private int findUltimateParent(int node){
            if ( node == parent.get(node)) return node;
            else {
                int ultimateParent = findUltimateParent(parent.get(node));
                parent.set(node, ultimateParent);
                return ultimateParent;
            }
        }

        private void unionBySize(int u, int v){
            int uParent = findUltimateParent(u);
            int vParent = findUltimateParent(v);
            if ( uParent == vParent) return;
            if ( size.get(u) >= size.get(v)){
                size.set(uParent, size.get(uParent)+1);
                parent.set(vParent, uParent);
            } else {
                size.set(vParent, size.get(vParent)+1);
                parent.set(uParent, vParent);
            }
        }
    }
}
