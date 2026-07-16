package takeUForward.graph.revision;

public class FloodFillAlgorithm {

    int[][] dirs = {{0,-1}, {-1,0}, {0,1}, {1,0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if ( image[sr][sc] == newColor) return image;
        int n = image.length, m = image[0].length;
        int[][] resultImage = new int[n][m];
        for ( int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                resultImage[i][j] = image[i][j];
            }
        }
        dfs(resultImage, sr, sc, resultImage[sr][sc] ,newColor, n, m);
        return resultImage;
    }

    private void dfs(int[][] resultImage, int row, int col, int srcColor, int newColor, int n, int m) {
        if ( row >=0 && row < n && col >=0 && col <m && resultImage[row][col] == srcColor){
            resultImage[row][col] = newColor;

            for ( int[] dir : dirs){
                int nRow = row+dir[0];
                int nCol = col + dir[1];
                dfs(resultImage, nRow, nCol, srcColor, newColor, n, m);
            }
        }
    }
}
