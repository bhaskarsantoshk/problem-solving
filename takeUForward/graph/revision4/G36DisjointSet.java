package takeUForward.graph.revision4;

import java.util.ArrayList;
import java.util.List;

public class G36DisjointSet {
    class DisjointSet{

        List<Integer> parent, rank, size;
        DisjointSet(int n){
            parent = new ArrayList<>();
            size = new ArrayList<>();
            rank = new ArrayList<>();

            for ( int i=0; i<n; i++){
                parent.add(i);
                size.add(1);
                rank.add(0);
            }
        }

        public boolean find(int u, int v) {
            return findUltimateParent(u) == findUltimateParent(v);
        }

        public void unionByRank(int u, int v) {
            int parentU = findUltimateParent(u);
            int parentV = findUltimateParent(v);
            if ( parentU == parentV) return;
            if ( rank.get(parentU) > rank.get(parentV)){
                parent.set(parentV, parentU);
            } else if ( rank.get(parentU) < rank.get(parentV)){
                parent.set(parentV, parentU);
            } else {
                parent.set(parentV, parentU);
                int uRank = parent.get(parentU);
                rank.set(parentU, uRank+1);
            }
        }

        public void unionBySize(int u, int v) {
            int parentU = findUltimateParent(u);
            int parentV = findUltimateParent(v);
            if ( size.get(parentU) < size.get(parentV)){
                parent.set(parentU, parentV);
                size.set(parentV, size.get(parentV)+1);
            } else {
                parent.set(parentV, parentU);
                size.set(parentU, size.get(parentU)+1);
            }
        }

        private int findUltimateParent(int node) {
            if ( node == parent.get(node)) return node;
            else {
                int ultimateParent = findUltimateParent(parent.get(node));
                parent.set(node, ultimateParent);
                return ultimateParent;
            }
        }
    }
}
