package company.microsoft.two_pointers;

public class P209MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        for ( int right = 0; right < nums.length; right++){
            sum += nums[right];
            while ( sum >= target ){
                res = Math.min(res, right - left+1);
                sum -= nums[left];
                left++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
