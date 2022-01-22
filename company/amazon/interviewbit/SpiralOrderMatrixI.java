package company.amazon.interviewbit;

public class SpiralOrderMatrixI {
    public int[] spiralOrder(final int[][] A) {
        int left = 0, right = A[0].length-1, top = 0, bottom = A.length-1;
        int direction = 0;
        int [] result = new int[A.length * A[0].length];
        int index = 0;
        while ( left <= right && top <= bottom ){
            if ( direction == 0 ){
                for ( int i=left; i<=right; i++){
                    result[index++] = A[top][i];
                }
                direction = 1;
                top++;
            }
            else if ( direction == 1){
                for ( int i=top; i<=bottom; i++){
                    result[index++]= A[i][right];
                }
                direction = 2;
                right --;
            }
            else if ( direction == 2){
                for ( int i=right; i>=left; i--) {
                    result[index++] = A[bottom][i];
                }
                direction = 3;
                bottom--;
            }
            else if ( direction == 3){
                for ( int i=bottom; i>=top; i--){
                    result[index++] = A[i][left];
                }
                direction = 0;
                left++;
            }
        }
        return result;
    }
}
