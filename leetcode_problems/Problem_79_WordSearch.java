package leetcode_problems;

public class Problem_79_WordSearch {
    public boolean exist(char[][] board, String word) {
        if ( board.length == 0 || board[0].length == 0) {
            return false;
        }
        for ( int i=0; i<board.length; i++){
            for ( int j=0; j<board[0].length; j++){
                if ( exist(board, i, j, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }


    private boolean exist( char[][] board, int i, int j, String word, int index ){
        if ( index == word.length() ){
            return true;
        }
        if ( i<0 || i>= board.length || j<0 || j>=board[0].length){
            return false;
        }
        char c = board[i][j];
        if ( c!= word.charAt(index)){
            return false;
        }
        board[i][j] = '#';
        boolean exists = exist(board, i+1, j, word, index+1)
                || exist(board, i, j+1, word, index+1)
                || exist(board, i-1, j, word, index+1)
                || exist(board, i, j-1, word, index+1);
        board[i][j] = c;

        return exists;
    }
}
