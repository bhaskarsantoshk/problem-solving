package takeUForward.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L16MColoringProblemBacktracking {
    boolean graphColoring(int[][] edges, int m, int n) {
       List<Integer>[] G = new ArrayList[n];
       for ( int i=0; i<n; i++) G[i] = new ArrayList<>();
       for ( int[] edge:edges){
           int u= edge[0], v = edge[1];
           G[u].add(v);
           G[v].add(u);
       }

       int [] colors = new int[n];
       Arrays.fill(colors, -1);
       return dfs(0, G, n, m , colors);
    }

    private boolean dfs(int node, List<Integer>[] g, int n, int m, int[] colors) {
        if ( node == n) return true;
        for ( int num= 1; num<= m; num++){
            if ( isValid(node, g, n, m, colors, num)){
                colors[node] = num;
                boolean val = dfs( node+1, g, n, m, colors);
                if ( val) return true;
                colors[node] = -1;
            }
        }
        return false;
    }

    private boolean isValid(int node, List<Integer>[] g, int n, int m, int[] colors, int col) {
        for ( int adjNode: g[node]){
            if (colors[adjNode] == col) return false;
        }
        return true;
    }
}
