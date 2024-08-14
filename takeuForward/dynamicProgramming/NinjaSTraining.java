package takeuForward.dynamicProgramming;

import java.util.Arrays;

public class NinjaSTraining {
    public static int ninjaTraining(int n, int points[][]) {
        return f(n-1, points, 3);
    }

    private static int f(int day, int[][] points, int last) {
        if ( day == 0){
            int max = 0;
            for ( int task=0; task<=2; task++){
                if ( task != last) max = Math.max(max, points[0][task]);
            }
            return max;
        }

        int max = 0;
        for ( int task =0; task<=2; task++){
            if ( task != last ){
                int meritPoints = points[day][task] + f(day-1, points, task);
                max = Math.max( max, meritPoints);
            }
        }
        return max;
    }

    // f( day, last )
    // f(n-1, 3) give me max merit points on an array 0 - n-1, and before n-1, no tasks were performed
    // f(2,1) give me max merit points on an array 0 - 2, and before 2, task 1 was performed at 3rd index

    // f(3,3)
    // f(2,0)                f(2,1),               f(2,2)
    //f(1,1)            f(1,2)
    // f(0,0), f(0,2)




    public static int ninjaTrainingMemoized(int n, int points[][]) {
        int [][] memo = new int[n][4];
        for ( int [] row: memo){
            Arrays.fill(row, -1);
        }
        return fMemoized(n-1, points, 3, memo);
    }

    private static int fMemoized(int day, int[][] points, int last, int[][] memo) {
        if ( day == 0){
            int max = 0;
            for ( int task=0; task<=2; task++){
                if ( task != last) max = Math.max(points[0][task], max);
            }
            return max;
        }

        if( memo[day][last] != -1) return memo[day][last];

        int max = 0;
        for ( int task =0; task<=2; task++){
            if ( task != last ){
                int meritPoints = points[day][task] + fMemoized(day-1, points, task, memo);
                max = Math.max( max, meritPoints);
            }
        }
        return memo[day][last] = max;
    }


    public static int ninjaTrainingTabular(int n, int points[][]) {
        int [][] dp = new int[n][4];
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(Math.max(points[0][0], points[0][1]), points[0][2]);

        for ( int day=1; day<n ; day++){
            for ( int last =0; last<=3; last++){
                dp[day][last] = 0;
                for ( int task =0; task<=2; task++){
                    if ( task != last ){
                        int meritPoints = points[day][task] + dp[day-1][task];
                        dp[day][last] = Math.max( dp[day][last], meritPoints);
                    }
                }
            }
        }
        return dp[n-1][3];
    }

}
