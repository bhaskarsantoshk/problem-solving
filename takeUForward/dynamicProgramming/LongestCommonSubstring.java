package takeUForward.dynamicProgramming;

public class LongestCommonSubstring {
    public static int lcs(String str1, String str2){
        int n = str1.length(), m = str2.length();
        int[][] dp = new int[n+1][m+1];
        for ( int i=0; i<=n; i++){
            dp[i][0] = 0;
        }
        for ( int j=0; j<=m; j++){
            dp[0][j] = 0;
        }
        int max = 0;
        for ( int i=1; i<=n; i++){
            for ( int j=1; j<=m ; j++){
                if (str1.charAt(i) == str2.charAt(j)){
                    dp[i][j] = dp[i-1][j-1]+1;
                    max = Math.max( max, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return max;
    }
}
