package company.microsoft.sorting_and_searching;

public class SearchA2DMatrix {

    /*
    n * m matrix convert to an array => matrix[x][y] => a[x * m + y]

    an array convert to n * m matrix => a[x] =>matrix[x / m][x % m];

     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int start = 0, end = n * m-1;
        while ( start <= end){
            int mid = start + (end -start)/2;
            int row = mid/m, col = mid%m;
            if ( matrix[row][col] == target) return true;
            else if ( matrix[row][col] > target){
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return false;
    }
}
