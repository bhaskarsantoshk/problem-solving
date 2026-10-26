package takeUForward.graph.revision4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class G42MostStonesRemovedWithSameRowOrColumn {
    public int maxRemove(int[][] stones, int n) {
        int maxRows =0,  maxCols = 0;
        for ( int[] stone: stones){
            maxRows = Math.max(maxRows, stone[0]);
            maxCols = Math.max(maxCols, stone[1]);
        }
        DisjointSet dsu = new DisjointSet(maxRows+maxCols+1);
        Set<Integer> stoneNodes = new HashSet<>();
        for ( int[] stone: stones){
            int row = stone[0], col = stone[1]+ maxRows+1;
            if ( dsu.find(row) == dsu.find(col)) continue;
            dsu.union(row, col);
            stoneNodes.add(row);
            stoneNodes.add(col);
        }
        int components = 0;
        for ( int node: stoneNodes){
            if ( node == dsu.find(node)) components++;
        }
        return n-components;
    }

    class DisjointSet{
        List<Integer> parent, size;
        DisjointSet(int n){
            parent = new ArrayList<>();
            size = new ArrayList<>();
            for ( int i=0; i<=n; i++){
                parent.add(i);
                size.add(1);
            }
        }

        public void union(int u, int v){
            int uParent = find(u), vParent = find(v);
            if ( uParent == vParent) return;
            if ( size.get(uParent) >= size.get(vParent)){
                parent.set(vParent, uParent);
                size.set(uParent, size.get(uParent)+ size.get(vParent));
            } else {
                parent.set(uParent, vParent);
                size.set(vParent, size.get(uParent)+ size.get(vParent));
            }
        }

        public int find (int node){
            if ( node == parent.get(node)) return node;
            int uParent = find(parent.get(node));
            parent.set(node, uParent);
            return uParent;
        }
    }
}
