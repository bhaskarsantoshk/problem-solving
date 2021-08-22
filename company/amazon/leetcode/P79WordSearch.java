package company.amazon.leetcode;

public class P79WordSearch {
    public boolean exist(char[][] board, String word) {
        if ( word == null || word.isEmpty() ) return true;
        if ( board == null || board.length == 0) return false;
        for ( int i=0; i<board.length; i++){
            for ( int j=0; j<board[0].length; j++){
                if ( exist(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, String word, int i, int j, int index) {
        if ( index == word.length() ) return true;
        if ( i <0 || i >= board.length || j<0 || j>= board[0].length) return false;
        char c = board[i][j];
        if ( c != word.charAt(index)){
            return false;
        }
        board[i][j] = '#';
        boolean exists =  exist(board, word, i+1, j, index+1)
                || exist(board, word, i, j+1, index+1)
                || exist(board, word, i-1, j, index+1)
                || exist(board, word, i , j-1, index+1);
        board[i][j] = c;
        return exists;

    }
}
