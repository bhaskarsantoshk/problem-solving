package company.google.dynamic_programming;

public class P53MaximumSubarray {

    // Brute force
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

    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = nums[0];

        for ( int i=1; i<nums.length; i++){
            // carry a positive number else start from the same index
            // if you have a positive sum until i , the chances for max sum will be there when next num of positive
            sum = Math.max ( sum+nums[i], nums[i]);
            max = Math.max( max, sum);
        }
        return max;
    }
}
