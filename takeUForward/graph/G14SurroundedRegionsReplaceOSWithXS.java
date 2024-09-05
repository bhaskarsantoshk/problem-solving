package takeUForward.graph;

public class G14SurroundedRegionsReplaceOSWithXS {
    static char[][] fill(int n, int m, char a[][])
    {
        char[][] res = new char[n][m];
        boolean[][] vis = new boolean[n][m];

        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( (i == 0 || i== n-1 || j==0 || j == m-1) && !vis[i][j] && a[i][j] == 'O'){
                    dfs(a, vis, res, n, m, i, j);
                }
            }
        }

        for ( int i=0; i<n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 'X') {
                    res[i][j] = 'X';
                } else if (a[i][j] == 'O' && !vis[i][j]) {
                    res[i][j] = 'X';
                } else{
                    res[i][j] = 'O';
                }
            }
        }

        return res;
    }

    static int [][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};

    private static void dfs(char[][] a, boolean[][] vis, char[][] res, int n, int m, int row, int col) {
        vis[row][col] = true;
        res[row][col] = 'O';
        for ( int[] dir: dirs){
            int nrow = row+dir[0];
            int ncol = col+ dir[1];
            if ( nrow >=0 && nrow <n && ncol >= 0 && ncol <m && !vis[nrow][ncol] && a[nrow][ncol] == 'O'){
                dfs(a, vis, res, n, m, nrow, ncol);
            }
        }
    }
}
