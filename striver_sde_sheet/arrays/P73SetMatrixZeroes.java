package striver_sde_sheet.arrays;

import java.util.Arrays;

public class P73SetMatrixZeroes {

    // Note: will not work if the matrix contains INT_MIN already
    // O(N^3)
    public void setZeroesBruteForce(int[][] matrix) {
        for ( int i=0; i<matrix.length; i++){
            for ( int j=0; j<matrix[0].length; j++){
                if ( matrix[i][j] == 0){
                    markRow(matrix, i);
                    markColumn(matrix, j);
                }
            }
        }
        for ( int i=0; i<matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if ( matrix[i][j] == Integer.MIN_VALUE) matrix[i][j]=0;
            }
        }
    }

    private void markColumn(int[][] matrix, int col) {
        for ( int row=0;row<matrix.length; row++){
            if ( matrix[row][col] != 0 ) matrix[row][col] = Integer.MIN_VALUE;
        }
    }

    private void markRow(int[][] matrix, int row) {
        for ( int col=0; col<matrix[0].length; col++){
            if ( matrix[row][col] != 0) matrix[row][col] = Integer.MIN_VALUE;
        }
    }


    // Slightly oprimized
    // T O(N^2) S O(N)
    public void setZeroesWithAuxialiaryArrays(int[][] matrix) {
        int row[] = new int[matrix.length];
        int col[] = new int[matrix[0].length];

        for ( int rowIndex=0; rowIndex<matrix.length; rowIndex++){
            for ( int colIndex=0; colIndex<matrix[0].length; colIndex++){
                if ( matrix[rowIndex][colIndex] == 0){
                    row[rowIndex] = -1;
                    col[colIndex] = -1;
                }
            }
        }

        for ( int rowIndex=0; rowIndex<matrix.length; rowIndex++){
            for ( int colIndex=0; colIndex<matrix[0].length; colIndex++){
                if ( row[rowIndex] == -1 || col[colIndex] == -1) matrix[rowIndex][colIndex] = 0;
            }
        }
    }

    // Space Optimized
    // Instead of taking an additional row array - can we take 1st column as our aux row col[0] = row of n size
    // Instead of taking an additional column array , can we take 1st row as our aux col row[0] = col of m size
    // 1st cell  will overlap, so take 1st column as aux row,  take  row [1-n] as aux col, take additional var for col
    //  int row[] = new int[matrix.length]; - use matrix[...][0]
    //  int col[] = new int[matrix[0].length]; - use matrix[0][...]
    public void setZeroes(int[][] matrix) {
    //    int row[] = new int[matrix.length]; - use matrix[...][0]
    //    int col[] = new int[matrix[0].length]; - use matrix[0][...]
        int col0 = 1;
        for ( int rowIndex=0; rowIndex<matrix.length; rowIndex++){
            for ( int colIndex=0; colIndex<matrix[0].length; colIndex++){
                if ( matrix[rowIndex][colIndex] == 0){
                    // mark ith row
                    matrix[rowIndex][0] = 0;
                    // mark jth col
                    if ( colIndex != 0) {
                        matrix[0][colIndex] = 0;
                    } else{
                        col0 = 0;
                    }
                }
            }
        }

        for ( int rowIndex=1; rowIndex<matrix.length; rowIndex++){
            for ( int colIndex=1; colIndex<matrix[0].length; colIndex++){
                // check for col and row
                if ( matrix[rowIndex][0] == 0 || matrix[0][colIndex] == 0) matrix[rowIndex][colIndex] = 0;
            }
        }

        if ( matrix[0][0] == 0){
            // everyone in first row will be 0
            Arrays.fill(matrix[0], 0);
        }
        if ( col0 == 0){
            for ( int rowIndex = 0; rowIndex<matrix.length; rowIndex++){
                matrix[rowIndex][0] = 0;
            }
        }
    }

}
