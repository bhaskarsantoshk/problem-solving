package takeUForward.graph;

import java.util.*;

public class G52MakingALargeIslandDSU {
    public int MaxConnection(int grid[][]) {
        int n = grid.length, m = grid[0].length;
        DisjointSet ds = new DisjointSet(n *m);

        int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};

        // Step 1:
        for (int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( grid[i][j] == 0) continue;
                for ( int[] dir : dirs){
                    int nRow = i + dir[0];
                    int nCol = j+ dir[1];
                    if ( isValid(nRow, nCol, n, m) && grid[nRow][nCol] == 1){
                        int nodeNo = i*m + j;
                        int adjNodeNo = nRow * m + nCol;
                        ds.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }
        }

        // Step 2:
        int max = 0;

        for (int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( grid[i][j] == 1) continue;
                Set<Integer> components = new HashSet<>();
                for ( int[] dir : dirs){
                    int nRow = i + dir[0];
                    int nCol = j+ dir[1];
                    if ( isValid(nRow, nCol, n, m) && grid[nRow][nCol] == 1){
                        int adjNodeNo = nRow * m + nCol;
                        components.add(ds.findParent(adjNodeNo));
                    }
                }
                int sizeTotal = 0;
                for ( Integer parent: components){
                    sizeTotal += ds.size.get(parent);
                }
                max = Math.max( max, 1+sizeTotal);
            }
        }

        for ( int cellNo=0; cellNo < n *m ; cellNo++){
            max = Math.max( max, ds.size.get(cellNo));
        }
        return max;
    }

    private boolean isValid(int row, int col, int n, int m) {
        return (row>=0 && row<n && col >=0 && col<m);
    }

    class DisjointSet{
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        DisjointSet(int n){
            for ( int i=0; i<n; i++){
                parent.add(i);
                size.add(1);
            }
        }

        public void unionBySize(int u, int v){
            int uParent = findParent(u);
            int vParent = findParent(v);
            if ( uParent == vParent) return;
            if ( size.get(uParent) > size.get(vParent)) {
                parent.set(vParent, uParent);
                size.set(uParent, size.get(uParent)+size.get(vParent));
            } else {
                parent.set(uParent, vParent);
                size.set(vParent, size.get(uParent)+size.get(vParent));
            }
        }

        private int findParent(int node) {
            if ( node == parent.get(node)) return node;
            int uParent = findParent(parent.get(node));
            parent.set(node, uParent);
            return uParent;
        }
    }

}
