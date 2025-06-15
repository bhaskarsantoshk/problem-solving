package takeUForward.dynamicProgramming.revision;

import java.util.Arrays;

public class P45EditDistance {
    public int editDistance(String start, String target) {
        return f(start, target, start.length()-1, target.length()-1);
    }

    private int f(String start, String target, int i, int j) {
        if ( i < 0) return j+1; // start exhausted
        if ( j < 0) return i+1; // end exhausted
        if ( start.charAt(i) == target.charAt(j)) return f(start, target, i-1, j-1);
        return 1+  Math.min( f(start, target, i-1, j), // delete
                Math.min(f(start, target, i, j-1), f(start, target, i-1, j-1))); // insert , replace

    }

    public int editDistanceMemoized(String start, String target) {
        int m = start.length(), n = target.length();
        int [][] dp = new int[m][n];
        for ( int i=0; i<m; i++) Arrays.fill(dp[i], -1);
        return f(start, target, start.length()-1, target.length()-1, dp);
    }

    private int f(String start, String target, int i, int j, int[][] dp) {
        if ( i < 0) return j+1; // start exhausted
        if ( j < 0) return i+1; // end exhausted
        if ( dp[i][j] != -1) return dp[i][j];
        if ( start.charAt(i) == target.charAt(j)) return dp[i][j] = f(start, target, i-1, j-1);
        return dp[i][j] = 1+  Math.min( f(start, target, i-1, j), // delete
                Math.min(f(start, target, i, j-1), f(start, target, i-1, j-1))); // insert , replace

    }

    public int editDistanceTabular(String start, String target) {
        int m = start.length(), n = target.length();
        int [][] dp = new int[m+1][n+1];
        for ( int i=0; i<=m; i++) dp[i][0] = i;
        for ( int j=0; j<=n; j++) dp[0][j] = j;

        for ( int i=1; i<=m; i++){
            for (int j=1; j<=n; j++){
                if ( start.charAt(i-1) == target.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = 1+  Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
            }
        }
        return dp[m][n];
    }


}
