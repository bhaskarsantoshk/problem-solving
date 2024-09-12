package company.google;

import java.util.Arrays;

public class P132PalindromePartitioningII {
    public int minCut(String s) {
        // return minCut(s, 0, s.length()); // for the last char, at the end no additional cut is required
        int [] memo = new int[s.length()+1];
        Arrays.fill(memo, -1);
        return minCutMemo(s, 0, s.length(), memo)-1; // for the last char, at the end no additional cut is required;
    }

    private int minCut(String s, int i, int n) {
        if ( i == n) return 0;
        int minCost = Integer.MAX_VALUE;
        for ( int j=i; j<n; j++){
            if ( isPalindrome(s, i, j)){
                int cost = 1+ minCut(s, j+1, n);
                minCost = Math.min( minCost, cost);
            }
        }
        return minCost;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while ( i < j){
            if ( s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    private int minCutMemo(String s, int i, int n, int[] memo) {
        if ( i == n) return memo[n]=0;
        if ( memo[i] != -1) return memo[i];
        int minCost = Integer.MAX_VALUE;
        for ( int j=i; j<n; j++){
            if ( isPalindrome(s, i, j)){
                int cost = 1+ minCut(s, j+1, n);
                minCost = Math.min( minCost, cost);
            }
        }
        return memo[i] = minCost; // for the last char, at the end no additional cut is required
    }

    public int minCutTabular(String s) {
        int n = s.length();
        int [] dp = new int[n+1];
        for ( int i=n-1; i>=0; i--){
            int minCost = Integer.MAX_VALUE;
            for ( int j=i; j<n; j++){
                if ( isPalindrome(s, i, j)){
                    int cost = 1+ dp[j+1];
                    minCost = Math.min( minCost, cost);
                }
            }
            dp[i] = minCost;
        }
        return dp[0]-1;
    }
}
