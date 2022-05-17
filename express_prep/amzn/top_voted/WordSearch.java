package express_prep.amzn.top_voted;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if ( word == null || word.length() == 0 ) return true;
        if ( board == null || board.length == 0 ) {
            return false;
        }
        for ( int i=0; i<board.length; i++){
            for ( int j=0; j<board[0].length; j++ ){
                if ( exist(board, i, j, word, 0) ){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int i, int j, String word, int index) {
        if (index == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board.length || board[i][j] != word.charAt(index)) {
            return false;
        }
        char c = board[i][j];
        board[i][j] = '#';
        boolean exists = exist(board, i + 1, j, word, index + 1)
                || exist(board, i   , j + 1, word, index + 1)
                || exist(board, i-1, j, word, index+1)
                || exist(board, i, j-1, word, index+1);
        board[i][j] = c;
        return exists;
    }
}
