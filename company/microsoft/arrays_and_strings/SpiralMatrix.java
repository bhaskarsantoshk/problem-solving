package company.microsoft.arrays_and_strings;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0, bottom = matrix.length-1;
        int left = 0, right = matrix[0].length-1;
        int dir = 0;
        List<Integer> res = new ArrayList<>();
        while ( top <= bottom && left <= right){
            if ( dir == 0){
               for ( int i=left; i<=right; i++){
                   res.add(matrix[top][i]);
               }
               top++;
               dir=1;
            } else if ( dir == 1){
                for ( int i=top; i<=bottom; i++){
                    res.add(matrix[i][right]);
                }
                right--;
                dir = 2;
            } else if ( dir == 2){
                for ( int i = right; i>=left; i--){
                    res.add(matrix[bottom][i]);
                }
                bottom--;
                dir = 3;
            } else if ( dir == 3){
                for ( int i=bottom; i >= top; i--){
                    res.add(matrix[i][left]);
                }
                left++;
                dir=0;
            }
        }
        return res;
    }
}
