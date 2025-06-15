package takeUForward.dynamicProgramming.revision;

import java.util.Arrays;

public class P44DistinctSubsequences {
    public int distinctSubsequences(String s, String t) {
        return f(s, t, s.length()-1, t.length()-1);
    }

    private int f(String s, String t, int i, int j) {
        if (j < 0) return 1;
        if ( i < 0) return 0;
        if ( s.charAt(i) == t.charAt(j)) return f(s,t, i-1, j-1) + f(s, t, i-1, j);
        return f(s, t, i-1, j);
    }

    int mod = (int)1e9+7;

    public int distinctSubsequencesMemoized(String s, String t) {
        int m = s.length(), n = t.length();
        int [][] dp = new int[m][n];
        for ( int i=0; i<m; i++) Arrays.fill(dp[i], -1);
        return f(s, t, s.length()-1, t.length()-1, dp);
    }

    private int f(String s, String t, int i, int j, int [][] dp) {
        if (j < 0) return 1;
        if ( i < 0) return 0;
        if ( dp[i][j] != -1 ) return dp[i][j];
        if ( s.charAt(i) == t.charAt(j)) return dp[i][j] = (f(s,t, i-1, j-1, dp) % mod + f(s, t, i-1, j, dp) % mod)%mod;
        return dp[i][j] = f(s, t, i-1, j, dp)%mod;
    }

    public int distinctSubsequencesTabular(String s, String t) {
        int m = s.length(), n = t.length();
        int [][] dp = new int[m+1][n+1];
        for ( int i=0; i<=m; i++ ) dp[i][0] =1;
        for (int i=1; i<=m; i++){
            for ( int j=1; j<=n; j++){
                if ( s.charAt(i-1) == t.charAt(j-1)) dp[i][j] = (dp[i-1][j-1] % mod + dp[i-1][j] % mod)%mod;
                else dp[i][j] = dp[i-1][j]%mod;
            }
        }
        return dp[m][n];
    }
}
