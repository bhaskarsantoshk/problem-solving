package takeUForward.QR;

public class P3KadaneSAlgorithm {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int sum = nums[0];
        for ( int i=1; i<nums.length; i++){
            sum = Math.max(sum+ nums[i], nums[i]);
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}
