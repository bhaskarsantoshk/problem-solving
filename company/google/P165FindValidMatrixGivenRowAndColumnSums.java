package company.google;

public class P165FindValidMatrixGivenRowAndColumnSums {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int [][] matrix = new int[rowSum.length][colSum.length];

        for ( int i=0; i<matrix.length; i++){
            for ( int j=0; j<matrix[0].length; j++){
                matrix[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= matrix[i][j];
                colSum[j] -= matrix[i][j];
            }
        }
        return matrix;
    }

    public int[][] restoreMatrixOptimized(int[] row, int[] col) {
        int m = row.length, n = col.length, i = 0, j = 0, a;
        int[][] A = new int[m][n];
        while (i < m && j < n) {
            a = A[i][j] = Math.min(row[i], col[j]);
            if ((row[i] -= a) == 0) ++i;
            if ((col[j] -= a) == 0) ++j;
        }
        return A;
    }
}
