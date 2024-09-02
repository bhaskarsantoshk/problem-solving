package takeUForward.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DP44LargestDivisibleSubsetLongestIncreasingSubsequence {
    public static List< Integer > divisibleSet(int []arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int []dp = new int[n];
        Arrays.fill(dp, 1);
        int hash[] = new int[n];
        int lastIndex = -1;
        int max = 0;
        for ( int i=1; i<n; i++){
            hash[i] = i;
            for ( int prev = 0; prev<i; prev++){
                if ( arr[i] % arr[prev] == 0 && dp[prev]+1 > dp[i]){
                    dp[i] = dp[prev]+1;
                    hash[i] = prev;
                }
            }
            if ( dp[i] > max){
                max = dp[i];
                lastIndex = i;
            }
        }
        List<Integer> lis = new ArrayList<>();
        lis.add(arr[lastIndex]);
        while (hash[lastIndex] != lastIndex){
            lastIndex = hash[lastIndex];
            lis.add(arr[lastIndex]);
        }
        Collections.reverse(lis);
        return lis;
    }
}
