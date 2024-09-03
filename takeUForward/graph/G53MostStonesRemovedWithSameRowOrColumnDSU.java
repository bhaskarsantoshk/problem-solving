package takeUForward.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class G53MostStonesRemovedWithSameRowOrColumnDSU {
    // N^ 2
    int maxRemoveUsingDFS(int[][] stones, int n) {

        // Build Graph
        List<Integer>[] G= new ArrayList[n];
        for ( int i=0; i<n; i++) G[i] = new ArrayList<>();
        for ( int i=0; i<n; i++){
            for ( int j=i+1; j<n; j++){
                int stone1[] = stones[i];
                int stone2[] = stones[j];
                if ( connected(stone1, stone2)){
                    G[i].add(j);
                    G[j].add(i);
                }
            }
        }
       // n - connectedComponents
        int connectedComponent = 0;
        boolean vis[] = new boolean[n];
        for ( int i=0; i<n; i++){
            if ( !vis[i]){
                dfs(i, vis, G);
                connectedComponent++;
            }
        }
        return n - connectedComponent;
    }

    private void dfs(int node, boolean[] vis, List<Integer>[] g) {
        vis[node] = true;
        for ( int adjNode: g[node]){
            if ( !vis[adjNode]) dfs(adjNode, vis, g);
        }
    }

    private boolean connected(int[] stone1, int[] stone2) {
        return ( stone1[0] == stone2[0] || stone1[1] == stone2[1]);

    }


    int maxRemoveUsingDFS2(int[][] stones, int n) {
       Set<int[]> vis = new HashSet<>();
       int connectedComponents = 0;
       for ( int[] stone: stones){
           if ( !vis.contains(stone)){
               dfs2( stone, stones, vis);
               connectedComponents++;
           }
       }
       return n-connectedComponents;
    }

    private void dfs2(int[] stone, int[][] stones, Set<int[]> vis) {
        vis.add(stone);
        for ( int [] stone2: stones){
            if ( !vis.contains(stone2) && (stone[0] == stone2[0] || stone[1] == stone2[1])){
                dfs2(stone2, stones, vis);
            }
        }
    }





    // Disjoint Set is more efficient

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

    int maxRemove(int[][] stones, int n) {
        int maxRow = 0, maxCol = 0;
        for ( int[] stone: stones){
            maxRow = Math.max( maxRow, stone[0]);
            maxCol = Math.max( maxCol, stone[1]);
        }
        DisjointSet ds = new DisjointSet(maxRow+maxCol+1);
        Set<Integer> set = new HashSet<>();
        for ( int[] stone: stones){
            int nodeRow = stone[0];
            int nodeCol = stone[1] + maxRow+1;
            ds.unionBySize(nodeRow, nodeCol);
            set.add(nodeRow);
            set.add(nodeCol);
        }
        int connectedComponents = 0;
        for ( Integer node: set){
            if ( node == ds.findParent(node)) connectedComponents++;
        }
        return n- connectedComponents;
    }

}
