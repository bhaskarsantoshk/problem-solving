package LeetCode;

public class P53MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int local_sum = nums[0];
        int global_sum = nums[0];
        for(int i=1; i<nums.length; i++){
            local_sum = Math.max(nums[i], nums[i]+local_sum);
            global_sum = Math.max(global_sum, local_sum);
        }
        return global_sum;
    }
}
