package LeetCode;

import java.awt.*;

public class P209MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        for ( int i=0; i< nums.length-1; i++){
            int sum = nums[i];
            for ( int j= i+1; j<nums.length; j++){
                if ( nums[i] >= s ) return 1;
                sum += nums[j];
                if ( sum >= s ){
                    min = Math.min(min, j-i+1);
                    break;
                }
            }
        }
        if ( min == Integer.MAX_VALUE ){
            return 0;
        }
        return min;
    }

    public int minSubArrayLen1(int s, int[] nums) {
        if ( nums== null || nums.length == 0){
            return 0;
        }
        int left =0, right = 0, min = nums.length, sum=0;

        while ( right < nums.length){
            sum+= nums[right++];

            while ( sum >= s){
                min = Math.min( min, right-left);
                sum-=nums[left++];
            }
        }
        return min== nums.length ? 0: min;
    }

    public static void main(String[] args){
        int a[] = {2,3,1,2,4,3};
        P209MinimumSizeSubarraySum obj = new P209MinimumSizeSubarraySum();
        System.out.println(obj.minSubArrayLen1(7, a));
    }
}
