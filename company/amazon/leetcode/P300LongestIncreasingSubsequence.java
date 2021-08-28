package company.amazon.leetcode;

import java.util.Arrays;

public class P300LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if ( nums == null || nums.length == 0){
            return 0;
        }
        int[] lis = new int[nums.length];
        Arrays.fill(lis, 1);
        int max = 0;
        for ( int i =0; i<nums.length; i++){
            for ( int j=0; j<i; j++){
                if ( nums[i] > nums[j] && lis[j]+1 > lis[i]){
                    lis[i] = lis[j]+1;
                    max = Math.max(max, lis[i]);
                }
            }
        }
        return max;
    }
}
