package takeUForward.recursion;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static int lcs(String s, String t) {
        int n = s.length(), m = t.length();
        return lcs(s, t, n-1, m-1);
    }

    private static int lcs(String s, String t, int index1, int index2) {

        if ( index1 < 0 || index2 < 0) return 0;
        if ( s.charAt(index1) == t.charAt(index2)) return 1+ lcs(s,t, index1-1, index2-1);
        return Math.max( lcs(s,t, index1-1, index2), lcs(s,t, index1, index2-1));
    }

    public static int lcsMemo(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] memo = new int[n][m];
        for ( int i=0; i<n; i++) Arrays.fill(memo[i], -1);
        return lcsMemo(s, t, n-1, m-1, memo);
    }

    private static int lcsMemo(String s, String t, int index1, int index2, int[][] memo) {

        if ( index1 < 0 || index2 < 0) return 0;
        if ( s.charAt(index1) == t.charAt(index2)) return memo[index1][index2] =  1+ lcsMemo(s,t, index1-1, index2-1, memo);
        return  memo[index1][index2] = Math.max( lcsMemo(s,t, index1-1, index2, memo), lcsMemo(s,t, index1, index2-1, memo));
    }

    public static int lcsTabular(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n+1][m+1];
        for ( int i=0; i<n; i++){
            dp[i][0] = 0;
        }
        for ( int j=0; j<m; j++){
            dp[0][j] = 0;
        }

        for ( int i=1; i<=n; i++){
            for ( int j=1; j<=m ;j++){
                if ( s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

    public static int lcsTabularSpaceOptimized(String s, String t) {
        int n = s.length(), m = t.length();
        int[] prev = new int[m+1];
        int[] cur = new int[m+1];

        for ( int j=0; j<=m; j++){
            prev[j] = 0;
        }

        for ( int i=1; i<=n; i++){
            for ( int j=1; j<=m ;j++){
                if ( s.charAt(i-1) == t.charAt(j-1)){
                    cur[j] = 1 + prev[j-1];
                } else {
                    cur[j] = Math.max(prev[j], cur[j-1]);
                }
            }
            prev = (int[]) (cur.clone());
        }
        return prev[m];
    }
}
