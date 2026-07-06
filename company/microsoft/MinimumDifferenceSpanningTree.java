package company.microsoft;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MinimumDifferenceSpanningTree {
    class DisjointSet{
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        DisjointSet(int n){
            for ( int i=0; i<=n; i++){
                parent.add(i);
                size.add(1);
            }
        }

        public void unionBySize(int u, int v){
            int uParent = findParent(u);
            int vParent = findParent(v);
            if ( uParent == vParent) return;
            if ( size.get(uParent) > size.get(vParent)){
                parent.set(vParent, uParent);
                size.set(uParent, size.get(uParent)+1);
            } else {
                parent.set(uParent, vParent);
                size.set(vParent, size.get(vParent)+1);
            }
        }

        public int findParent(int node){
            if (node == parent.get(node)) return node;
            int uParent = findParent(parent.get(node));
            parent.set(node, uParent);
            return uParent;
        }

    }

    public int minimumDifference(int n, int[][] graph) {
        List<Edge> edges = new ArrayList<>();
        for ( int [] edge: graph){
            edges.add(new Edge(edge[0], edge[1], edge[2]));
        }
        edges.sort(Comparator.comparingInt(e-> e.w));
        int m = edges.size();
        int ans = Integer.MAX_VALUE;

        for ( int start = 0; start<n; start++){
            DisjointSet dsu = new DisjointSet(n);
            int used = 0;
            for ( int j= start ; j<m; j++){
                Edge e = edges.get(j);
                if ( dsu.findParent(e.u) != dsu.findParent(e.v)){
                    used++;
                    if ( used == n-1){
                        ans = Math.min(ans, e.w- edges.get(start).w);
                        break;
                    }
                }
            }
        }

        return ans;
    }

    class Edge{
        int u, v, w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
}
