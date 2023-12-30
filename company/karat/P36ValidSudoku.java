package company.karat;

import java.util.HashSet;
import java.util.Set;

public class P36ValidSudoku {
    public boolean isValidSudoku(char[][] board) {

        // 3*3 3*3 3*3
        // 3*3 3*3 3*3
        // 3*3 3*3 3*3

        // A number should not be repeated in row
        // A number should not be repeated in col
        // A number should not be repeated in grid
        // for row, col - it's easy to identify as it's straightforward i, j
        // for grid, remember this - a number at i,j belongs to grid of i/3, j/3

        Set<String> seen = new HashSet<>();
        for ( int i=0; i<board.length; i++){
            for ( int j=0; j<board[0].length; j++){
                if ( board[i][j] != '.'){
                    if ( !seen.add(board[i][j] +" in row " + i)
                            || !seen.add(board[i][j]+" in col "+ j)
                            || !seen.add(board[i][j]+ "in grid "+ i/3 +":"+j/3 )){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
