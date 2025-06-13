package takeUForward.dynamicProgramming.revision;

import java.util.Arrays;

public class P38LongestCommonSubsequence {
    public int lcs( String str1, String str2) {

        return f(str1.length()-1, str2.length()-1, str1, str2);
    }

    private int f(int index1, int index2, String str1, String str2) {
        if ( index1 < 0 || index2 < 0) return 0;
        if ( str1.charAt(index1) == str2.charAt(index2)) return 1+ f(index1-1, index2-1, str1, str2);
        return Math.max(f(index1-1, index2, str1, str2), f(index1, index2-1, str1, str2));
    }

    public int lcsMemoized( String str1, String str2) {
        int [][] dp = new int[str1.length()][str2.length()];
        for ( int i=0; i<str1.length(); i++) Arrays.fill(dp[i], -1);
        return f(str1.length()-1, str2.length()-1, str1, str2, dp);
    }

    private int f(int index1, int index2, String str1, String str2, int[][] dp) {
        if ( index1 < 0 || index2 < 0) return 0;
        if ( dp[index1][index2] != -1) return dp[index1][index2];
        if ( str1.charAt(index1) == str2.charAt(index2)) return 1+ f(index1-1, index2-1, str1, str2, dp);
        return dp[index1][index2] = Math.max(f(index1-1, index2, str1, str2, dp), f(index1, index2-1, str1, str2, dp));
    }


}
