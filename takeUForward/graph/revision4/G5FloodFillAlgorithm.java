package takeUForward.graph.revision4;

public class G5FloodFillAlgorithm {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int srcCol = image[sr][sc];
        if ( srcCol == newColor) return image;
        int n = image.length, m = image[0].length;
        int [][] result = new int[n][m];
        for ( int i=0; i<n; i++){
            for ( int j=0; j< m ; j++){
                result[i][j] = image[i][j];
            }
        }
        floodFill(result,n, m, sr, sc, srcCol, newColor);
        return result;
    }

    int [][] dirs = {{-1,0}, {0,-1}, {1,0}, {0,1}};
    private void floodFill(int[][] result, int n, int m, int row, int col, int srcCol, int newColor) {
        result[row][col] = newColor;
        for ( int[] dir: dirs){
            int nRow = row+dir[0];
            int nCol = col+ dir[1];

            if ( nRow >=0 && nRow < n && nCol >=0 && nCol < m && result[nRow][nCol] == srcCol){
                floodFill(result, n, m, nRow, nCol, srcCol, newColor);
            }
        }
    }
}
