package company.microsoft;

import java.util.Arrays;

public class P72EditDistance {
    public int minDistance(String word1, String word2) {
        return f(word1, word2, word1.length()-1, word2.length()-1);
    }

    private int f(String word1, String word2, int i, int j) {
        if ( i < 0) return j+1; // insertions
        if ( j < 0) return i+1; // deletions
        if ( word1.charAt(i) == word2.charAt(j)) return f(word1, word2, i-1, j-1);
        int insert = f(word1, word2, i-1, j);
        int delete = f(word1, word2, i, j-1);
        int replace = f(word1, word2, i-1, j-1);
        return Math.min(Math.min(insert, delete), replace);
    }

    public int minDistanceMemoized(String word1, String word2) {
        int[][] memo = new int[word1.length()][word2.length()];
        for ( int i=0; i< memo.length; i++){
            Arrays.fill(memo[i], -1);
        }
        return f(word1, word2, word1.length()-1, word2.length()-1, memo);
    }

    private int f(String word1, String word2, int i, int j, int[][] memo) {
        if ( i < 0) return j+1; // insertions
        if ( j < 0) return i+1; // deletions
        if ( memo[i][j] != -1) return memo[i][j];
        if ( word1.charAt(i) == word2.charAt(j)) return memo[i][j] = f(word1, word2, i-1, j-1, memo);
        int insert = 1+ f(word1, word2, i-1, j, memo);
        int delete = 1+ f(word1, word2, i, j-1, memo);
        int replace = 1+ f(word1, word2, i-1, j-1, memo);
        return memo[i][j] = Math.min(Math.min(insert, delete), replace);
    }

    public int minDistanceTabular(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n+1][m+1];

        for ( int i=0; i<=n; i++){
            dp[i][0] = i;
        }
        for ( int j=0; j<=m; j++){
            dp[0][j] = j;
        }

        for ( int i=1; i<=n; i++){
            for ( int j=1; j<=m ; j++){
                if ( word1.charAt(i-1) == word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else {
                    int insert = 1+ dp[i][j-1];
                    int delete = 1+ dp[i-1][j];
                    int replace = 1 + dp[i-1][j-1];
                    dp[i][j] = Math.min(Math.min(insert, delete), replace);
                }
            }
        }
        return dp[n][m];
    }
}
