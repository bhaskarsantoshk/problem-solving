package interviewbit.dynamic_programming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LengthofLongestSubsequence {
    public int longestSubsequenceLength(final List<Integer> A) {
        if ( A == null || A.size() == 0) return 0;
        int LIS[] = lis(A);
        int LISrev[] = lisRearEnd(A);
        int maxLen = 0;
        for ( int i=0; i< A.size(); i++){
            maxLen = Math.max ( maxLen, LIS[i] + LISrev[i]-1);
        }
        return maxLen;
    }

    private int[] lisRearEnd(List<Integer> a) {
        int lisR[] = new int[a.size()];
        Arrays.fill(lisR, 1);
        for ( int i= a.size()-1; i>=0; i--){
            for ( int j=a.size()-1; j>=i ; j--){
                if ( a.get(i) > a.get(j) && lisR[i] < lisR[j] + 1){
                    lisR[i] = lisR[j] + 1;
                }
            }
        }
        return lisR;
    }

    private int[] lis(List<Integer> a) {
        int lis[] = new int[a.size()];
        Arrays.fill(lis, 1);
        for ( int i=0; i< lis.length; i++){
            for ( int j=0; j<=i; j++){
                if ( a.get(i) > a.get(j) && lis[i] < lis[j] + 1){
                    lis[i] = lis[j] + 1;
                }
            }
        }
        return lis;
    }
}
