package LeetCode;

import java.util.Arrays;

public class P16_3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[2];
        int closestSum = sum;
        for(int i=0; i<nums.length-2; i++){
            int start = i+1;
            int end = nums.length-1;
            while ( start < end ){
                sum = nums[i] + nums[start] + nums[end];
                if( target == sum ){
                    return target;
                }
                else if ( sum > target ){
                    end --;
                }
                else{
                    start ++;
                }
                if (Math.abs( target - sum) < Math.abs( target - closestSum)){
                    closestSum = sum;
                }
            }
        }
        return closestSum;
    }
}
