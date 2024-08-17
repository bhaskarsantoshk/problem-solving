package company.google;

import java.util.Arrays;

public class P937MaximumNumberOfPointsWithCost {
    public long maxPoints(int[][] points) {
        int n = points.length, m = points[0].length;
        int max = 0;
        for ( int j=0; j<m; j++){
            int score = f( n-1, j, points, n, m);
            max = Math.max(max, score);
        }
        return max;
    }

    private int f(int r, int c, int[][] points, int n, int m) {
        if ( r == 0){
            return points[r][c];
        }
        int max = 0;
        for ( int col=0; col<m; col++){
            int curPoints = points[r][c] - Math.abs(c-col) + f(r-1, col, points, n, m);
            max = Math.max(curPoints, max);
        }
        return max;
    }

    public long maxPointsMemoized(int[][] points) {
        int n = points.length, m = points[0].length;
        Long [][]memo = new Long[n][m];
        long max = 0;
        for ( int j=0; j<m; j++){
            long score = maxPointsMemoized( n-1, j, points, n, m, memo);
            max = Math.max(max, score);
        }
        return max;
    }

    private long maxPointsMemoized(int r, int c, int[][] points, int n, int m, Long[][] memo) {
        if ( r == 0){
            return points[r][c];
        }
        if ( memo[r][c] != null) return memo[r][c];
        long max = 0;
        for ( int col=0; col<m; col++){
            long curPoints = points[r][c] - Math.abs(c-col) + maxPointsMemoized(r-1, col, points, n, m, memo);
            max = Math.max(curPoints, max);
        }
        return memo[r][c] = max;
    }
}
