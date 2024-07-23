package striver_sde_sheet.arrays;

public class P53MaximumSubarray {
    public int maxSubArray1(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for ( int i=0; i<nums.length; i++){
            for ( int j=i; j<nums.length; j++){
                int sum = 0;
                for ( int k=i; k<=j; k++){
                    sum += nums[k];
                }
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }

    public int maxSubArray2(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for ( int i=0; i<nums.length; i++){
            int sum = 0;
            for ( int j=i; j<nums.length; j++){
                sum += nums[j];
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }

    public int maxSubArrayKadane(int[] nums) {
        int maxSum = nums[0];
        int sum = nums[0];
        for ( int i=1; i<nums.length; i++){
            sum = Math.max(sum+ nums[i], nums[i]);
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}
