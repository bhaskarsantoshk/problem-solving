package takeUForward.graph.revision3;

import java.util.Arrays;

public class P36FindTheCityWithTheSmallestNumberOfNeighbors {
    public int findCity(int n, int m, int edges[][],
                        int distanceThreshold) {

        int[][] distance = new int[n][n];
        for ( int i=0; i<n; i++) Arrays.fill(distance[i], Integer.MAX_VALUE);
        for ( int[] edge : edges){
            int u = edge[0], v = edge[1], wt = edge[2];
            distance[u][v] = distance[v][u] = wt;
        }
        for (int i=0; i<n; i++) for ( int j=0; j<n; j++) if ( i == j) distance[i][j] = 0;

        for ( int k=0; k<n; k++){
            for ( int i=0; i<n; i++){
                for ( int j=0; j<n; j++){
                    // no imtermediate path
                    if ( distance[i][k] == Integer.MAX_VALUE || distance[k][j] == Integer.MAX_VALUE) continue;
                    else distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }

        int minNeighbours = n;
        int resultCity = -1;

        for ( int i=0; i<n; i++){
            int count = 0;
            for ( int j=0; j<n; j++){
                if ( distance[i][j] <= distanceThreshold) count++;
            }
            if ( count <= minNeighbours){
                minNeighbours = count;
                resultCity = i;
            }
        }

        return  resultCity;
    }
}
