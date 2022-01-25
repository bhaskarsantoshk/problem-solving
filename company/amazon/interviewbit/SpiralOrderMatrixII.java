package company.amazon.interviewbit;

public class SpiralOrderMatrixII {
    public int[][] generateMatrix(int A) {
        int [][] result = new int [A][A];
        int top = 0, bottom = A-1;
        int left = 0, right = A-1;
        int val = 1;
        int direction = 0;

        while ( left <= right && top <= bottom ){
            if ( direction == 0){
                for ( int i=left; i<=right; i++){
                    result[top][i] = val++;
                }
                direction = 1;
                top++;
            }
            else if ( direction == 1){
                for ( int i=top; i<= bottom; i++){
                    result[i][right] = val++;
                }
                direction = 2;
                right--;
            }
            else if ( direction == 2){
                for ( int i=right; i>= left; i--){
                    result[bottom][i] = val++;
                }
                direction = 3;
                bottom--;
            }
            else if ( direction == 3 ){
                for ( int i=bottom; i>= top ; i--){
                    result[i][left] = val++;
                }
                direction = 0;
                left++;
            }
        }

        return result;
    }
}
