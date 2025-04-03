package takeUForward.recursion.revision;

import java.util.ArrayList;
import java.util.List;

public class P25MColoringProblem {
    public static String graphColoring(int [][]mat, int m) {
       List<Integer>[] G = new ArrayList[mat.length];
       for ( int i=0; i<mat.length; i++){
           G[i] = new ArrayList<>();
           for ( int j=0; j<mat[i].length; j++){
               if ( mat[i][j] == 1){
                   G[i].add(j);
               }
           }
       }
       int[] color = new int[mat.length];
       boolean res = solve(G, m, 0, color);
       return res ? "YES": "NO";
    }

    private static boolean solve(List<Integer>[] G, int m, int node, int[] color) {
        if ( node == G.length) return true;
        for ( int col=1;col<=m; col++){
            if ( isSafe(node, G, col, color)){
                color[node] = col;
                if ( solve( G, m, node+1, color)) return true;
            }
        }
        return false;
    }

    private static boolean isSafe(int node, List<Integer>[] g, int col, int[] color) {
        for ( int adjNode: g[node]){
            if ( color[adjNode] == col) return false;
        }
        return true;
    }
}
