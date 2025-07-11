package takeUForward.graph.revision.traversal_probelms;

public class P5FloodFillAlgorithm {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int initialColor = image[sr][sc];
        int n = image.length, m = image[0].length;
        int[][] ans = new int[n][m];
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                ans[i][j] = image[i][j];
            }
        }
        dfs(image, ans, initialColor, newColor, sr, sc);
        return ans;
    }

    private void dfs(int[][] image, int[][] ans, int initialColor,
                     int newColor, int row, int col) {
        int n= image.length, m = image[0].length;
        if ( row < 0 || row >= n || col < 0 || col >=m ||
                image[row][col] != initialColor || ans[row][col] == newColor) return;
        ans[row][col] = newColor;
        dfs(image, ans, initialColor, newColor, row-1, col);
        dfs(image, ans, initialColor, newColor, row, col+1);
        dfs(image, ans, initialColor, newColor, row+1, col);
        dfs(image, ans, initialColor, newColor, row, col-1);

        // int [][] dirs = { {-1,0}, {0,1}, {1,0}, {0,-1}}
        // for ( int [] dir: dirs ){
        // dfs(row+ dir[0], col+dir[1])
        // }
    }
}
