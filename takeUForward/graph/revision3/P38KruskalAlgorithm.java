package takeUForward.graph.revision3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class P38KruskalAlgorithm {

    public int spanningTree(int V, List<List<List<Integer>>> adj) {

        List<Edge> edges = new ArrayList<>();
        for ( int i=0; i<V; i++){
            for ( List<Integer> edge: adj.get(i)){
                int u = i;
                int v = edge.get(0);
                int wt = edge.get(1);
                edges.add(new Edge(u, v, wt));
            }
        }
        Collections.sort(edges, (e1, e2) -> e1.wt-e2.wt);

        int mstWt = 0;
        DisjointSet ds = new DisjointSet(V);
        for ( Edge edge: edges){
            if ( ds.find(edge.u) != ds.find(edge.v)){
                mstWt += edge.wt;
                ds.union(edge.u, edge.v);
            }
        }
        return mstWt;
    }

    class Edge {
        int u, v, wt;
        Edge(int u, int v, int wt){
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }

    class DisjointSet{
        private List<Integer> parent = new ArrayList<>();
        private List<Integer> rank = new ArrayList<>();

        DisjointSet(int n){
            for ( int i=0; i<n; i++){
                parent.add(i);
                rank.add(0);
            }
        }

        private void union(int u, int v){
            int uP = find(u);
            int vP = find(v);
            if ( uP == vP) return;
            if ( rank.get(uP) < rank.get(vP)) parent.set(uP, vP);
            else if ( rank.get(uP) > rank.get(vP)) parent.set(vP, uP);
            else {
                parent.set(vP, uP);
                int uRank = rank.get(uP);
                rank.set(uP, uRank+1);
            }
        }

        private int find(int node){
            if ( node == parent.get(node)) return node;
            else {
                int ultimateParent = find(parent.get(node));
                parent.set(node, ultimateParent);
                return ultimateParent;
            }
        }
    }

}
