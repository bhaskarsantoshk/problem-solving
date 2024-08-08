package company.google;

public class P885SpiralMatrixIII {
    int index = 0;
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int [][] res = new int[rows*cols][2];
        // 1 1 2 2 3 3 4 4 5 5 ~~ n/2 + 1
        int len = 1;
        while ( index < rows * cols){
            for ( int k=0; k<len; k++) add(rStart, cStart++, rows, cols, res);
            for ( int k=0; k<len; k++) add(rStart++, cStart, rows, cols, res);
            len++;
            for ( int k=0; k<len; k++) add(rStart, cStart--, rows, cols, res);
            for ( int k=0; k<len; k++) add(rStart--, cStart, rows, cols, res);
            len++;
        }
        return res;
    }

    private void add(int row, int col, int rows, int cols, int[][] res) {
        if ( row <0 || row >= rows || col <0 || col >= cols ) return;
        res[index][0] = row;
        res[index][1] = col;
        index++;
    }
}
