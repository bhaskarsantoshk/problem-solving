package takeUForward.graph.revision2;

public class P9SurroundedRegions {
    public char[][] fill(char[][] mat) {
        int n = mat.length, m = mat[0].length;
        char[][] res = new char[n][m];
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                res[i][j] = mat[i][j];
            }
        }
        boolean[][] vis = new boolean[n][m];
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( (i==0 || i==n-1 || j==0 || j==m-1) && res[i][j] == '0' ) dfs(res, vis, i, j);
            }
        }

        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( res[i][j] == '0' && !vis[i][j] ) res[i][j] = 'X';
            }
        }
        return res;
    }

    int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};

    private void dfs(char[][] res, boolean[][] vis, int i, int j) {
        vis[i][j] = true;
        for ( int[] dir: dirs){
            int row = i+dir[0];
            int col = j+dir[1];
            if ( row >=0 && row < res.length && col >=0 && col < res[0].length
                    && !vis[row][col] && res[row][col] == '0'){
                vis[row][col] = true;
                dfs(res, vis, row, col);
            }
        }
    }
}
