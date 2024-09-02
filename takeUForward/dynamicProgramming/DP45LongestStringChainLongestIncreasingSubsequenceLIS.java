package takeUForward.dynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

public class DP45LongestStringChainLongestIncreasingSubsequenceLIS {
    public static int longestStrChain(String[] arr) {
        int n = arr.length;
        int []dp = new int[n];
        int [] hash = new int[n];
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        Arrays.fill(dp, 1);
        int max = 1;
        int lastIndex = 0;
        for ( int i=1; i<n; i++){
            hash[i] = i;
            for ( int prev = 0; prev<i; prev++){
                if ( checkForPossibility(arr[i], arr[prev]) && dp[prev]+1 > dp[i]){
                    dp[i] = dp[prev]+1;
                    hash[i] = prev; // if we need to print chain
                }
            }
            if ( dp[i] > max){
                max = dp[i];
                lastIndex = i; // if we need to print chain
            }
        }
        return max;
    }

    private static boolean checkForPossibility(String cur, String prev) {
        if (cur.length() != prev.length() + 1) return false;
        int i=0, j=0;
        int n = cur.length(), m = prev.length();
        while ( i < n ){
            if ( j < m && cur.charAt(i) == prev.charAt(j)){
                i++;
                j++;
            } else {
                i++;
            }
        }
        return i==n && j ==m;
    }
}
