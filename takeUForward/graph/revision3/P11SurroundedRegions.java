package takeUForward.graph.revision3;

import java.util.LinkedList;
import java.util.Queue;

public class P11SurroundedRegions {
    public char[][] fill(char[][] mat) {
        int n = mat.length, m = mat[0].length;
        boolean[][] vis = new boolean[n][m];
//        char[][] grid = new char[n][m];
//        for ( int i=0; i<n; i++){
//            for (int j=0; j<m; j++){
//                grid[i][j] = mat[i][j];
//            }
//        } That allocates an entirely new matrix on the heap. If the board is large, you now have two full character matrices in memory
        for ( int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if( ( i==0 || i==n-1 || j==0 || j== m-1 ) && !vis[i][j] && grid[i][j] == 'O'){
                    // dfs(i,j, mat, n, m, vis);
                    bfs(i,j, mat, n, m, vis);
                }
            }
        }
        for ( int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if ( mat[i][j] == 'O' && !vis[i][j]){
                    mat[i][j] = 'X';
                }
            }
        }
        return mat;
    }

    private void bfs(int i, int j, char[][] grid, int n, int m, boolean[][] vis) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i,j});
        vis[i][j] = true;
        while (!queue.isEmpty()){
            int[] node = queue.poll();
            for ( int[] dir: dirs){
                int nRow = node[0]+dir[0];
                int nCol = node[1]+dir[1];
                if (nRow >=0 && nRow < n && nCol >=0 && nCol < m && !vis[nRow][nCol] && grid[nRow][nCol] == 'O'){
                    queue.offer(new int[]{nRow, nCol});
                    vis[nRow][nCol] = true;
                }
            }
        }
    }

    int[][] dirs = {{-1,0}, {0,-1}, {1,0}, {0,1}};
    private void dfs(int i, int j, char[][] grid, int n, int m, boolean[][] vis) {
        vis[i][j] = true;
        for (int[]dir: dirs){
            int nRow = i+dir[0]; int nCol = j+dir[1];
            if ( nRow >=0 && nRow < n && nCol>=0 && nCol<m && !vis[nRow][nCol] && grid[nRow][nCol] == 'O'){
                dfs(nRow, nCol, grid, n, m, vis);
            }
        }
    }
}
