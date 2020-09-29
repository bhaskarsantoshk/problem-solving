public class SpiralOrderMatrixI {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] spiralOrder(final int[][] A) {
        int []result = new int[A.length * A[0].length];
        int index = 0;
        int left = 0, right= A[0].length-1;
        int top = 0, bottom = A.length-1;
        int dir = 0;
        while ( left <= right && top<= bottom){
            if ( dir == 0){
                for ( int i=left; i<= right; i++){
                    result[index++] = A[top][i];
                }
                top++;
                dir = 1;
            }
            else if ( dir == 1){
                for (int i=top; i<=bottom; i++){
                    result[index++] = A[i][right];
                }
                right--;
                dir = 2;
            }
            else if (dir == 2){
                for(int i=right; i>=left; i--){
                    result[index++] = A[bottom][i];
                }
                bottom--;
                dir = 3;
            }
            else if ( dir == 3){
                for ( int i=bottom; i>= top; i--){
                    result[index++] = A[i][left];
                }
                left++;
                dir = 0;
            }
        }
        return result;
    }
}
