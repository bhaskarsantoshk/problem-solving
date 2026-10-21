package takeUForward.graph.revision4;

import java.util.ArrayList;
import java.util.List;

public class G40NumberOfIslandsII {
    public List<Integer> numOfIslands(int n, int m, int[][] A) {
        DisjointSet dsu = new DisjointSet(n * m);
        int count = 0;
        List<Integer> result = new ArrayList<>();
        int [][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        int [][] vis = new int[n][m];
        for ( int i=0; i<A.length; i++){
            int row = A[i][0];
            int col = A[i][1];

            if ( vis[row][col] == 1) {
                result.add(count);
                continue;
            } else {
                vis[row][col] = 1;
                count++;
                for ( int [] dir: dirs){
                    int nRow = row+ dir[0];
                    int nCol = col + dir[1];

                    if ( nRow >= 0 && nRow < n && nCol >=0 && nCol < m ){
                        if ( vis[nRow][nCol] == 1){
                            int u = row * m + col;
                            int v = nRow * m + nCol;
                            if ( dsu.find(u) != dsu.find(v)){
                                count--;
                                dsu.union(u, v);
                            }
                        }
                    }
                }
                result.add(count);
            }
        }
        return result;
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

        public int find(int node){
            if ( node == parent.get(node)) return node;
            int ultimateParent = find(parent.get(node));
            parent.set(node, ultimateParent);
            return ultimateParent;
        }

        public void union(int u, int v){
            int uParent = find(u);
            int vParent = find(v);
            if ( uParent == vParent) return;
            if ( size.get(uParent) >= size.get(vParent)){
                parent.set(vParent, uParent);
                size.set(uParent, size.get(uParent)+ size.get(vParent));
            } else {
                parent.set(uParent, vParent);
                size.set(vParent, size.get(uParent)+ size.get(vParent));
            }
        }
    }
}
