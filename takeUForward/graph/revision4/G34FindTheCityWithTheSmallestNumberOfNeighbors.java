package takeUForward.graph.revision4;

import java.util.Arrays;

public class G34FindTheCityWithTheSmallestNumberOfNeighbors {
    public int findCity(int n, int m, int edges[][],
                        int distanceThreshold) {

        int [][] distance = new int[n][n];
        for ( int i=0; i<n; i++) Arrays.fill(distance[i], Integer.MAX_VALUE);
        for ( int[] edge : edges){
            int u = edge[0], v = edge[1], wt = edge[2];
            distance[u][v] = distance[v][u] = wt;
        }

        for ( int i=0; i<n; i++) distance[i][i] = 0;

        for ( int k=0; k<n; k++){
            for ( int i=0; i < n; i++){
                for ( int j=0; j<n; j++){
                    if ( distance[i][k] == Integer.MAX_VALUE || distance[k][j] == Integer.MAX_VALUE) continue;
                    else if ( distance[i][j] == Integer.MAX_VALUE ) distance[i][j] = distance[i][k] + distance[k][j];
                    else distance[i][j] = Math.min( distance[i][k] + distance[k][j], distance[i][j]);
                }
            }
        }


        int city = -1;
        int minCities = Integer.MAX_VALUE;
        for ( int i=0; i<n; i++){
            int count = 0;
            for ( int j=0; j<n; j++){
                if ( distance[i][j] <= distanceThreshold) count++;
            }
            if ( count <= minCities) {
                city = i;
                minCities = count;
            }
        }

        return city;
    }
}
