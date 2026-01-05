package takeUForward.graph.traversals;

public class FloodFillAlgorithm {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int n = image.length, m = image[0].length;
        int[][] ans = new int[n][m];
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                ans[i][j] = image[i][j];
            }
        }

        int sourceColor = ans[sr][sc];
        dfs(ans, sr, sc, sourceColor, newColor);
        return ans;
    }

    private void dfs(int[][] ans, int row, int col, int sourceColor, int newColor) {
        if ( row < 0 || row >= ans.length || col <0 || col >= ans[0].length || ans[row][col] != sourceColor) return;
        ans[row][col] = newColor;
        dfs(ans,row+1,col, sourceColor, newColor);
        dfs(ans,row,col+1, sourceColor, newColor);
        dfs(ans,row-1,col, sourceColor, newColor);
        dfs(ans,row,col-1, sourceColor, newColor);
    }
}
