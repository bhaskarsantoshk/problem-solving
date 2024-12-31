package company.karat;

import java.util.HashSet;
import java.util.Set;

public class P2133CheckIfEveryRowAndColumnContainsAllNumbers {
    public boolean checkValid(int[][] matrix) {
        Set<String> seen = new HashSet<>();
        for ( int i=0; i<matrix.length; i++){
            for ( int j=0; j<matrix[0].length; j++){
                int num = matrix[i][j];
                if ( !seen.add(num+" in row "+ i) || !seen.add(num + " in col "+ j)) return false;
            }
        }
        return true;
    }
}
