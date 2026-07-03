package takeUForward.graph.revision2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P40MostStonesRemovedWithSameRowOrColumn {

    public int maxRemove(int[][] stones, int n) {
        int maxRows = 0, maxCols = 0;
        for ( int [] stone: stones){
            maxRows = Math.max(maxRows, stone[0]);
            maxCols = Math.max( maxCols, stone[1]);
        }

        DisjointSet ds = new DisjointSet(maxRows+maxCols+1);
        Set<Integer> stoneNodes = new HashSet<>();
        for ( int[] stone: stones){
            int row = stone[0];
            int col = stone[1] + maxRows+1;
            if ( ds.find(row) == ds.find(col))  continue;
            ds.union(row, col);
            stoneNodes.add(row);
            stoneNodes.add(col);
        }

        int components = 0;

        for ( int node: stoneNodes){
            if ( node == ds.parent.get(node)) components++;
        }

        return n-components;
    }

    class DisjointSet{
        private List<Integer> parent = new ArrayList<>();
        private List<Integer> size = new ArrayList<>();
        private List<Integer> rank = new ArrayList<>();

        DisjointSet(int n){
            for ( int i=0; i<=n; i++){
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
