package microsoft;

import java.util.Arrays;
import java.util.List;

public class LengthofLongestSubsequence {
    public int longestSubsequenceLength(final List<Integer> A) {
        int lis[] = LIS(A);
        int lds[]= LDS(A);
        int max = 0;
        for(int i=0;i<A.size();i++){
            max = Math.max(lis[i]+lds[i]-1, max);
        }
        return max;
    }

    private int[] LIS(List<Integer> a) {
        int dp[] = new int[a.size()];
        Arrays.fill(dp,1);
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<=i;j++){
                if(a.get(i) > a.get(j) && dp[i] < dp[j]+1){
                    dp[i]=dp[j]+1;
                }
            }
        }
        return dp;
    }

    private int[] LDS(List<Integer> a) {
        int dp[] = new int[a.size()];
        Arrays.fill(dp,1);
        for(int i=dp.length-2;i>=0;i--){
            for(int j=dp.length-1; j>i; j--){
                if(a.get(i) > a.get(j) && dp[i] < dp[j]+1){
                    dp[i]= dp[j]+1;
                }
            }
        }
        return dp;
    }
}
