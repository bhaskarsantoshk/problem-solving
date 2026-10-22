package takeUForward.graph.revision4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class G41MakingALargeIsland {
    public int largestIsland(int[][] grid) {
        // step 1 : connect
        int n = grid.length, m = grid[0].length;
        int [][] dirs = {{0,1},{1,0}, {-1,0}, {0,-1}};
        DisjointSet dsu = new DisjointSet(n*m);
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( grid[i][j] == 0) continue;
                for ( int[] dir: dirs){
                    int nRow = i + dir[0], nCol = j + dir[1];
                    if ( nRow >=0 && nRow < n && nCol >=0 && nCol < n &&  grid[nRow][nCol] == 1){
                        int u = i*m+j;
                        int v = nRow*m + nCol;
                        dsu.union(u,v);
                    }
                }
            }
        }

        // step two , calculate size keep edge case in mind
        int max = 0;
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( grid[i][j] == 0){
                    Set<Integer> set = new HashSet<>();
                    for ( int[] dir: dirs){
                        int nRow = i+ dir[0], nCol = j+ dir[1];
                        if ( nRow >=0 && nRow < n && nCol >=0 && nCol < n &&  grid[nRow][nCol] == 1){
                            set.add(dsu.find(nRow*m+ nCol));
                        }
                    }
                    int total = 1;
                    for ( int num: set) total+= dsu.size.get(num);
                    max = Math.max(total, max);
                }
            }
        }
        for (int i=0; i<n*m; i++){
            max = Math.max(max, dsu.size.get(dsu.find(i)));
        }
        return max;
    }

    class DisjointSet{
        List<Integer> parent, size;
        DisjointSet(int n){
            parent = new ArrayList<>();
            size = new ArrayList<>();
            for ( int i=0; i<n; i++){
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
