package LeetCode;

public class P79WordSearch {
    public boolean exist(char[][] board, String word) {
        char [] w= word.toCharArray();
        for (int i=0; i< board.length; i++){
            for (int j=0; j< board[0].length; j++){
                if ( exist(board, i , j, w, 0)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean exist(char[][] board, int i, int j, char[] word, int index) {
        if ( index == word.length ){
            return true;
        }
        if ( i < 0 || j < 0 || i == board.length || j == board[0].length ){
            return false;
        }
        if ( board[i][j] != word[index] ){
            return false;
        }
        char c = board[i][j];
        board[i][j] = '#';

        boolean exist = exist(board, i, j+1, word, index+1)
                || exist(board, i+1, j, word, index+1)
                || exist(board, i-1, j, word, index+1)
                || exist(board, i, j-1, word, index +1);
        board[i][j] = c;
        return exist;

    }

}
