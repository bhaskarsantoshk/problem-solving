package striver_sde_sheet.arrays;

import java.util.Arrays;

public class P74SearchA2DMatrix {
    // Extreme naive -> O(N^2)

    // Matrix is sorted
    // check in each row if the target is between first and last element of the row, if not move to next row
    // apply binary search on the particular row
    // T = O(N+ long N)
    public boolean searchMatrixLinear(int[][] matrix, int target) {
        for ( int row[] : matrix){
            if ( target >= row[0] && target <= row[matrix[0].length-1]){
                return Arrays.binarySearch(row, target) >= 0;
            }
        }
        return false;
    }

    // Hypothetically flatten the matrix to 1D array
    // Binary search on it would take O( long (n*m) )
    // No need to do the explicit flattening as it takes n*n
    // take a 4*3 matrix, if it's in a 1D array, it will have 12 elements, low = 0, end = 11, mid =5
    // find a formula to convert the hypothetical 1D coordinate to 2D coordinate
    // every row has m numbers
    // formula is mid/m , mid%m if the matrix is n*m matrix
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int low = 0, high = n*m -1;
        while ( low <= high ){
            int mid = low + (high-low)/2;
            int row = mid/m , col = mid%m;
            if ( matrix[row][col] == target){
                return true;
            } else if ( matrix[row][col] > target){
                high= mid-1;
            } else{
                low = mid+1;
            }
        }
        return false;
    }
}
