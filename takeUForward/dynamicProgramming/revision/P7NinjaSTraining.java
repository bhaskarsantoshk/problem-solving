package takeUForward.dynamicProgramming.revision;

import java.util.Arrays;

public class P7NinjaSTraining {
    public int ninjaTraining(int[][] matrix) {
        int n = matrix.length;
        return f(matrix,n-1, 3);
    }

    private int f(int[][] matrix,int day, int last) {
        if ( day == 0){
            int max = 0;
            for ( int i=0; i<3; i++){
                if ( i!= last){
                    max = Math.max(max, matrix[day][i]);
                }
            }
            return max;
        }

        int max = 0;
        for ( int i=0; i<3; i++){
            if ( i != last){
                int points = matrix[day][i] + f(matrix, day-1, i);
                max = Math.max( max, points);
            }
        }
        return max;
    }


    public int ninjaTrainingMemo(int[][] matrix) {
        int n = matrix.length;
        int [][] dp = new int[n][4];
        for ( int[] a: dp){
            Arrays.fill(a, -1);
        }
        return f(matrix,n-1, 3, dp);
    }

    private int f(int[][] matrix,int day, int last, int[][] dp) {
        if ( day == 0){
            int max = 0;
            for ( int i=0; i<3; i++){
                if ( i!= last){
                    max = Math.max(max, matrix[day][i]);
                }
            }
            return max;
        }
        if ( dp[day][last] != -1) return dp[day][last];

        int max = 0;
        for ( int i=0; i<3; i++){
            if ( i != last){
                int points = matrix[day][i] + f(matrix, day-1, i);
                max = Math.max( max, points);
            }
        }
        return dp[day][last]= max;
    }

    public int ninjaTrainingTabulation(int[][] points) {
        int n = points.length;
        int [][] dp = new int[n][4];
        dp[0][0] = Math.max( points[0][1], points[0][2]);
        dp[0][1] = Math.max( points[0][0], points[0][2]);
        dp[0][2] = Math.max( points[0][0], points[0][1]);
        dp[0][3] = Math.max ( Math.max( points[0][1], points[0][2]), points[0][3]);

        for ( int day=1; day<n; day++){
            for ( int last =0; last<4; last++){
                dp[day][last] = 0;
                for ( int task = 0; task < 3; task++){
                    if ( task != last){
                        int point = points[day][task] + dp[day-1][task];
                        dp[day][last] = Math.max( dp[day][last], point);
                    }
                }
            }
        }
        return dp[n-1][3];
    }
}
