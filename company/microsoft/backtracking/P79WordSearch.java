package company.microsoft.backtracking;

public class P79WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        char[][] wordBoard = new char[m][n];
        for (int i=0; i<m; i++){
            for ( int j=0; j<n; j++) wordBoard[i][j] = board[i][j];
        }
        for ( int i=0; i<m; i++){
            for ( int j=0; j<n; j++){
                if ( existsDFS(wordBoard, i, j, word, m, n, 0)) return true;
            }
        }
        return false;
    }

    private boolean existsDFS(char[][] wordBoard, int i, int j, String word, int m, int n, int index) {
        if ( index == word.length() ) return true;
        if ( i < 0 || i>= m || j <0 || j>=n || word.charAt(index) != wordBoard[i][j]) return false;
        char c = wordBoard[i][j];
        wordBoard[i][j] = '#';
        boolean exists = false;
        for ( int du=-1; du<=1; du++){
            for ( int dv=-1; dv<=1; dv++){
                exists = exists || existsDFS(wordBoard, i+du, j+dv, word, m, n, index+1);
            }
        }
        wordBoard[i][j] = c;
        return exists;
    }
}
