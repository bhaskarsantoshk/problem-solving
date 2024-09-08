package takeUForward.recursion;

public class L15SudokoSolverBacktracking {
    public void solveSudoku(char[][] board) {
        sudokuSolver(board);
    }

    private boolean sudokuSolver(char[][] board) {
        for ( int i=0; i<board.length; i++){
            for ( int j=0; j<board[0].length; j++){
                if ( board[i][j] == '.'){
                    for ( char digit = '0'; digit<='9'; digit++){
                        if ( areRulesMat(board, i, j, digit)){
                            board[i][j] = digit;
                            boolean val = sudokuSolver(board);
                            if ( val ) return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean areRulesMat(char[][] board, int row, int col, char digit) {
        for ( int i=0; i<=8; i++){
            if ( board[i][col] == digit) return false;
            if ( board[row][i] == digit) return false;
            if ( board[3 * (row/3) + i/3][3 * (col/3)+ i %3] == digit) return false;
        }
        return true;
    }
}
