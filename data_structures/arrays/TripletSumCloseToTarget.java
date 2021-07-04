package data_structures.arrays;

import java.util.Arrays;

public class TripletSumCloseToTarget {
    public static int getTripletSumCloseToTarget ( int[] nums, int targetSum){
        if ( nums == null || nums.length == 0 || nums.length < 3){
            throw new IllegalArgumentException();
        }
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;

        for ( int i=0; i<nums.length-2; i++){
            int start = i+1, end = nums.length-1;

            while (start < end ){
                int sum = nums[i] + nums[start] + nums[end];
                if ( targetSum == sum ){
                    return sum;
                }
                else if ( targetSum > sum ){
                    start++;
                }
                else {
                    end--;
                }
                if ( minDiff > Math.abs(targetSum - sum )){
                    minDiff = Math.abs(targetSum - sum );
                }
            }
        }
        return targetSum-minDiff;
    }
}
