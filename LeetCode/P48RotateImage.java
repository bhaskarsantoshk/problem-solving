package LeetCode;

public class P48RotateImage {
    public void rotate(int[][] matrix) {
        reverseRows(matrix);
        transpose(matrix);
    }

    private void transpose(int[][] matrix) {
        for(int i=0; i<matrix.length; i++){
            for(int j=i+1; j<matrix[0].length; j++){
                int temp= matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i]=temp;
            }
        }
    }

    private void reverseRows(int[][] matrix) {
        int low = 0, high= matrix.length-1;
        while(low < high){
            int temp[] = matrix[low];
            matrix[low]= matrix[high];
            matrix[high]=temp;
            low++;
            high--;
        }
    }

}
