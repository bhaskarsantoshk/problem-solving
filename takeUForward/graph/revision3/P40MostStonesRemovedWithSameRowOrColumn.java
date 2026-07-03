package takeUForward.graph.revision3;

import java.util.*;

public class P40MostStonesRemovedWithSameRowOrColumn {
    public int maxRemove(int[][] stones, int n) {
        Map<Integer, Integer> stoneNodes = new HashMap<>();
        int maxRow = 0, maxCol = 0;
        for (int i=0; i<n; i++){
            maxRow = Math.max( stones[i][0], maxRow);
            maxCol = Math.max(stones[i][1], maxCol);
        }

        DisjointSet ds = new DisjointSet(maxRow+maxCol+1);
        for (int []stone: stones){
            int nodeRow = stone[0];
            int nodeCol = stone[1]+ maxRow+1;
            ds.union(nodeRow, nodeCol);
            stoneNodes.put(nodeRow, 1);
            stoneNodes.put(nodeCol, 1);
        }

        int count = 0;

        for ( Map.Entry<Integer, Integer> entry: stoneNodes.entrySet()){
            if ( ds.find(entry.getKey()) == entry.getKey()) count++;
        }
        return n-count;
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
