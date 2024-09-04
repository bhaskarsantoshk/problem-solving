package takeUForward.trees;

public class P733FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if ( image == null || image.length == 0) return new int[][]{};
        int n = image.length, m = image[0].length;
        int[][] result = new int[n][m];
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                result[i][j] = image[i][j];
            }
        }
        dfs(result, sr, sc, result[sr][sc], color, n, m);
        return result;
    }

    static int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};

    private void dfs(int[][] result, int sr, int sc, int srcColor, int newColor, int n, int m) {
        result[sr][sc] = newColor;
        for ( int []dir: dirs){
            int nRow = sr+dir[0];
            int nCol = sc+dir[1];
            if ( isVaalid( nRow, nCol, n, m) && result[nRow][nCol] == srcColor){
                dfs( result, nRow, nCol, srcColor, newColor, n, m);
            }
        }
    }

    private boolean isVaalid(int nRow, int nCol, int n, int m) {
        return (nRow >=0 && nRow<n && nCol>=0 && nCol<m);
    }
}
