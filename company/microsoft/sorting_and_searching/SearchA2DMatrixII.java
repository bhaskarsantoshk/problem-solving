package company.microsoft.sorting_and_searching;

public class SearchA2DMatrixII {

    /*
    n * m matrix convert to an array => matrix[x][y] => a[x * m + y]

    an array convert to n * m matrix => a[x] =>matrix[x / m][x % m];

     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if ( matrix == null || matrix.length == 0 ||
                matrix[0] == null || matrix[0].length == 0) return false;
        int row = 0, col = matrix[0].length-1;
        while ( row < matrix.length && col >=0){
            if ( matrix[row][col] == target) return true;
            else if ( matrix[row][col] < target){
                row++;
            } else{
                col--;
            }
        }
        return false;
    }
}
