package takeUForward.dynamicProgramming;

import java.util.Arrays;

public class DP48MatrixChainMultiplicationMCMPartitionDP {
    public static int matrixMultiplication(int[] arr , int N) {
        return f(1, N-1, arr);
    }

    private static int f(int i, int j, int[] arr) {
        if ( i == j) return 0;
        int min = (int)1e9;
        for ( int k=i; k<=j-1; j++){
            int steps = arr[i-1] * arr[k] * arr[j] + f(i, k, arr) + f(k+1, j,arr);
            if ( steps < min) min = steps;
        }
        return min;
    }

    public static int matrixMultiplicationMemo(int[] arr , int N) {
        int [][] memo = new int[N][N];
        for ( int[] row: memo) Arrays.fill(row, -1);
        return matrixMultiplicationMemo(1, N-1, arr, memo);
    }

    private static int matrixMultiplicationMemo(int i, int j, int[] arr, int[][] memo) {
        if ( i == j) return 0;
        if ( memo[i][j] != -1) return memo[i][j];
        int min = (int)1e9;
        for ( int k=i; k<j; k++){
            int steps = arr[i-1] * arr[k] * arr[j] + matrixMultiplicationMemo(i, k, arr, memo)
                    + matrixMultiplicationMemo(k+1, j,arr, memo);
            if ( steps < min) min = steps;
        }
        return memo[i][j]= min;
    }
}
