package LeetCode;

import java.util.Arrays;

public class P1143LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int [][] memo = new int[text1.length()+1][text2.length()+1];
        for ( int i=0; i<memo.length; i++){
            Arrays.fill(memo[i], -1);
        }
        return lcs( text1.toCharArray(), text2.toCharArray(), text1.length(), text2.length(), memo);
    }

    private int lcs(char[] a, char[] b, int m, int n, int[][] memo){
        if ( m == 0 || n == 0) return 0;
        if ( memo[m][n] != -1 ){
            return memo[m][n];
        }
        if ( a[m-1] == b[n-1] ){
            memo[m][n] =  1 + lcs (a, b, m-1, n-1, memo);
        }
        else{
            memo[m][n] = Math.max ( lcs(a,b, m,n-1, memo), lcs(a,b, m-1, n, memo));
        }
        return memo[m][n];
    }
}
