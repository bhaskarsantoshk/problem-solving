package takeUForward.graph;

import java.util.ArrayList;
import java.util.List;

public class G51NumberOfIslandsIIOnlineQueriesDSU {

    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        DisjointSet ds = new DisjointSet(rows*cols);
        int [][] vis = new int[rows][cols];
        int count = 0;
        List<Integer> ans = new ArrayList<>();
        for (int[] operator : operators) {
            int row = operator[0];
            int col = operator[1];
            if ( vis[row][col] == 1){
                ans.add(count);
                continue;
            }
            vis[row][col] = 1; // mark it as land
            count++;
            int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0, -1}};
            for ( int []dir: dirs){
                int nRow = row + dir[0];
                int nCol = col + dir[1];

                if ( isValid(nRow, nCol, rows, cols) && vis[nRow][nCol] == 1){
                    int nodeNo =  row * cols + col;
                    int adjNode = nRow * cols + nCol;
                    if ( ds.findParent(nodeNo) != ds.findParent(adjNode)){
                        count--;
                        ds.unionBySize(nodeNo, adjNode);
                    }
                }
            }
            ans.add(count);
        }
        return ans;
    }

    private boolean isValid(int nRow, int nCol, int rows, int cols) {
        return nRow>=0 && nRow<rows && nCol>=0 && nCol<cols;
    }

    static class DisjointSet{
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        DisjointSet(int n){
            for ( int i=0; i<n; i++){
                parent.add(i);
                size.add(1);
            }
        }

        public int findParent(int node){
            if ( node == parent.get(node)) return node;
            int uParent = findParent(parent.get(node));
            parent.set(node, uParent);
            return uParent;
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
    }
}
