package takeUForward.dynamicProgramming.revision;

import java.util.Arrays;

public class P50PalindromePartitioningII {
    int minCut(String s) {
        int n = s.length();
       return f(s, 0, n)-1;
    }

    private int f(String s, int i, int n) {
        if ( i == s.length()) return 0;
        int min = (int)1e9;
        for ( int j=i; j<n; j++){
            if ( isPalindrome(s, i, j)){
                int cost = 1+ f(s, j+1, n);
                min = Math.min(min, cost);
            }
        }
        return min;
    }

    int minCutMemoized(String s) {
        int n = s.length();
        int []dp = new int[n+1];
        Arrays.fill(dp, -1);
        return f(s, 0, n, dp)-1;
    }

    private int f(String s, int i, int n, int[] dp) {
        if ( i == s.length()) return 0;
        if ( dp[i] != -1) return dp[i];
        int min = (int)1e9;
        for ( int j=i; j<n; j++){
            if ( isPalindrome(s, i, j)){
                int cost = 1+ f(s, j+1, n, dp);
                min = Math.min(min, cost);
            }
        }
        return dp[i] = min;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j){
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    int minCutTabular(String s) {
        int n = s.length();
        int []dp = new int[n+1];
        for ( int i=n-1; i>=0; i--){
            int min = (int)1e9;
            for ( int j=i; j<n; j++){
                if ( isPalindrome(s, i, j)){
                    int cost = 1+ dp[j+1];
                    min = Math.min(min, cost);
                }
            }
            dp[i] = min;
        }
        return dp[0]-1;
    }
}
