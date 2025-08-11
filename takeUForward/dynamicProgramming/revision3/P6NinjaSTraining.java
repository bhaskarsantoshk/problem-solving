package takeUForward.dynamicProgramming.revision3;

import java.util.Arrays;

public class P6NinjaSTraining {
    public int ninjaTraining(int[][] matrix) {
        int n = matrix.length;
        return f(n-1, matrix, 3);
    }

    private int f(int day, int[][] matrix, int last) {
        if ( day == 0){
            int max = 0;
            for ( int task=0; task<=2; task++) {
                if ( task != last) max = Math.max(max, matrix[0][task]);
            }
            return max;
        }
        int max = 0;
        for ( int task=0; task<=2; task++){
            if ( task != last) {
                max = Math.max(max, matrix[day][task] + f(day-1, matrix, task));
            }
        }
        return max;
    }

    public int ninjaTrainingMemoized(int[][] matrix) {
        int n = matrix.length;
        int [][] dp = new int[n][4];
        for ( int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        return f(n-1, matrix, 3, dp);
    }

    private int f(int day, int[][] matrix, int last, int[][] dp) {
        if ( day == 0){
            int max = 0;
            for ( int task=0; task<=2; task++) {
                if ( task != last) max = Math.max(max, matrix[0][task]);
            }
            return max;
        }
        if ( dp[day][last] != -1) return dp[day][last];
        int max = 0;
        for ( int task=0; task<=2; task++){
            if ( task != last) {
                max = Math.max(max, matrix[day][task] + f(day-1, matrix, task, dp));
            }
        }
        return dp[day][last] = max;
    }

    public int ninjaTrainingDP(int[][] matrix) {
        int n = matrix.length;
        int [][] dp = new int[n][4];
        dp[0][0] = Math.max(matrix[0][1], matrix[0][2]);
        dp[0][1] = Math.max(matrix[0][0], matrix[0][2]);
        dp[0][2] = Math.max(matrix[0][0], matrix[0][1]);
        dp[0][3] = Math.max(Math.max(matrix[0][1], matrix[0][2]), matrix[0][2]);
        for ( int day=1; day<n; day++){
            for ( int last =0; last<=3; last++){
                dp[day][last] = 0;
                for ( int task=0; task<=2; task++){
                    if ( task != last) {
                        dp[day][last] = Math.max(dp[day][last], matrix[day][task] + dp[day-1][task]);
                    }
                }
            }
        }
        return dp[n-1][3];
    }
}
