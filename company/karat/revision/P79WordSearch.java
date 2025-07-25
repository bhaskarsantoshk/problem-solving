package company.karat.revision;

public class P79WordSearch {
    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        int [][] vis = new int[n][m];
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                if ( exists(board, vis, word, 0, i, j, n, m )) return true;
            }
        }
        return false;
    }

    int [][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    private boolean exists(char[][] board, int[][] vis, String word,
                           int index,int row, int col,  int n, int m) {
        if ( row < 0 || row >= n || col <0  || col >= m || vis[row][col] == 1 || index >= word.length() || board[row][col] != word.charAt(index)) return false;
        if ( index == word.length()-1) {
            vis[row][col] = 0;
            return true;
        }
        vis[row][col] = 1;
        boolean exists = false;
        for ( int dir[] : dirs){
            int nRow = row + dir[0];
            int nCol = col+ dir[1];
            exists = exists || exists(board, vis, word, index+1, nRow, nCol, n, m);
            if ( exists ) return true;
        }
        vis[row][col] = 0;
        return exists;
    }
}
