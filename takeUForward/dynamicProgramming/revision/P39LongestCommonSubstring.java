package takeUForward.dynamicProgramming.revision;

public class P39LongestCommonSubstring {
    public int longestCommonSubstr(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int [][] dp = new int[m+1][n+1];
        int max = 0;
        for ( int i=1; i<=m ; i++){
            for ( int j=1; j<=n; j++){
                if ( str1.charAt(i-1) == str2.charAt(j-1)) dp[i][j] = 1+dp[i-1][j-1];
                else dp[i][j] = 0;
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
