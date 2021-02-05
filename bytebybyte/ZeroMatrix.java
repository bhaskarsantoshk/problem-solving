package bytebybyte;

public class ZeroMatrix {

    public void zeroMatrix (boolean[][] a){
        boolean[] rows = new boolean[a.length];
        boolean[] cols = new boolean[a[0].length];

        for ( int i=0; i<a.length; i++){
            for ( int j=0; j<a[0].length;j++){
                if (a[i][j]){
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        for ( int i=0; i<a.length; i++){
            for ( int j=0; j<a[0].length;j++){
                if (rows[i] = true || cols[j] == true){
                    a[i][j] = true;
                }
            }
        }
    }

    public void setMatrixTrue(boolean [][] matrix){
        if ( matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        boolean rowZero = false;
        boolean colZero = false;
        for ( boolean b: matrix[0]){
            rowZero |= b;
        }
        for (boolean[] b: matrix ){
            colZero |= b[0];
        }

        for ( int i=1; i<matrix.length; i++){
            for ( int j=1; j<matrix[0].length; j++){
                if ( matrix[i][j]){
                    matrix[i][0] = true;
                    matrix[0][j] = true;
                }
            }
        }

        // going through each row in the first column,if it's true, we are setting whole row to be true

        for ( int i=0; i<matrix.length; i++){
            if ( matrix[i][0] ){
                for ( int j=1; j<matrix[i].length; j++){
                    matrix[i][j] = true;
                }
            }
        }

        for ( int j=0; j<matrix[0].length; j++){
            if ( matrix[0][j]){
                for ( int i=1; i<matrix.length; i++){
                    matrix[i][j] = true;
                }
            }
        }

        if (rowZero){
            for ( int i=0; i<matrix[0].length; i++){
                matrix[0][i] = true;
            }
        }
        if ( colZero){
            for ( int i=0; i<matrix.length; i++){
                matrix[i][0] = true;
            }
        }
    }

}

/*

[true, false, false]             [true, true, true  ]
[false, false, false]    ->      [true, false, false]
[false,false, false]             [true, false, false]


if any cell is true, make the column and row to be true

 Brute Force : O (N ^2) Memory and Time
 Approach two: keep track of rows and columns that we need to make them true by storing 2 1D arrays rows[] and columns[]

 O(1) Space approach:

 we can use first row and matrix to keep track of rest of rows or columns if there are any true values.
 use two variables rowZero, colZero to determine whether the first row or first column to be true

 */
