package company.apple;

public class P21SparseMatrixMultiplication {
    public int[][] multiply(int[][] mat1, int[][] mat2) {

        int[][] res = new int[mat1.length][mat2[0].length];

        for (int i = 0; i < mat1.length; i++) {

            for (int k = 0; k < mat1[0].length; k++) {

                if (mat1[i][k] == 0) continue;

                for (int j = 0; j < mat2[0].length; j++) {

                    if (mat2[k][j] == 0) continue;

                    res[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }

        return res;
    }
}
