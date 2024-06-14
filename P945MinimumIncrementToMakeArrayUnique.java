package LeetCode;

import java.util.Arrays;

public class P945MinimumIncrementToMakeArrayUnique {
    public int minIncrementForUnique(int[] nums) {
        if (nums == null || nums.length == 0) { return 0;}
        int need =0, res=0;
        Arrays.sort(nums);
        // try to make it an increasing array
        // curr 'needs' to be at least prev+1
        for ( int num: nums){
            res += Math.max( need-num, 0);
            need = Math.max(need, num)+1;
        }
        return res;
    }
}
