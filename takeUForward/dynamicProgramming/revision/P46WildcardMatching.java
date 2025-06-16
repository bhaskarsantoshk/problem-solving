package takeUForward.dynamicProgramming.revision;

import java.util.Arrays;

public class P46WildcardMatching {
    public boolean wildCard(String str, String pat) {
        int m = str.length(), n = pat.length();
        return f(str, pat, m-1, n-1);
    }

    private boolean f(String str, String pat, int i, int j) {
        if ( i < 0 && j < 0) return true;
        if ( i >= 0 && j < 0 ) return false;
        if ( i < 0 && j>=0){
            for ( int index=0; index<=j; index++) {
                if ( pat.charAt(index) != '*') return false;
            }
            return true;
        }
        if ( str.charAt(i) == pat.charAt(j) || pat.charAt(j)=='?') return f(str, pat, i-1, j-1);
        if (pat.charAt(j)=='*'){
            return f(str, pat, i, j-1) || f(str, pat, i-1, j);
        }
        return false;
    }

    public boolean wildCardMemoized(String str, String pat) {
        int m = str.length(), n = pat.length();
        Boolean [][] dp = new Boolean[m][n];
        return f(str, pat, m-1, n-1, dp);
    }

    private boolean f(String str, String pat, int i, int j, Boolean[][] dp) {
        if ( i < 0 && j < 0) return true;
        if ( i >= 0 && j < 0 ) return false;
        if ( i < 0 && j>=0){
            for ( int index=0; index<=j; index++) {
                if ( pat.charAt(index) != '*') return false;
            }
            return true;
        }
        if ( dp[i][j] != null) return dp[i][j];
        if ( str.charAt(i) == pat.charAt(j) || pat.charAt(j)=='?') return dp[i][j] = f(str, pat, i-1, j-1, dp);
        if (pat.charAt(j)=='*'){
            return dp[i][j] = f(str, pat, i, j-1, dp) || f(str, pat, i-1, j, dp);
        }
        return dp[i][j] = false;
    }

    public boolean wildCardMemoizedOneBasedIndex(String str, String pat) {
        int m = str.length(), n = pat.length();
        Boolean [][] dp = new Boolean[m][n];
        return f(str, pat, m, n, dp);
    }

    private boolean fOneBasedIndex(String str, String pat, int i, int j, Boolean[][] dp) {
        if ( i == 0 && j == 0) return true;
        if ( i > 0 && j == 0 ) return false;
        if ( i == 0 && j>0){
            for ( int index=1; index<=j; index++) {
                if ( pat.charAt(index-1) != '*') return false;
            }
            return true;
        }
        if ( dp[i][j] != null) return dp[i][j];
        if ( str.charAt(i-1) == pat.charAt(j-1) || pat.charAt(j-1)=='?') return dp[i][j] = f(str, pat, i-1, j-1, dp);
        if (pat.charAt(j-1)=='*'){
            return dp[i][j] = f(str, pat, i, j-1, dp) || f(str, pat, i-1, j, dp);
        }
        return dp[i][j] = false;
    }

    public boolean wildCardTabular(String str, String pat) {
        int m = str.length(), n = pat.length();
        boolean [][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for ( int i=1; i<=m; i++) dp[i][0] = false;
        for ( int j=1; j<=n; j++){
            boolean flag = true;
            for ( int index=1; index<=j; index++){
                if ( pat.charAt(index-1) != '*') {
                    flag = false;
                    break;
                }
            }
            dp[0][j] = flag;
        }

        for ( int i=1; i<=m; i++){
            for ( int j=1; j<=n; j++){
                if ( str.charAt(i-1) == pat.charAt(j-1) || pat.charAt(j-1)=='?') dp[i][j] = dp[i-1][j-1];
                else if (pat.charAt(j-1)=='*'){
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }
                else dp[i][j] = false;
            }
        }
        return dp[m][n];
    }
}
