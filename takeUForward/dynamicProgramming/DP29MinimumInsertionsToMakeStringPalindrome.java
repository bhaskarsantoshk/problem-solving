package takeUForward.dynamicProgramming;

public class DP29MinimumInsertionsToMakeStringPalindrome {
    public static int minInsertion(String str) {
        return str.length() - lps(str);
    }

    private static int lps(String s){
        return lcs(s, new StringBuilder(s).reverse().toString());
    }

    private static int lcs(String s, String t){
        int n = s.length(), m = t.length();
        int dp[][] = new int[n+1][m+1];
        for (int i=1; i<=m ; i++){
            for ( int j=1; j<=m; j++){
                if ( s.charAt(i-1) == t.charAt(j-1)) dp[i][j] = 1+ dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[n][m];
    }
}
