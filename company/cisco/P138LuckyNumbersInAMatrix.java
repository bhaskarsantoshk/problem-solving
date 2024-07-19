package company.cisco;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P138LuckyNumbersInAMatrix {
    public List<Integer> luckyNumbers (int[][] matrix) {
        Set<Integer> minSet = new HashSet<>();
        Set<Integer> maxSet = new HashSet<>();

        for ( int row[] : matrix){
            int min = row[0];
            for ( int cell: row){
                min = Math.min( min, cell);
            }
            minSet.add(min);
        }

        for ( int j=0; j< matrix[0].length; j++){
            int max = matrix[0][j];
            for ( int i=0; i<matrix.length; i++){
                max = Math.max(max, matrix[i][j]);
            }
            if ( minSet.contains(max)){
                maxSet.add(max);
            }
        }

        return new ArrayList<>(maxSet);
    }
}
