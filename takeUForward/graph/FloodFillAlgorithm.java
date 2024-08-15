package takeUForward.graph;

public class FloodFillAlgorithm {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        int m = image.length, n = image[0].length;
        int[][] resultImage = new int[m][n];
        for ( int i=0; i<m; i++){
            for( int j=0; j<n; j++){
                resultImage[i][j] = image[i][j];
            }
        }
        int sourceColor = image[sr][sc];
        dfs( sourceColor, sr, sc, newColor, resultImage, m, n);
        return resultImage;
    }

    static int [][] dirs = {{1,0}, {-1,0}, {0,-1}, {0,1}};

    private void dfs(int sourceColor, int row, int col, int newColor, int[][] resultImage, int m, int n) {
        if (resultImage[row][col] == newColor) return;
        resultImage[row][col] = newColor;
        for ( int[] dir : dirs){
            int nrow = row+dir[0];
            int ncol = col+ dir[1];
            if ( nrow >= 0 && nrow <m && ncol >= 0 && ncol <n && resultImage[nrow][ncol] == sourceColor){
                dfs(sourceColor, nrow, ncol, newColor, resultImage, m, n);
            }
        }
    }
}
