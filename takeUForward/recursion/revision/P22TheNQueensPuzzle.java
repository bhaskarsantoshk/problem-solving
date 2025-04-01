package takeUForward.recursion.revision;

import java.util.ArrayList;

public class P22TheNQueensPuzzle {
    public static ArrayList<ArrayList<Integer>> nQueens(int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int[][] board = new int[n][n];
        solve(0, ans, board);
        return ans;
    }

    private static void solve(int col, ArrayList<ArrayList<Integer>> ans, int[][] board) {
        if ( col == board.length){
            ArrayList<Integer> list;
            list = new ArrayList<>();
            for ( int i=0; i<board.length; i++){
                for ( int j=0; j<board[0].length; j++){
                    list.add(board[i][j]);
                }
            }
            ans.add(new ArrayList<>(list));
            return;
        }
        for ( int row=0; row<board.length; row++){
            if ( isSafeToPlace(board, row, col)){
                board[row][col]=1;
                solve(col+1, ans, board);
                board[row][col]=0;
            }
        }
    }

    private static boolean isSafeToPlace(int[][] board, int row, int col) {
        int curRow = row, curCol = col;

        // left row
        while ( curCol >=0 ){
            if ( board[curRow][curCol] == 1) return false;
            curCol--;
        }

        // upper diagonal
        curRow = row;
        curCol = col;

        while ( curCol>=0 && curRow>=0){
            if ( board[curRow][curCol] == 1) return false;
            curCol--;
            curRow--;
        }

        // lower diagonal
        curRow = row;
        curCol = col;

        while ( curCol>=0 && curRow<board.length){
            if ( board[curRow][curCol] == 1) return false;
            curCol--;
            curRow++;
        }
        return true;
    }
}
