package takeUForward.dynamicProgramming.revision;

import java.util.Arrays;

public class P40LongestPalindromicSubsequence {
    public int longestPalinSubseq(String s) {
        String t = reverse(s);
        return longestCommonSubSequence(s, t);
    }

    private int longestCommonSubSequence(String s1, String s2) {
        return f(s1, s2, s1.length()-1, s2.length()-1);
    }

    private int f(String s1, String s2, int index1, int index2) {
        if ( index1 < 0 || index2 < 0) return 0;
        if ( s1.charAt(index1) == s2.charAt(index2)) return 1+ f(s1, s2, index1-1, index2-1);
        return Math.max(f(s1, s2, index1-1, index2), f(s1, s2, index1, index2-1));
    }

    private int longestCommonSubSequenceMemoized(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int [][] dp = new int[m][n];
        for ( int i=0; i<m; i++) Arrays.fill(dp[i], -1);
        return f(s1, s2, m-1, n-1, dp);
    }

    private int f(String s1, String s2, int index1, int index2, int[][] dp) {
        if ( index1 < 0 || index2 < 0) return 0;
        if ( dp[index1][index2] != -1) return dp[index1][index2];
        if ( s1.charAt(index1) == s2.charAt(index2)) return 1+ f(s1, s2, index1-1, index2-1, dp);
        return dp[index1][index2]= Math.max(f(s1, s2, index1-1, index2, dp), f(s1, s2, index1, index2-1, dp));
    }

    private int longestCommonSubSequenceTabular(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int [][] dp = new int[m+1][n+1];
        for ( int i=1; i<=m; i++){
            for ( int j=1; j<=n; j++){
                if ( s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = 1+dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m][n];
    }


    private String reverse(String s) {
        StringBuffer sb = new StringBuffer(s);
        return sb.reverse().toString();
    }
}
