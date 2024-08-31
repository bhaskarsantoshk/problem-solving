package takeUForward.dynamicProgramming;

public class DP31ShortestCommonSupersequenceDPOnStrings {
    public static String shortestSupersequence(String a, String b) {
        // super sequence contains all uncommon characters in both strings + common chars
        // len = len(s1)+ len(s2)- lcs(s1,s2)
        // make the DP table of lcs
        // frame the string based on the dp table
        // count lcs chars once
        int n = a.length();
        int m = b.length();
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        char[] res = new char[n + m - dp[n][m]];
        int index = res.length-1;
        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                res[index--] = a.charAt(i - 1);
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                res[index--] = a.charAt(i-1);
                i--;
            } else{
                res[index--] = b.charAt(j-1);
                j--;
            }
        }

        while ( i>0) {
            res[index--] =a.charAt(i--);
        }
        while ( j>0) {
            res[index--] =b.charAt(j--);
        }
        return new String(res);
    }
}
