package takeUForward.recursion.revision;

import java.util.ArrayList;

public class P23TheNQueensPuzzleSpaceOptimized {
    public static ArrayList<ArrayList<Integer>> nQueens(int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int[] left = new int[n];
        int[] upperDiagonal = new int[2*n-1];
        int[] lowerDiagonal = new int[2*n-1];
        int[][] board = new int[n][n];
        solve(0, ans, board, left, upperDiagonal, lowerDiagonal);
        return ans;
    }

    private static void solve(int col, ArrayList<ArrayList<Integer>> ans, int[][] board,
                              int[] left, int[] upperDiagonal, int[] lowerDiagonal) {
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
            if ( lowerDiagonal[row+col] == 0 && upperDiagonal[board.length-1+col-row] == 0 && left[row] == 0){
                board[row][col]=1;
                left[row] = 1;
                upperDiagonal[board.length-1+col-row] =1;
                lowerDiagonal[row+col] = 1;
                solve(col+1, ans, board, left, upperDiagonal, lowerDiagonal);
                board[row][col]=0;
                left[row] = 0;
                upperDiagonal[board.length-1+col-row] =0;
                lowerDiagonal[row+col] = 0;
            }
        }
    }
}
