package takeUForward.graph.revision2;

public class P5FloodFillAlgorithm {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int srcColor = image[sr][sc];
        if (srcColor == newColor) return image;
        dfs(image, sr, sc, srcColor, newColor);
        return image;
    }

    int [][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};

    private void dfs(int[][] image, int row, int col, int srcColor, int newColor) {
        image[row][col] = newColor;
        for ( int []dir: dirs){
            int nRow = row + dir[0];
            int nCol = col + dir[1];
            if ( nRow >= 0 && nRow < image.length
                    && nCol >=0 && nCol < image[0].length
                    && image[nRow][nCol] == srcColor) {
                dfs(image, nRow, nCol, srcColor, newColor);
            }
        }
    }
}
