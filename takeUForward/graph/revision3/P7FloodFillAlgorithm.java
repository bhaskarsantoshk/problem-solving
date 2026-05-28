package takeUForward.graph.revision3;

public class P7FloodFillAlgorithm {

    private int[][] dirs = {{-1,0}, {0,-1}, {1,0}, {0,1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int n = image.length, m = image[0].length;
        if( image[sr][sc] == newColor) return image;
        int[][] ans = new int[n][m];
        for ( int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                ans[i][j] = image[i][j];
            }
        }
        int srcColor = image[sr][sc];
        dfs(ans, sr, sc, newColor, srcColor);
        return ans;
    }

    private void dfs(int[][] ans, int row, int col, int newColor, int srcColor) {
        if ( row < 0 || row >= ans.length || col < 0 || col >= ans[0].length || ans[row][col] != srcColor) return;
        ans[row][col] = newColor;
        for ( int[] dir: dirs){
            dfs(ans, row+dir[0], col+dir[1], newColor, srcColor);
        }
    }

    /*
    Time: O(n*m)
Space: O(n*m) for copy + recursion stack worst case
     */
}
