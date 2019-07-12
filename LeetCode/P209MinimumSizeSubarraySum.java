package LeetCode;

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

    }
}
