package LeetCode;

import java.util.Arrays;

public class P159MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {
    public int minDifference(int[] nums) {
        if ( nums == null || nums.length <= 4 ) return 0;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for ( int i=0; i<=3; i++){
            min = Math.min(min, nums[nums.length-4+i] - nums[i]);
        }
        return min;
    }
}
