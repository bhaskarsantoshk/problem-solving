package takeUForward.dynamicProgramming.revision;

public class P42MinimumInsertionsOrDeletionsToConvertStringAToB {
    public int minOperations(String str1, String str2) {
        return str1.length()+str2.length()-2* lcs(str1, str2);
    }

    private int lcs(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int [][] dp = new int[m+1][n+1];
        for ( int i=1; i<=m; i++){
            for ( int j=1; j<=n; j++){
                if ( str1.charAt(i-1) == str2.charAt(j-1)) dp[i][j] = 1+ dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m][n];
    }
}
