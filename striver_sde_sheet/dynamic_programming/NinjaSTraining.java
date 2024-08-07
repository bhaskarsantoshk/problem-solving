package striver_sde_sheet.dynamic_programming;

import java.util.Arrays;

public class NinjaSTraining {
    public static int ninjaTraining(int n, int points[][]) {
        return f(n-1, 3, points);
    }

    private static int f(int day, int last, int[][] points){
        if ( day == 0) {
            int max =0;
            for ( int task=0; task<3; task++){
                if ( task != last ) max = Math.max(max, points[0][task]);
            }
            return max;
        }
        int max = 0;
        for ( int task=0; task < 3; task++){
            if ( task != last ) {
                int point = points[day][task] + f(day-1, task, points);
                max = Math.max( point, max);
            }
        }
        return max;
    }

    public static int ninjaTrainingMemoized(int n, int points[][]) {
        int [][] memo = new int[n][4];
        for ( int[] row: memo){
            Arrays.fill(row, -1);
        }
        return ninjaTrainingMemoized(n-1, 3, points, memo);
    }

    private static int ninjaTrainingMemoized(int day, int last, int[][] points, int[][] memo){
        if ( day == 0) {
            int max =0;
            for ( int task=0; task<3; task++){
                if ( task != last ) max = Math.max(max, points[0][task]);
            }
            return max;
        }
        if ( memo[day][last] != -1 ) return memo[day][last];
        int max = 0;
        for ( int task=0; task < 3; task++){
            if ( task != last ) {
                int point = points[day][task] + ninjaTrainingMemoized(day-1, task, points, memo);
                max = Math.max( point, max);
            }
        }
        return memo[day][last] = max;
    }

    public static int ninjaTrainingTabular(int n, int points[][]) {
        int [][] dp = new int[n][4];
        dp[0][0] = Math.max(points[0][1], points[0][2]); //  assuming you took task0 on prev day
        dp[0][1] = Math.max(points[0][0], points[0][2]); // assuming you took task1 on prev day
        dp[0][2] = Math.max(points[0][0], points[0][1]); // assuming you took task2 on prev day
        dp[0][3] = Math.max( points[0][0], Math.max( points[0][1], points[0][2]));

        for ( int day=1; day<n; day++){
            for ( int last=0; last<=3; last++){
                dp[day][last] = 0;
                int max = 0;
                for ( int task=0; task<3; task++){
                    if ( task != last) {
                        int point = points[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max( dp[day][last], point);
                    }
                }
            }
        }
        return dp[n-1][3];
    }

    public static int ninjaTrainingSpaceOtimized(int n, int points[][]) {
        int [] prev = new int[4];
        prev[0] = Math.max(points[0][1], points[0][2]); //  assuming you took task0 on prev day
        prev[1] = Math.max(points[0][0], points[0][2]); // assuming you took task1 on prev day
        prev[2] = Math.max(points[0][0], points[0][1]); // assuming you took task2 on prev day
        prev[3] = Math.max( points[0][0], Math.max( points[0][1], points[0][2]));

        for ( int day=1; day<n; day++){
            int currentDay[] = new int[4];
            for ( int last=0; last<=3; last++){
                currentDay[last] = 0;
                for ( int task=0; task<3; task++){
                    if ( task != last) {
                        int point = points[day][task] + prev[task];
                        currentDay[last] = Math.max( currentDay[last], point);
                    }
                }
            }
            prev = currentDay;
        }
        return prev[3];
    }
}
