package takeUForward.arrays.faqs;

import java.util.ArrayList;
import java.util.List;

public class PrintTheMatrixInSpiralManner {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int n = matrix.length-1, m = matrix[0].length-1;

        int left = 0, right = m, top = 0, bottom = n;

        int flag = 0;

        while ( top <= bottom && left <= right){
            if ( flag == 0){
               for ( int i=left ; i<=right; i++){
                   result.add(matrix[top][i]);
               }
               top++;
               flag = 1;
            } else if ( flag == 1){
                for ( int i=top; i<=bottom; i++){
                    result.add(matrix[i][right]);
                }
                right--;
                flag = 2;
            } else if ( flag == 2){
                for ( int i=right; i>=left; i--){
                    result.add(matrix[bottom][i]);
                }
                bottom--;
                flag = 3;
            } else if ( flag == 3){
                for ( int i=bottom; i>= top; i--){
                    result.add(matrix[i][left]);
                }
                left++;
                flag = 0;
            }
        }

        return result;
    }
}
