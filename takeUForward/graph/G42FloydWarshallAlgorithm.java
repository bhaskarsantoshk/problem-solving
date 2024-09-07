package takeUForward.graph;

import java.util.Arrays;

public class G42FloydWarshallAlgorithm {
    public void shortest_distance(int[][] matrix)
    {
       int n = matrix.length;
       for ( int i=0; i<n; i++){
           for ( int j=0; j<n; j++){
               if ( matrix[i][j] == -1) matrix[i][j] = (int)1e9;
               if ( i == j) matrix[i][j] = 0;
           }
       }

       for ( int via=0; via<n; via++){
           for ( int i=0; i<n; i++){
               for ( int j=0; j<n; j++){
                   matrix[i][j] = Math.min( matrix[i][j], matrix[i][via]+matrix[via][j]);
               }
           }
       }

       for ( int i=0; i<n; i++){
           if ( matrix[i][i] < 0) {
               // Cycle exists.
               throw new IllegalStateException("Negative Cycle");
           }
       }

        for ( int i=0; i<n; i++){
            for ( int j=0; j<n; j++){
                if ( matrix[i][j] == (int)1e9) matrix[i][j] = -1;
            }
        }
    }
}
