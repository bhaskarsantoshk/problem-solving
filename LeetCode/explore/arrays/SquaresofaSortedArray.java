package LeetCode.explore.arrays;

import java.util.Arrays;

public class SquaresofaSortedArray {
    public int[] sortedSquares(int[] nums) {
        for ( int i=0; i<nums.length; i++){
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}