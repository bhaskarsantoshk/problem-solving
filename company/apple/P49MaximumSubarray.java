package company.apple;

public class P49MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = nums[0];
        for ( int i=1; i<nums.length; i++){
            if ( sum + nums[i] > nums[i]){
                sum = sum+ nums[i];
            } else {
                sum = nums[i];
            }

            max = Math.max( max, sum);
        }
        return max;
    }
}
