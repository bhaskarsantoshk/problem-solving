package LeetCode;

public class P54SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if ( matrix == null || matrix.length == 0 ){
            return result;
        }
        int top = 0, bottom = matrix.length-1;
        int left = 0, right = matrix[0].length -1;
        int dir = 0;

        while ( top <= bottom && left <= right ){
            if ( dir == 0 ){
                for ( int i= left; i<= right; i++){
                    result.add( matrix[top][i]);
                }
                dir = 1;
                top++;
            }
            else if ( dir == 1){
                for (int i= top ; i<= bottom ; i++){
                    result.add(matrix[i][right]);
                }
                dir = 2;
                right--;
            }

            else if ( dir == 2 ){
                for (int i = right; i>= left; i--){
                    result.add( matrix[bottom][i]);
                }
                dir = 3;
                bottom--;
            }

            else if ( dir == 3){
                for(int i= bottom; i>= top; i--){
                    result.add(matrix[i][left]);
                }
                dir = 0;
                left++;
            }
        }
        return result;
    }
}
