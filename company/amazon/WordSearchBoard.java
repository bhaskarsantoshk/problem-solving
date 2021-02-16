package company.amazon;

import java.util.ArrayList;

public class WordSearchBoard {
    public int exist(ArrayList<String> A, String B) {
        if ( A == null || A.size() == 0){
            return 0;
        }

        char[][] board = new char[A.size()][A.get(0).length()];
        for ( int i=0; i<board.length; i++){
            for ( int j=0; j<board[0].length; j++){
                board[i][j] = A.get(i).charAt(j);
            }
        }

        for ( int i=0; i< A.size(); i++){
            for ( int j=0; j< A.get(0).length(); j++){
                if ( exist(i, j, board, B, 0)){
                    return 1;
                }
            }
        }
        return 0;
    }

    private boolean exist(int i, int j, char[][] board, String word, int index) {
        if ( index == word.length() ){
            return true;
        }
        if ( i<0 || i >= board.length || j <0 || j >= board[0].length ){
            return false;
        }
        char c = board[i][j];
        if ( c != word.charAt(index)){
            return false;
        }
        // board[i][j] = '#'; // same letter may be used more than once
        boolean exists = exist(i+1, j, board, word, index+1) ||
                         exist(i, j+1, board, word, index+1) ||
                         exist(i-1, j, board, word, index+1) ||
                         exist(i, j-1, board, word, index+1);
       // board[i][j] = c;
        return exists;
    }
}
