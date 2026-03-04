package company.apple;

import java.util.ArrayList;
import java.util.List;

public class P10SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int left = 0, right = matrix[0].length-1;
        int top = 0, bottom = matrix.length-1;
        int dir = 0;
        while ( left <= right && top <= bottom){
            if ( dir == 0){
                for ( int i=left ; i<=right; i++){
                    result.add(matrix[top][i]);
                }
                top++;
                dir = 1;

            } else if ( dir == 1){
                for ( int i= top; i<=bottom; i++){
                    result.add(matrix[i][right]);
                }
                right--;
                dir = 2;
            } else if ( dir == 2){
                for ( int i=right; i>=left; i--){
                    result.add(matrix[bottom][i]);
                }
                bottom--;
                dir = 3;

            } else if ( dir == 3){
                for ( int i=bottom; i>= top; i--){
                    result.add(matrix[i][left]);
                }
                left++;
                dir = 0;
            }
        }
        return result;
    }
}
