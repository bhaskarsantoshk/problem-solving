package takeUForward.dynamicProgramming;

import java.util.Arrays;

public class DP53PalindromePartitioningIIFrontPartition {
    public static int palindromePartitioning(String str) {
        return f(0, str, str.length())-1;
    }

    private static int f(int i, String str, int n) {
        if ( i == n) return 0;
        int minCost = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();
        for ( int j=i; j<n; j++){
            sb.append(str.charAt(j));
            if ( isPalindrome(sb)){
                int cost = 1+ f(j+1, str, n);
                minCost = Math.min(minCost, cost);
            }
        }
        return minCost;
    }

    private static boolean isPalindrome(StringBuilder sb) {
        int i=0, j= sb.length()-1;
        while ( i < j){
            if ( sb.charAt(i++) != sb.charAt(j--)) return false;
        }
        return true;
    }

    public static int palindromePartitioningMemo(String str) {
        int[] memo = new int[str.length()];
        Arrays.fill(memo, -1);
        return fMemo(0, str, str.length(), memo)-1;
    }

    private static int fMemo(int i, String str, int n, int[] memo) {
        if ( i == n) return 0;
        if ( memo[i] != -1) return memo[i];
        int minCost = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();
        for ( int j=i; j<n; j++){
            sb.append(str.charAt(j));
            if ( isPalindrome(sb)){
                int cost = 1+ fMemo(j+1, str, n, memo);
                minCost = Math.min(minCost, cost);
            }
        }
        return memo[i]=minCost;
    }
}
