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
}
