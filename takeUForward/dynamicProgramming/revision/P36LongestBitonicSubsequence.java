package takeUForward.dynamicProgramming.revision;

import java.util.Arrays;

public class P36LongestBitonicSubsequence {
    public int LongestBitonicSequence(int[] arr) {
        int n = arr.length;
        int []dp2 = new int[n];
        int []dp1 = new int[n];

        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);

        for ( int i=0; i<n; i++){
            for ( int j=0; j<=i-1; j++){
                if ( arr[i] > arr[j] && 1+dp1[j] > dp1[i]){
                    dp1[i] = 1+dp1[j];
                }
            }
        }

        for ( int i=n-1; i>=0; i--){
            for ( int j=n-1; j>i; j--){
                if ( arr[i] > arr[j] && 1+dp2[j] > dp2[i]){
                    dp2[i] = 1+dp2[j];
                }
            }
        }

        int max =1;
        for ( int i=0; i<n; i++){
            max = Math.max(max, dp1[i]+dp2[i]-1);
        }

        return max;
    }
}
