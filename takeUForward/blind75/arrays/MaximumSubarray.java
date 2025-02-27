package takeUForward.blind75.arrays;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = nums[0];

        for ( int i=1; i<nums.length; i++){
            // carry a positive number else start from the same index
            // if you have a positive sum until i , the chances for max sum will be there when next num of positive
            sum = Math.max( sum+ nums[i], nums[i]);
            max = Math.max( sum, max);
        }
        return max;
    }
}
