package striver_sde_sheet.arrays;

public class P48RotateImage {
    public void rotate(int[][] matrix) {
        int start = 0, end = matrix.length-1;
        while ( start < end ){
            int [] temp = matrix[start];
            matrix[start++] = matrix[end];
            matrix[end--] = temp;
        }

        // transpose 01 -> 10, 02 -> 20, 03 -> 30
        for ( int i=0; i<matrix.length; i++){
            for ( int j=i+1; j<matrix[0].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}

