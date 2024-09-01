package takeUForward.dynamicProgramming;

import java.util.Arrays;

public class DP34WildcardMatchingRecursiveTo1DArrayOptimisation {
    public static boolean wildcardMatching(String pattern, String text) {
       return wildcardMatching(pattern, text, pattern.length()-1, text.length()-1);
    }

    private static boolean wildcardMatching(String pattern, String text, int i, int j) {
        if ( i < 0 && j < 0) return true;
        if ( i < 0 && j >=0 ) return false;
        if ( j < 0 && i>=0) {
            for ( int index = 0; i<=i; i++){
                if ( pattern.charAt(index) != '*') return false;
            }
            return true;
        }
        if ( pattern.charAt(i) == text.charAt(j) || pattern.charAt(i) == '?') {
            return wildcardMatching(pattern, text, i-1, j-1);
        } else if ( pattern.charAt(i) == '*'){
            return wildcardMatching(pattern, text, i-1, j) || wildcardMatching(pattern, text, i, j-1);
        }
        return false;
    }

    public static boolean wildcardMatchingMemo(String pattern, String text) {
        int n = pattern.length(), m = text.length();
        Boolean [][] memo = new Boolean[n][m];
        return wildcardMatchingMemo(pattern, text, pattern.length()-1, text.length()-1, memo);
    }

    private static boolean wildcardMatchingMemo(String pattern, String text, int i, int j, Boolean[][] memo) {
        if ( i < 0 && j < 0) return true; // both strings are empty , pattern matches
        if ( i < 0 && j >=0 ) return false; // pattern empty, no match
        if ( j < 0 && i>=0) { // pattern exists, string is empty - matches only if all chars in pattern is *
            for ( int index = 0; index<=i; index++){
                if ( pattern.charAt(index) != '*') return  false;
            }
            return true;
        }
        if ( memo[i][j] != null) return memo[i][j];
        if ( pattern.charAt(i) == text.charAt(j) || pattern.charAt(i) == '?') {
            return memo[i][j] =  wildcardMatchingMemo(pattern, text, i-1, j-1, memo);
        } else if ( pattern.charAt(i) == '*'){
            return memo[i][j] =  wildcardMatchingMemo(pattern, text, i-1, j, memo) || wildcardMatchingMemo(pattern, text, i, j-1, memo);
        }
        return memo[i][j] =  false;
    }

    public static boolean wildcardMatchingMemoIndexShift(String pattern, String text) {
        int n = pattern.length(), m = text.length();
        Boolean [][] memo = new Boolean[n+1][m+1];
        return wildcardMatchingMemoIndexShift(pattern, text, pattern.length(), text.length(), memo);
    }

    private static boolean wildcardMatchingMemoIndexShift(String pattern, String text, int i, int j, Boolean[][] memo) {
        if ( i == 0 && j == 0) return true; // both strings are empty , pattern matches
        if ( i == 0 && j > 0 ) return false; // pattern empty, no match
        if ( j == 0 && i> 0) { // pattern exists, string is empty - matches only if all chars in pattern is *
            for ( int index = 1; index<=i; index++){
                if ( pattern.charAt(index-1) != '*') return  false;
            }
            return true;
        }
        if ( memo[i][j] != null) return memo[i][j];
        if ( pattern.charAt(i-1) == text.charAt(j-1) || pattern.charAt(i-1) == '?') {
            return memo[i][j] =  wildcardMatchingMemoIndexShift(pattern, text, i-1, j-1, memo);
        } else if ( pattern.charAt(i-1) == '*'){
            return memo[i][j] =  wildcardMatchingMemoIndexShift(pattern, text, i-1, j, memo) || wildcardMatchingMemoIndexShift(pattern, text, i, j-1, memo);
        }
        return memo[i][j] =  false;
    }

    public static boolean wildcardMatchingMemoTabulation(String pattern, String text) {
        int n = pattern.length(), m = text.length();
        Boolean [][] dp = new Boolean[n+1][m+1];
        dp[0][0] = true;
        for ( int j=1; j<=m ; j++) dp[0][j] = false;
        for ( int i=1; i<=n; i++) {
            boolean flag = true;
            for (int index=1; index <=i; index++){
               if ( pattern.charAt(index-1) != '*' ) {
                   flag = false;
                   break;
               }
            }
            dp[i][0] = flag;
        }

        for (int i=1; i<=n; i++){
            for ( int j=1; j<=m ; j++){
                if ( pattern.charAt(i-1) == text.charAt(j-1) || pattern.charAt(i-1) == '?') {
                     dp[i][j] =  dp[i-1][j-1];
                } else if ( pattern.charAt(i-1) == '*'){
                     dp[i][j] =  dp[i-1][j] || dp[i][j-1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }


}
