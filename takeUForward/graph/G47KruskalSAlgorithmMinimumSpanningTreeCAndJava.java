package takeUForward.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class G47KruskalSAlgorithmMinimumSpanningTreeCAndJava {


    // Krushkal's algorithm

    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        List<Edge> edges = new ArrayList<>();
        // O(N+E)
        for ( int i=0; i<V; i++){
            for ( int j=0; j<adj.get(i).size(); j++){
                int adjNode = adj.get(i).get(j)[0];
                int wt = adj.get(i).get(j)[1];
                int node = i;
                Edge edge = new Edge(node, adjNode, wt);
                edges.add(edge);
            }
        }
        DisjointSet ds = new DisjointSet(V);

        // O(M log M )
        Collections.sort(edges);
        int mstWt = 0;
        // O(M * 4 * alpha)
        for ( Edge edge : edges){
            int u = edge.u;
            int v = edge.v;
            int weight = edge.weight;

            if ( ds.findUParent(u) != ds.findUParent(v)){
                mstWt += weight;
                ds.unionBySize(u,v);
            }
        }
        return mstWt;
    }

    private static class Edge implements Comparable<Edge> {
        int u, v, weight;

        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge edge) {
            return this.weight- edge.weight;
        }
    }

    static class DisjointSet{
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        public DisjointSet(int n){
           for ( int i=0; i<=n; i++){
               parent.add(i);
               size.add(1);
           }
        }

        public int findUParent(int u){
            if ( u == parent.get(u)) return u;
            int uParent = findUParent(parent.get(u));
            parent.set(u, uParent);
            return uParent;
        }

        public void unionBySize(int u, int v){
            int uParent = findUParent(u);
            int vParent = findUParent(v);

            if ( uParent == vParent) return;
            if ( size.get(uParent) > size.get(vParent)){
                parent.set(vParent, uParent);
                size.set(uParent, size.get(uParent)+1);
            } else {
                parent.set(uParent, vParent);
                size.set(vParent, size.get(vParent)+1);
            }
        }
    }

}
