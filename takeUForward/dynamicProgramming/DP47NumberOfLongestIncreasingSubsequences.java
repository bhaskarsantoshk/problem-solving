package takeUForward.dynamicProgramming;

import java.util.Arrays;

public class DP47NumberOfLongestIncreasingSubsequences {
    public static int findNumberOfLIS(int []arr) {
        int n = arr.length;
        int []dp = new int[n];
        int []count = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int max = 0;
        for ( int i=1; i<n; i++){
            for ( int prev =0; prev<i; prev++){
                if ( arr[i] > arr[prev] && dp[prev] + 1 > dp[i]){
                    dp[i] = dp[prev]+1;
                    count[i] = count[prev];
                } else if ( arr[i] > arr[prev] && dp[prev]+1 == dp[i] ){
                    count[i] += count[prev];
                }
            }
            max = Math.max(dp[i], max);
        }

        for ( int i=0; i<n; i++){
            if (dp[i] == max) return count[i];
        }
        return 0;
    }
}
