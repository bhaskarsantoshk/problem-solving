package takeUForward.dynamicProgramming;

import java.util.Arrays;

public class DP32DistinctSubsequences1DArrayOptimisationTechnique {
    public static int distinctSubsequences(String str, String sub) {
        return f(str, sub, str.length()-1, sub.length()-1);
    }

    private static int f(String str, String sub, int i, int j) {
        if (i < 0) return 0;
        if ( j < 0) return 1;

        if ( str.charAt(i) == sub.charAt(j)) return f(str, sub, i-1, j-1) + f(str, sub, i-1, j);
        else return f(str, sub, i-1, j);
    }

    public static int distinctSubsequencesMemo(String str, String sub) {
        int n = str.length(), m=sub.length();
        int [][] memo= new int[n][m];
        for ( int [] row: memo) Arrays.fill(row, -1);
        return distinctSubsequencesMemo(str, sub, n-1, m-1, memo);
    }

    private static int distinctSubsequencesMemo(String str, String sub, int i, int j, int[][] memo) {
        if ( j < 0) return 1;
        if ( i < j) return 0; // extra base case not to get TLE , this means if remaining len of str is less than rem of sub
        if (i < 0) return 0;
        if ( memo[i][j] != -1) return memo[i][j];

        if ( str.charAt(i) == sub.charAt(j)) {
            return memo[i][j] = distinctSubsequencesMemo(str, sub, i-1, j-1, memo)
                    + distinctSubsequencesMemo(str, sub, i-1, j, memo);
        }
        else return memo[i][j] = distinctSubsequencesMemo(str, sub, i-1, j, memo);
    }

    public static int distinctSubsequencesTabular(String str, String sub) {
        int n = str.length(), m=sub.length();
        int MOD = (int)1e9+7;
        long [][] dp= new long[n+1][m+1];
        for (int i=0; i<n; i++) dp[i][0] = 1;
        for ( int i=1; i<=n; i++){
            for ( int j=1; j<=m; j++){
                if ( str.charAt(i-1) == sub.charAt(j-1)){
                    dp[i][j] = (dp[i-1][j-1] % MOD + dp[i-1][j] %MOD )%MOD;
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return (int)dp[n][m];
    }

    public static int distinctSubsequencesTabularSpaceOptimized(String str, String sub) {
        int n = str.length(), m=sub.length();
        int MOD = (int)1e9+7;
        long []prev = new long[m+1];
        long []cur = new long[m+1];
        for (int i=0; i<n; i++) prev[0] =cur[0]= 1;
        for ( int i=1; i<=n; i++){
            for ( int j=1; j<=m; j++){
                if ( str.charAt(i-1) == sub.charAt(j-1)){
                    cur[j] = (prev[j-1] % MOD + prev[j] %MOD )%MOD;
                } else {
                    cur[j] = prev[j];
                }
            }
            prev = (long[])cur.clone();
        }
        return (int)cur[m];
    }

    public static int distinctSubsequencesTabularSpaceOptimized2(String str, String sub) {
        int n = str.length(), m=sub.length();
        int MOD = (int)1e9+7;
        long []prev = new long[m+1];
        for (int i=0; i<n; i++) prev[0] = 1;
        for ( int i=1; i<=n; i++){
            for ( int j=m; j>=1; j--){
                if ( str.charAt(i-1) == sub.charAt(j-1)){
                    prev[j] = (prev[j-1] % MOD + prev[j] %MOD )%MOD;
                }
            }
        }
        return (int)prev[1];
    }
}
