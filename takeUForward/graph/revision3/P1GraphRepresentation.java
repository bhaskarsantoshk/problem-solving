package takeUForward.graph.revision3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P1GraphRepresentation {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();


        // Adjacency List
        List<Integer>[] G = new ArrayList[n+1];
        for ( int i=0; i<=n; i++) G[i] = new ArrayList<>();
        while (m-- != 0){
            int u = in.nextInt(); int v = in.nextInt();
            G[u].add(v);
            G[v].add(u);
        }


        // Adjacency Matrix
        n = in.nextInt();
        m = in.nextInt();
        int[][] GMatrix = new int[n+1][n+1];
        while (m-- != 0){
            int u = in.nextInt(); int v = in.nextInt();
            GMatrix[u][v] = GMatrix[v][u] =1;

        }
    }

    /*
    Adjacency list

* Build: O(n + m)
* Space: O(n + 2m)

Adjacency matrix

* Build: O(m)
* Space: O(n²)
     */
}
