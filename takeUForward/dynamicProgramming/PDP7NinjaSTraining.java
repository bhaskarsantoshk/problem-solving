package takeUForward.dynamicProgramming;

import java.util.Arrays;

public class PDP7NinjaSTraining {
    public static int ninjaTraining(int n, int points[][]) {
        return maximumMeritPoints(n-1, points, 3);
    }

    private static int maximumMeritPoints(int day, int[][] points, int last) {
        int max = 0;
        if ( day == 0){
            for (int i =0; i<=2; i++){
                if ( i!= last) {
                    max = Math.max(max, points[0][i]);
                }
            }
            return max;
        }

        max = 0;
        for ( int i=0; i<=2; i++){
            if ( i != last) {
                int meritPoints = maximumMeritPoints(day-1, points, i) + points[day][i];
                max = Math.max(meritPoints, max);
            }
        }
        return max;
    }

    public static int ninjaTrainingMemo(int n, int points[][]) {
        int [][] memo = new int[n][4];
        for ( int i=0; i<memo.length; i++){
            Arrays.fill(memo[i], -1);
        }
        return maximumMeritPointsMemo(n-1, points, 3, memo);
    }

    private static int maximumMeritPointsMemo(int day, int[][] points, int last, int[][] memo) {
        int max = 0;
        if ( day == 0){
            for (int i =0; i<=2; i++){
                if ( i!= last) {
                    max = Math.max(max, points[0][i]);
                }
            }
            return memo[day][last] = max;
        }
        if ( memo[day][last] != -1) return memo[day][last];

        max = 0;
        for ( int i=0; i<=2; i++){
            if ( i != last) {
                int meritPoints = maximumMeritPointsMemo(day-1, points, i, memo) + points[day][i];
                max = Math.max(meritPoints, max);
            }
        }
        return memo[day][last] = max;
    }

    public static int ninjaTrainingTabular(int n, int points[][]) {
        int [][] dp = new int[n][4];
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max( points[0][0], Math.max( points[0][1], points[0][2]));

        for ( int day = 1; day <n ; day++){
            for ( int last = 0; last <=3; last++){
                dp[day][last] = 0;
                for ( int task=0; task<=2; task++){
                    if ( task != last) {
                        int meritPoints = dp[day-1][task] + points[day][task];
                        dp[day][last] = Math.max(meritPoints, dp[day][last]);
                    }
                }
            }
        }
        return dp[n-1][3];

    }
}
