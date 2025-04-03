package takeUForward.recursion.revision;

public class P24SudokuSolver {
    public static void solveSudoku(int[][] sudoku) {
        solve(sudoku);
    }

    private static boolean solve(int[][] sudoku) {
        for ( int i=0; i<sudoku.length; i++){
            for ( int j=0; j<sudoku[0].length; j++){
                if ( sudoku[i][j] == 0){

                    for ( int num=1; num<=9; num++){
                       if ( isValid(sudoku, i, j, num)){
                           sudoku[i][j] = num;
                           if ( solve(sudoku) ) return true;
                           sudoku[i][j] = 0;
                       }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(int[][] sudoku, int row, int col, int num) {
        for ( int i=0; i<9; i++){
            if ( sudoku[row][i] == num) return false;
            if ( sudoku[i][col] == num) return false;
            if (sudoku[3*(row/3)+ i/3][3*(col/3) + i%3] == num ) return false;
        }
        return true;
    }
}
