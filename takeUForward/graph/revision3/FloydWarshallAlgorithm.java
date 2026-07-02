package takeUForward.graph.revision3;

public class FloydWarshallAlgorithm {
    public void shortestDistance(int[][] matrix) {
        int n = matrix.length;

        for ( int i=0; i<n; i++){
            for ( int j=0; j<n; j++){
                if ( matrix[i][j] == -1) matrix[i][j] = (int)1e9;
            }
        }

        for ( int k=0; k<n; k++){
            for ( int i=0; i<n; i++){
                for ( int j=0; j<n; j++){
                    matrix[i][j] = Math.min( matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }

        for ( int i=0; i<n; i++){
            for ( int j=0; j<n; j++){
                if ( matrix[i][j] == (int)1e9) matrix[i][j] = -1;
            }
        }
    }


    public void shortestDistanceBetter(int[][] matrix) {
        int n = matrix.length;

        for ( int k=0; k<n; k++){
            for ( int i=0; i<n; i++){
                for ( int j=0; j<n; j++){
                    // no path through intermediate node
                    if ( matrix[i][k] == -1 || matrix[k][j] == -1) continue;

                    // path exists through intermediate node
                    else if ( matrix[i][j] == -1) matrix[i][j] =  matrix[i][k] + matrix[k][j];

                    // a better path may exist
                    else {
                        matrix[i][j] = Math.min( matrix[i][j], matrix[i][k] + matrix[k][j]);
                    }
                }
            }
        }
    }
}
