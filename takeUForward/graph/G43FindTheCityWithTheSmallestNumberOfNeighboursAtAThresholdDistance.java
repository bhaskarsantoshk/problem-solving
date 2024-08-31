package takeUForward.graph;

import java.util.Arrays;

public class G43FindTheCityWithTheSmallestNumberOfNeighboursAtAThresholdDistance {
    int findCity(int n, int m, int[][] edges,int distanceThreshold)
    {
        // Floyd Warshal Algorithm
        int[][] distance = new int[n][n];
        for ( int [] row: distance) Arrays.fill(row, Integer.MAX_VALUE);
        for ( int[] edge : edges){
            distance[edge[0]][edge[1]] = edge[2];
            distance[edge[1]][edge[0]] = edge[2];
        }
        for (int i=0; i<n; i++) distance[i][i] =0;
        for ( int via = 0; via <n; via++){
            for ( int i=0; i<n; i++){
                for ( int j=0; j<n; j++){
                    if ( distance[i][via] == Integer.MAX_VALUE || distance[via][j] == Integer.MAX_VALUE) continue;
                    distance[i][j] = Math.min( distance[i][j], distance[i][via] + distance[via][j]);
                }
            }
        }

        int countCity = n;
        int cityNo = -1;
        for ( int city=0; city<n; city++){
            int count = 0;
            for ( int adjCity = 0; adjCity<n; adjCity++){
                if ( distance[city][adjCity] <= distanceThreshold) count++;
            }
            if ( count <= countCity) {
                countCity = count;
                cityNo = city;
            }
        }
        return cityNo;
    }
}
