package takeuForward.recursion;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P51NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i=0; i<n ; i++){
            Arrays.fill(board[i], '.');
        }
        solve ( 0, board, res, n);
        return res;
    }

    private void solve(int col, char[][] board, List<List<String>> res, int n) {
        if ( col == n){
            List<String> list = new ArrayList<>();
            for ( int i=0; i < n ; i++) {
                String s = new String(board[i]);
                list.add(s);
            }
            res.add(list);
            return;
        }

        for ( int row=0; row<n; row++){
            if ( isSafeToPlaceAQueen(row, col, board, n)) { // takes O(3 N) // TODO : optimize this
                board[row][col] = 'Q';
                solve(col+1, board, res, n);
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafeToPlaceAQueen(int row, int col, char[][] board, int n) {
        int curRow = row;
        int curCol = col;

        // upper diagonal
        while (curRow >= 0 && curCol >=0 ){
            if ( board[curRow][curCol] == 'Q') return false;
            curRow--;
            curCol--;
        }

        // left
        curRow = row;
        curCol = col;
        while ( curCol >= 0){
            if ( board[curRow][curCol] == 'Q') return false;
            curCol--;
        }

        // lower diagonal
        curRow = row;
        curCol = col;
        while ( curRow < n && curCol >= 0){
            if ( board[curRow][curCol] == 'Q') return false;
            curRow++;
            curCol--;
        }
        return true;
    }


    public List<List<String>> solveNQueensOptimized(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i=0; i<n ; i++){
            Arrays.fill(board[i], '.');
        }
        int [] currentRow = new int[n];
        int [] upperDiagonal = new int[ 2*n -1];
        int [] lowerDiagonal = new int[ 2*n -1 ];
        solveOptimized( 0, board, res, n, currentRow, upperDiagonal, lowerDiagonal);
        return res;
    }

    private void solveOptimized(int col, char[][] board, List<List<String>> res, int n, int[] currentRow, int[] upperDiagonal, int[] lowerDiagonal) {
        if ( col == n){
            List<String> list = new ArrayList<>();
            for ( int i=0; i < n ; i++) {
                String s = new String(board[i]);
                list.add(s);
            }
            res.add(list);
            return;
        }

        for ( int row=0; row<n; row++){
            if ( currentRow[row] == 0
                    && lowerDiagonal[row+col] == 0 && upperDiagonal[n-1+col-row] == 0) {
                board[row][col] = 'Q';
                currentRow[row] = 1;
                lowerDiagonal[row+col] = 1;
                upperDiagonal[n-1+col-row] = 1;
                solveOptimized(col+1, board, res, n, currentRow, upperDiagonal, lowerDiagonal);
                board[row][col] = '.';
                currentRow[row] = 0;
                lowerDiagonal[row+col] = 0;
                upperDiagonal[n-1+col-row] = 0;
            }
        }
    }
}
