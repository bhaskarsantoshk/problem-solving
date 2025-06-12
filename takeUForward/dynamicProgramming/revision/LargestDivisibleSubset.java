package takeUForward.dynamicProgramming.revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        // 1 2 4 5 8 9 16 32 18 40

        // 1 3 2 4 6 7
        // 1 1 1 1 1 1
        // 1 2 2 3 4 5
        int n = nums.length;
        int []dp = new int[n];
        int hash[] = new int[n];
        int max = 0;
        int lastIndex = 0;
        Arrays.fill(dp, 1);
        for ( int i=0; i<n; i++){
            hash[i] = i;
            for ( int j=0; j<=i-1; j++){
                if ( nums[i] % nums[j] == 0 && 1+ dp[j] > dp[i]){
                    dp[i] = 1+dp[j];
                    hash[i] = j;
                }
            }
            if ( max < dp[i]){
                max = dp[i];
                lastIndex = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        while ( hash[lastIndex] != lastIndex){
            res.add(nums[lastIndex]);
            lastIndex = hash[lastIndex];
        }
        res.add(nums[lastIndex]);
        Collections.reverse(res);
        return res;
    }
}
