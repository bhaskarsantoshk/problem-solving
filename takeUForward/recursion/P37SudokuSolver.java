package takeUForward.recursion;

public class P37SudokuSolver {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board){
        for ( int row=0; row<board.length; row++){
            for ( int col=0; col< board[0].length ; col++){
                if ( board[row][col] == '.'){
                    for ( char c='1'; c <='9'; c++){
                        if ( isValid(board, row, col, c)){
                            board[row][col] = c;
                            if (solve(board)) return true;
                            else board[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    boolean isValid(char [][] board, int row, int col, char c){
        for ( int i=0; i <9; i++){
            if ( board[i][col] == c) return false;
            if ( board[row][i] == c) return false;
            if ( board [ 3 * (row/3) + i/3][ 3 * (col/3) + i % 3] == c) return false;
        }
        return true;
    }
}
