package company.amazon.leetcode;

import java.util.HashSet;
import java.util.Set;

public class P36ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for ( int i=0; i<9; i++){
            for ( int j=0; j<9; j++){
                char num = board[i][j];
                if ( num != '.'){
                    if ( !seen.add(num+" in row "+i)
                            || !seen.add(num+" in col "+j)
                            || !seen.add(num+" in grid "+ i/3+" "+j/3)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
