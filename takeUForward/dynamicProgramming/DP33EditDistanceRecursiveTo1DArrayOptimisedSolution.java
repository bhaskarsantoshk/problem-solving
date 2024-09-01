package takeUForward.dynamicProgramming;

import java.util.Arrays;

public class DP33EditDistanceRecursiveTo1DArrayOptimisedSolution {
    public static int editDistance(String str1, String str2) {
        return editDistance(str1, str2, str1.length()-1, str2.length()-1);
    }

    private static int editDistance(String str1, String str2, int i, int j) {
        if ( i < 0) return j+1; // insertions
        if ( j < 0) return i+1; // deletions

        if (str1.charAt(i) == str2.charAt(j)){
            return editDistance(str1, str2, i-1, j-1);
        } else {
            int insert = 1 + editDistance(str1, str2, i, j-1);
            int delete = 1 + editDistance(str1, str2, i-1, j);
            int replace = 1 + editDistance(str1, str2, i-1, j-1);
            return Math.min(Math.min(insert, delete), replace);
        }
    }

    public static int editDistanceMemo(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        int [][] memo = new int[n][m];
        for ( int[] row: memo) Arrays.fill(row, -1);
        return editDistanceMemo(str1, str2, str1.length()-1, str2.length()-1, memo);
    }

    private static int editDistanceMemo(String str1, String str2, int i, int j, int[][] memo) {
        if ( i < 0) return j+1; // insertions
        if ( j < 0) return i+1; // deletions
        if ( memo[i][j] != -1) return memo[i][j];
        if (str1.charAt(i) == str2.charAt(j)){
            return memo[i][j] = editDistanceMemo(str1, str2, i-1, j-1, memo);
        } else {
            int insert = 1 + editDistanceMemo(str1, str2, i, j-1, memo);
            int delete = 1 + editDistanceMemo(str1, str2, i-1, j, memo);
            int replace = 1 + editDistanceMemo(str1, str2, i-1, j-1, memo);
            return memo[i][j] = Math.min(Math.min(insert, delete), replace);
        }
    }

    public static int editDistanceTabular(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        int [][] dp = new int[n+1][m+1];
        for ( int i=0; i<=n; i++){
            dp[i][0] = i;
        }
        for ( int j=0; j<=m; j++){
            dp[0][j] = j;
        }
        for ( int i=1; i<=n; i++){
            for ( int j=1; j<=m; j++){
                if (str1.charAt(i-1) == str2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else {
                    int insert = 1 + dp[i][j-1];
                    int delete = 1 + dp[i-1][j];
                    int replace = 1 + dp[i-1][j-1];
                    dp[i][j] = Math.min(insert, delete);
                    dp[i][j] = Math.min(dp[i][j], replace);
                }
            }
        }
        return dp[n][m];
    }

    public static int editDistanceTabularSpaceOptimized(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        int [] prev = new int[m+1];
        int [] cur = new int[m+1];
        for ( int j=0; j<=m; j++){
            prev[j] = j;
        }
        for ( int i=1; i<=n; i++){
            cur[0] = i;
            for ( int j=1; j<=m; j++){
                if (str1.charAt(i-1) == str2.charAt(j-1)) cur[j] = prev[j-1];
                else {
                    int insert = 1 + cur[j-1];
                    int delete = 1 + prev[j];
                    int replace = 1 + prev[j-1];
                    cur[j] = Math.min(insert, delete);
                    cur[j] = Math.min(cur[j], replace);
                }
            }
            prev = (int[])cur.clone();
        }
        return prev[m];
    }
}
