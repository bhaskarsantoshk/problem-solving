package company.google.others;

public class P308RangeSumQuery2DMutable {
    private int[][] matrix ;
    public P308RangeSumQuery2DMutable(int[][] matrix) {
        this.matrix = matrix;
    }

    public void update(int row, int col, int val) {
        if ( row < 0 || row >= matrix.length || col < 0 || col>= matrix[0].length) return;
        matrix[row][col] = val;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if ( row1 < 0 || row1 >= matrix.length || col1 < 0 || col1>= matrix[0].length) return 0;
        if ( row2 < 0 || row2 >= matrix.length || col2 < 0 || col2>= matrix[0].length) return 0;
        int sum =0;
        for ( int i= row1; i<=row2; i++){
            for ( int j=col1; j<=col2; j++){
                sum+= matrix[i][j];
            }
        }
        return sum;
    }
}
