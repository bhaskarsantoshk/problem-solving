package takeUForward.dynamicProgramming;

import java.util.Arrays;

public class DP46LongestBitonicSubsequenceLIS {
    public static int longestBitonicSequence(int[] arr, int n) {
        int [] dp1 = new int[n]; // LIS forward
        int [] dp2 = new int[n]; // LIS backward

        Arrays.fill(dp1,1);
        Arrays.fill(dp2, 1);

        for ( int index=1; index<n; index++){
            for ( int prev = 0; prev <index; prev++){
                if ( arr[index] > arr[prev] && dp1[prev]+1 > dp1[index]){
                    dp1[index] = dp1[prev]+1;
                }
            }
        }

        for ( int index=n-2; index>=0; index--){
            for ( int prev = n-1; prev >index; prev--){
                if ( arr[index] > arr[prev] && dp2[prev]+1 > dp2[index]){
                    dp2[index] = dp2[prev]+1;
                }
            }
        }

        int max = 0;
        for ( int i=0; i<n; i++){
            max = Math.max( max, dp1[i]+dp2[i]-1);
        }
        return max;
    }
}
