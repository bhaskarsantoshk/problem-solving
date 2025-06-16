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
}
