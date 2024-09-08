package takeUForward.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L14NQueensLeetcodeHardBacktracking {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for ( int i=0; i<n; i++) Arrays.fill(board[i], '.');
        solve(board, 0, result, n);
        return result;
    }

    private void solve(char[][] board, int col, List<List<String>> result, int n) {
        if ( col == n){
            List<String> subList = new ArrayList<>();
            for ( int i=0; i<n; i++){
                String s = new String(board[i]);
                subList.add(s);
            }
            result.add(subList);
            return;
        }
        for ( int row=0; row<n; row++){
            if ( isSafeToPlace(board, row, col, n)){
                board[row][col] = 'Q';
                solve(board, col+1, result, n);
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafeToPlace(char[][] board, int row, int col, int n) {
        int curRow = row;
        int curCol = col;

        // Upper diagonal
        while ( curRow >= 0 && curCol >= 0){
            if ( board[curRow][curCol] == 'Q') return false;
            curCol--;
            curRow--;
        }

        curRow = row;
        curCol = col;

        // Left
        while ( curCol >= 0){
            if ( board[curRow][curCol] == 'Q') return false;
            curCol--;
        }

        curRow = row;
        curCol = col;

        // Lower Diagonal
        while ( curRow <n && curCol>=0){
            if ( board[curRow][curCol] == 'Q') return false;
            curCol--;
            curRow++;
        }
        return true;

    }

    public List<List<String>> solveNQueensOptimized(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for ( int i=0; i<n; i++) Arrays.fill(board[i], '.');
        boolean[] leftRow = new boolean[n];
        boolean[] lowerDiagonal = new boolean[2*n-1];
        boolean[] upperDiagonal = new boolean[2*n-1];
        solveOptimzed(board, 0, result, n, leftRow, lowerDiagonal, upperDiagonal);
        return result;
    }

    private void solveOptimzed(char[][] board, int col, List<List<String>> result, int n,
                               boolean[] leftRow, boolean[] lowerDiagonal, boolean[] upperDiagonal) {
        if ( col == n){
            List<String> subList = new ArrayList<>();
            for ( int i=0; i<n; i++){
                String s = new String(board[i]);
                subList.add(s);
            }
            result.add(subList);
            return;
        }

        for ( int row=0; row<n; row++){
            if ( !leftRow[row] &&
                    !lowerDiagonal[col+row] &&
                    !upperDiagonal[n-1+col-row] ) {
                board[row][col] = 'Q';
                leftRow[row] = true;
                lowerDiagonal[row+col] = true;
                upperDiagonal[n-1+col-row] = true;
                solveOptimzed(board, col+1,result, n, leftRow, lowerDiagonal, upperDiagonal );
                board[row][col] = '.';
                leftRow[row] = false;
                lowerDiagonal[row+col] = false;
                upperDiagonal[n-1+col-row] = false;
            }
        }
    }

}
