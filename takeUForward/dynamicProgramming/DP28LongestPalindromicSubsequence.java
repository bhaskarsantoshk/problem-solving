package takeUForward.dynamicProgramming;

public class DP28LongestPalindromicSubsequence {
    public static int longestPalindromeSubsequence(String s) {
       String t = reverse(s);
       return lcs(s, t);
    }

    private static int lcs(String s, String t) {
        return lcs(s, t, s.length()-1, t.length()-1);
    }

    private static int lcs(String s, String t, int index1, int index2) {
        // Base case
        if ( index1 < 0 || index2 < 0) return 0;

        // match
        if ( s.charAt(index1) == t.charAt(index2)){
            return 1+ lcs(s, t, index1-1, index2-1);
        } // no match
        else {
            return Math.max( lcs(s, t, index1-1, index2), lcs(s, t, index1, index2-1);
        }
    }

    private static int lcsTabular(String s, String t) {
        int n = s.length(), m = t.length();
        int [][] dp = new int[n+1][m+1];
        for ( int i=1; i<=n ; i++){
            for ( int j=1; j<=m ; j++){
                if ( s.charAt(i-1) == t.charAt(j-1)) dp[i][j] = 1+ dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[n][m];
    }

    private static String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}
