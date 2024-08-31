package takeUForward.dynamicProgramming;

public class DP30MinimumInsertionsDeletionsToConvertStringAToStringB {
    public static int canYouMake(String s1, String s2) {
        // what should be intact and what should we not touch ?
        // common characters in both strings need not be touched
        // the longest common subsequences
        // deletions = len(s1)-lcs
        // insertions = len(s2)-lcs
        // del + ins = n + m - 2 * lcs
        return s1.length()+s2.length()-2*lcs(s1, s2);
    }

    private static int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int [][] dp = new int[n+1][m+1];
        for ( int i=1; i<=n; i++){
            for ( int j=1; j<=m ; j++){
                if (s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        return dp[n][m];
    }
}
