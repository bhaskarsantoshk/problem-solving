package company.karat;

public class P79WordSearch {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        int[][] vis = new int[n][m];
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( board[i][j] == word.charAt(0)) {
                    if (existsDFS(word, vis, board, i, j, n, m, 0)) return true;
                }
            }
        }
        return false;
    }
    
    int [][] dirs = {{-1,0}, {0,-1}, {1,0}, {0,1}};

    private boolean existsDFS(String word, int[][] vis, char[][] board, int i, int j,int n, int m, int index) {
        if ( index == word.length()-1) return true;
        vis[i][j] = 1;
        boolean exists = false;
        for(int[] dir : dirs){
            int nRow = i+ dir[0];
            int nCol = j+ dir[1];
            if ( nRow >=0 && nRow<n && nCol >=0 && nCol <m && vis[nRow][nCol] == 0 && board[nRow][nCol] == word.charAt(index+1)){
                 exists  = exists || existsDFS(word, vis, board, nRow, nCol, n, m, index+1);
            }
        }
        vis[i][j] = 0;
        return exists;
    }
}
