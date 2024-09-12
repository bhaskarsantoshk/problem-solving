package takeUForward.dynamicProgramming;

public class MatrixChainMultiplication {
    public static int matrixMultiplication(int[] arr , int N) {
        return f(1, N-1, arr);
    }

    private static int f(int i, int j, int[] arr) {
        if ( i == j) return 0;
        int min = Integer.MAX_VALUE;
        for ( int k=i; k<=j-1; k++){
            int steps = arr[i-1] * arr[k] * arr[j] + f( i, k, arr)+f(k+1, j, arr);
            min = Math.min(min, steps);
        }
        return min;
    }
}
