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
    // TODO
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
}
