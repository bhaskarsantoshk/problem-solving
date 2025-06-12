package takeUForward.dynamicProgramming.revision;

import java.util.Arrays;

public class P37NumberOfLongestIncreasingSubsequences {
    public int numberOfLIS(int[] nums) {
        int n = nums.length;
        int []dp = new int[n];
        Arrays.fill(dp, 1);
        int[] counts = new int[n];
        Arrays.fill(counts, 1);
        int max = 1;

        for ( int i=0; i<n; i++){
            for ( int j=0; j<=i-1; j++){
                if ( nums[i] > nums[j] && 1+dp[j] > dp[i]){
                    dp[i] = 1+dp[j];
                    counts[i] = counts[j];
                } else if ( nums[i] > nums[j] && 1+dp[j] == dp[i] ){
                    counts[i] += counts[j];
                }
            }
            max = Math.max(max, dp[i]);
        }

        int res = 0;

        for ( int i=0; i<n; i++){
            if ( dp[i] == max) res += counts[i];
        }
        return res;
    }
}
