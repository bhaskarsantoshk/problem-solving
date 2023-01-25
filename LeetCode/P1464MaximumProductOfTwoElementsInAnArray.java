package LeetCode;

import java.util.Arrays;

public class P1464MaximumProductOfTwoElementsInAnArray {
    public int maxProduct1(int[] nums) {
        Arrays.sort(nums);
        int l = nums.length;
        return (nums[l-1] -1) * (nums[l-2]-1);
    }
    
    public int maxProduct(int[] nums) {
        int max1= Integer.MIN_VALUE;
        int max2= Integer.MAX_VALUE;

        for ( int num : nums ){
            if ( num > max1){
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
        }
        return (max1-1) * (max2-1);
    }
}
