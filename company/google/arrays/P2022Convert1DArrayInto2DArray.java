package company.google.arrays;

public class P2022Convert1DArrayInto2DArray {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int [][] emp = new int[0][0];
        if ( original.length != m * n) return emp;
        int[][] result = new int[m][n];
        int i=0, j=0;
        int index = 0;
        while ( i < m && j < n){
            for ( int col=0; col<n; col++){
                result[i][col] = original[index];
                index++;
            }
            i++;
        }
        return result;
    }
}
